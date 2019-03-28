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

import com.leesungbok.dao.TravelDao;
import com.leesungbok.dto.LoginUserDto;
import com.leesungbok.dto.TravelListDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class TravelWrite_Ctl {

	@RequestMapping(value="travelwrite", method=RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();
		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は作成画面を出力する。
		// sessionの"loginuser"情報がない場合はログイン要求メッセージを出力する。
		if (loginuserdto == null) {
			request.setAttribute("message", "ログインしてください。");
			return "travelsuccess";
		}

		return "travelwrite";
	}

	@RequestMapping(value="travelwrite", method=RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();
		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は作成処理を進む。
		// sessionの"loginuser"情報がない場合はログイン要求メッセージを出力する。
		if (loginuserdto == null) {
			request.setAttribute("message", "ログインしてください。");
			return "travelsuccess";
		}

		// 入力.TYPE
		String tra_type = null;
		// 入力.TITLE
		String tra_title = null;
		// ログイン.USERID
		String tra_userid = null;
		// 入力.DESCRIPTION
		String tra_description = null;
		// 入力.PICURL1
		String tra_pic1 = null;
		// 入力.PICURL2
		String tra_pic2 = null;
		// 入力.PICURL3
		String tra_pic3 = null;
		// 入力.PICURL4
		String tra_pic4 = null;

		// // 入力.PICURL1~4を変数に設定する作業。
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("IMG/upload");
		String encoding = "UTF-8";
		int size = 100 * 1024 * 1024;

		try{
			MultipartRequest multi = new MultipartRequest(request, path, size, encoding, new DefaultFileRenamePolicy());

			// ファイル設定および中腹の場合処理。
			// 入力.TYPE
			tra_type = multi.getParameter("write_type");
			if(tra_type.equals("tra_korea")) {
				tra_type = "KOREA";
			} else if(tra_type.equals("tra_japan")) {
				tra_type = "JAPAN";
			} else if(tra_type.equals("tra_taiwan")) {
				tra_type = "TAIWAN";
			} else if(tra_type.equals("tra_china")) {
				tra_type = "CHINA";
			} else if(tra_type.equals("tra_usa")) {
				tra_type = "USA";
			} else {
				tra_type = "OTHER";
			}
			// 入力.TITLE
			tra_title = multi.getParameter("write_title");
			// ログイン.USERID
			tra_userid = loginuserdto.getUserid();
			// 入力.DESCRIPTION
			tra_description = multi.getParameter("write_description");
			tra_description = tra_description.replaceAll("\r\n", "<br>");
			// 入力.PICURL1~4
			tra_pic1 = multi.getFilesystemName("tra_pic1");
			tra_pic2 = multi.getFilesystemName("tra_pic2");
			tra_pic3 = multi.getFilesystemName("tra_pic3");
			tra_pic4 = multi.getFilesystemName("tra_pic4");

		} catch(Exception e){
			// データのアップロードを失敗した場合。
			request.setAttribute("message", "ファイルアップロードに失敗しました。");
			return "travelsuccess";
		}

		// DB登録用のDTOを設定する。
		TravelListDto travelListDto = new TravelListDto();
		travelListDto.setTratype(tra_type);
		travelListDto.setTitle(tra_title);
		travelListDto.setUserid(tra_userid);
		travelListDto.setTracount(0);
		travelListDto.setDescription(tra_description);
		travelListDto.setTrapic1(tra_pic1);
		travelListDto.setTrapic2(tra_pic2);
		travelListDto.setTrapic3(tra_pic3);
		travelListDto.setTrapic4(tra_pic4);

		// プログラミング関連データを呼び出す。
		// データに登録する。
		AbstractApplicationContext insert_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		TravelDao travelDao = insert_ctx.getBean("travelDao", TravelDao.class);

		travelDao.insertTravel(travelListDto);
		insert_ctx.close();


		// 作成成功メッセージ
		request.setAttribute("message", "掲示物を登録しました。");

		return "travelsuccess";
	}
}
