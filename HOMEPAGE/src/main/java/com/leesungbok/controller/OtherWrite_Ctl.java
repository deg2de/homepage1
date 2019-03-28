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

import com.leesungbok.dao.OtherDao;
import com.leesungbok.dto.LoginUserDto;
import com.leesungbok.dto.OtherListDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class OtherWrite_Ctl {

	@RequestMapping(value="otherwrite", method=RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();
		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は作成画面を出力する。
		// sessionの"loginuser"情報がない場合はログイン要求メッセージを出力する。
		if (loginuserdto == null) {
			request.setAttribute("message", "ログインしてください。");
			return "othersuccess";
		}

		return "otherwrite";
	}

	@RequestMapping(value="otherwrite", method=RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();
		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は作成処理を進む。
		// sessionの"loginuser"情報がない場合はログイン要求メッセージを出力する。
		if (loginuserdto == null) {
			request.setAttribute("message", "ログインしてください。");
			return "othersuccess";
		}

		// 入力.TYPE
		String oth_type = null;
		// 入力.TITLE
		String oth_title = null;
		// ログイン.USERID
		String oth_userid = null;
		// 入力.DESCRIPTION
		String oth_description = null;
		// 入力.PICURL1
		String oth_pic1 = null;
		// 入力.PICURL2
		String oth_pic2 = null;
		// 入力.PICURL3
		String oth_pic3 = null;
		// 入力.PICURL4
		String oth_pic4 = null;

		// // 入力.PICURL1~4を変数に設定する作業。
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("IMG/upload");
		String encoding = "UTF-8";
		int size = 100 * 1024 * 1024;

		try{
			MultipartRequest multi = new MultipartRequest(request, path, size, encoding, new DefaultFileRenamePolicy());

			// ファイル設定および中腹の場合処理。
			// 入力.TYPE
			oth_type = multi.getParameter("write_type");
			oth_type = "OTHER";

			// 入力.TITLE
			oth_title = multi.getParameter("write_title");
			// ログイン.USERID
			oth_userid = loginuserdto.getUserid();
			// 入力.DESCRIPTION
			oth_description = multi.getParameter("write_description");
			oth_description = oth_description.replaceAll("\r\n", "<br>");
			// 入力.PICURL1~4
			oth_pic1 = multi.getFilesystemName("oth_pic1");
			oth_pic2 = multi.getFilesystemName("oth_pic2");
			oth_pic3 = multi.getFilesystemName("oth_pic3");
			oth_pic4 = multi.getFilesystemName("oth_pic4");

		} catch(Exception e){
			// データのアップロードを失敗した場合。
			request.setAttribute("message", "ファイルアップロードに失敗しました。");
			return "othersuccess";
		}

		// DB登録用のDTOを設定する。
		OtherListDto otherListDto = new OtherListDto();
		otherListDto.setOthtype(oth_type);
		otherListDto.setTitle(oth_title);
		otherListDto.setUserid(oth_userid);
		otherListDto.setOthcount(0);
		otherListDto.setDescription(oth_description);
		otherListDto.setOthpic1(oth_pic1);
		otherListDto.setOthpic2(oth_pic2);
		otherListDto.setOthpic3(oth_pic3);
		otherListDto.setOthpic4(oth_pic4);

		// プログラミング関連データを呼び出す。
		// データに登録する。
		AbstractApplicationContext insert_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		OtherDao otherDao = insert_ctx.getBean("otherDao", OtherDao.class);

		otherDao.insertOther(otherListDto);
		insert_ctx.close();


		// 作成成功メッセージ
		request.setAttribute("message", "掲示物を登録しました。");

		return "othersuccess";
	}
}
