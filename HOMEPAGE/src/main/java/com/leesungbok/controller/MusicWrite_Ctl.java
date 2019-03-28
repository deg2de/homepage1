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

import com.leesungbok.dao.MusicDao;
import com.leesungbok.dto.LoginUserDto;
import com.leesungbok.dto.MusicListDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MusicWrite_Ctl {

	@RequestMapping(value="musicwrite", method=RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();
		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は作成画面を出力する。
		// sessionの"loginuser"情報がない場合はログイン要求メッセージを出力する。
		if (loginuserdto == null) {
			request.setAttribute("message", "ログインしてください。");
			return "musicsuccess";
		}

		return "musicwrite";
	}

	@RequestMapping(value="musicwrite", method=RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();
		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は作成処理を進む。
		// sessionの"loginuser"情報がない場合はログイン要求メッセージを出力する。
		if (loginuserdto == null) {
			request.setAttribute("message", "ログインしてください。");
			return "musicsuccess";
		}

		// 入力.TYPE
		String mus_type = null;
		// 入力.TITLE
		String mus_title = null;
		// ログイン.USERID
		String mus_userid = null;
		// 入力.DESCRIPTION
		String mus_description = null;
		// 入力.PICURL1
		String mus_pic1 = null;
		// 入力.PICURL2
		String mus_pic2 = null;
		// 入力.PICURL3
		String mus_pic3 = null;
		// 入力.PICURL4
		String mus_pic4 = null;

		// // 入力.PICURL1~4を変数に設定する作業。
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("IMG/upload");
		String encoding = "UTF-8";
		int size = 100 * 1024 * 1024;

		try{
			MultipartRequest multi = new MultipartRequest(request, path, size, encoding, new DefaultFileRenamePolicy());

			// ファイル設定および中腹の場合処理。
			// 入力.TYPE
			mus_type = multi.getParameter("write_type");
			if(mus_type.equals("mus_korea")) {
				mus_type = "KPOP";
			} else if(mus_type.equals("mus_japan")) {
				mus_type = "JPOP";
			} else if(mus_type.equals("mus_american")) {
				mus_type = "APOP";
			}  else {
				mus_type = "OTHER";
			}
			// 入力.TITLE
			mus_title = multi.getParameter("write_title");
			// ログイン.USERID
			mus_userid = loginuserdto.getUserid();
			// 入力.DESCRIPTION
			mus_description = multi.getParameter("write_description");
			mus_description = mus_description.replaceAll("\r\n", "<br>");
			// 入力.PICURL1~4
			mus_pic1 = multi.getFilesystemName("mus_pic1");
			mus_pic2 = multi.getFilesystemName("mus_pic2");
			mus_pic3 = multi.getFilesystemName("mus_pic3");
			mus_pic4 = multi.getFilesystemName("mus_pic4");

		} catch(Exception e){
			// データのアップロードを失敗した場合。
			request.setAttribute("message", "ファイルアップロードに失敗しました。");
			return "musicsuccess";
		}

		// DB登録用のDTOを設定する。
		MusicListDto musicListDto = new MusicListDto();
		musicListDto.setMustype(mus_type);
		musicListDto.setTitle(mus_title);
		musicListDto.setUserid(mus_userid);
		musicListDto.setMuscount(0);
		musicListDto.setDescription(mus_description);
		musicListDto.setMuspic1(mus_pic1);
		musicListDto.setMuspic2(mus_pic2);
		musicListDto.setMuspic3(mus_pic3);
		musicListDto.setMuspic4(mus_pic4);

		// プログラミング関連データを呼び出す。
		// データに登録する。
		AbstractApplicationContext insert_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MusicDao musicDao = insert_ctx.getBean("musicDao", MusicDao.class);

		musicDao.insertMusic(musicListDto);
		insert_ctx.close();


		// 作成成功メッセージ
		request.setAttribute("message", "掲示物を登録しました。");

		return "musicsuccess";
	}
}
