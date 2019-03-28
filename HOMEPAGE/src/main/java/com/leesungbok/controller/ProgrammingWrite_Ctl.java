package com.leesungbok.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leesungbok.dao.ProgrammingDao;
import com.leesungbok.dto.LoginUserDto;
import com.leesungbok.dto.ProgrammingListDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class ProgrammingWrite_Ctl {

	@RequestMapping(value="programmingwrite", method=RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();
		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は作成画面を出力する。
		// sessionの"loginuser"情報がない場合はログイン要求メッセージを出力する。
		if (loginuserdto == null) {
			request.setAttribute("message", "ログインしてください。");
			return "programmingsuccess";
		}

		return "programmingwrite";
	}

	@RequestMapping(value="programmingwrite", method=RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();
		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は作成処理を進む。
		// sessionの"loginuser"情報がない場合はログイン要求メッセージを出力する。
		if (loginuserdto == null) {
			request.setAttribute("message", "ログインしてください。");
			return "programmingsuccess";
		}

		// 入力.TYPE
		String pro_type = null;
		// 入力.TITLE
		String pro_title = null;
		// ログイン.USERID
		String pro_userid = null;
		// 入力.DESCRIPTION
		String pro_description = null;
		// 入力.PICURL1
		String pro_pic1 = null;
		// 入力.PICURL2
		String pro_pic2 = null;
		// 入力.PICURL3
		String pro_pic3 = null;
		// 入力.PICURL4
		String pro_pic4 = null;

		// // 入力.PICURL1~4を変数に設定する作業。
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("IMG/upload");
		String encoding = "UTF-8";
		int size = 100 * 1024 * 1024;

		try{
			MultipartRequest multi = new MultipartRequest(request, path, size, encoding, new DefaultFileRenamePolicy());

			// ファイル設定および中腹の場合処理。
			// 入力.TYPE
			pro_type = multi.getParameter("write_type");
			if(pro_type.equals("pro_html")) {
				pro_type = "HTML";
			} else if(pro_type.equals("pro_css")) {
				pro_type = "CSS";
			} else if(pro_type.equals("pro_javascript")) {
				pro_type = "JavaScript";
			} else if(pro_type.equals("pro_java")) {
				pro_type = "JAVA";
			} else if(pro_type.equals("pro_jsp")) {
				pro_type = "JSP";
			} else if(pro_type.equals("pro_php")) {
				pro_type = "PHP";
			} else if(pro_type.equals("pro_oracle")) {
				pro_type = "ORACLE";
			} else if(pro_type.equals("pro_mysql")) {
				pro_type = "MySQL";
			} else if(pro_type.equals("pro_spring")) {
				pro_type = "SPRING";
			} else if(pro_type.equals("pro_xml")) {
				pro_type = "XML";
			} else if(pro_type.equals("pro_c")) {
				pro_type = "C";
			} else if(pro_type.equals("pro_cplus2")) {
				pro_type = "C++";
			} else if(pro_type.equals("pro_csharp")) {
				pro_type = "C#";
			} else if(pro_type.equals("pro_windows")) {
				pro_type = "WINDOWS";
			} else if(pro_type.equals("pro_linux")) {
				pro_type = "LINUX";
			} else {
				pro_type = "OTHER";
			}
			// 入力.TITLE
			pro_title = multi.getParameter("write_title");
			// ログイン.USERID
			pro_userid = loginuserdto.getUserid();
			// 入力.DESCRIPTION
			pro_description = multi.getParameter("write_description");
			pro_description = pro_description.replaceAll("\r\n", "<br>");
			// 入力.PICURL1~4
			pro_pic1 = multi.getFilesystemName("pro_pic1");
			pro_pic2 = multi.getFilesystemName("pro_pic2");
			pro_pic3 = multi.getFilesystemName("pro_pic3");
			pro_pic4 = multi.getFilesystemName("pro_pic4");

		} catch(Exception e){
			// データのアップロードを失敗した場合。
			request.setAttribute("message", "ファイルアップロードに失敗しました。");
			return "programmingsuccess";
		}

		// DB登録用のDTOを設定する。
		ProgrammingListDto programmingListDto = new ProgrammingListDto();
		programmingListDto.setProtype(pro_type);
		programmingListDto.setTitle(pro_title);
		programmingListDto.setUserid(pro_userid);
		programmingListDto.setProcount(0);
		programmingListDto.setDescription(pro_description);
		programmingListDto.setPropic1(pro_pic1);
		programmingListDto.setPropic2(pro_pic2);
		programmingListDto.setPropic3(pro_pic3);
		programmingListDto.setPropic4(pro_pic4);

		// プログラミング関連データを呼び出す。
		// データに登録する。
		AbstractApplicationContext insert_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		ProgrammingDao programmingDao = insert_ctx.getBean("programmingDao", ProgrammingDao.class);

		programmingDao.insertProgramming(programmingListDto);
		insert_ctx.close();


		// 作成成功メッセージ
		request.setAttribute("message", "掲示物を登録しました。");

		return "programmingsuccess";
	}
}
