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
import com.leesungbok.kyoutuubuhinn.Cyoutuubuhinn;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MusicUpdate_Ctl {

	private static String listno = null;
	private static String c_muspic1 = null;
	private static String c_muspic2 = null;
	private static String c_muspic3 = null;
	private static String c_muspic4 = null;

	@RequestMapping(value = "musicupdate", method = RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {

		// 共通部品（NULLチェック）
		Cyoutuubuhinn cyoutuu = new Cyoutuubuhinn();

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

		// 掲示物の番号を取得。
		listno = request.getParameter("listno");

		// プログラミング関連データを呼び出す。
		// 掲示物の番号を条件としてデータを取得する。
		MusicListDto musictext = new MusicListDto();
		AbstractApplicationContext select_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MusicDao sel_musicDao = select_ctx.getBean("musicDao", MusicDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。
		if (!cyoutuu.nullCheck(listno)) {
			musictext = sel_musicDao.allSelectListno(listno);
		}
		select_ctx.close();

		// typeデータをJSP形式に変更。
		String dbtype = musictext.getMustype();

		request.setAttribute("mustype", dbtype);

		if (dbtype.equals("KPOP")) {
			dbtype = "mus_korea";
		} else if (dbtype.equals("JPOP")) {
			dbtype = "mus_japan";
		} else if (dbtype.equals("APOP")) {
			dbtype = "mus_american";
		} else {
			dbtype = "mus_other";
		}

		musictext.setMustype(dbtype);

		// descriptionデータをJSP形式に変更。
		String dbdescription = musictext.getDescription();
		dbdescription = dbdescription.replaceAll("<br>", "\r\n");
		musictext.setDescription(dbdescription);

		c_muspic1 = musictext.getMuspic1();
		c_muspic2 = musictext.getMuspic2();
		c_muspic3 = musictext.getMuspic3();
		c_muspic4 = musictext.getMuspic4();

		request.setAttribute("musictext", musictext);
		return "musicupdate";
	}

	@RequestMapping(value = "musicupdate", method = RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {

		// 共通部品（NULLチェック）
		Cyoutuubuhinn cyoutuu = new Cyoutuubuhinn();

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

		// // 入力.PICURL1~4を変数に設定する作業。
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("IMG/upload");
		String encoding = "UTF-8";
		int size = 100 * 1024 * 1024;

		// 掲示物の番号を取得。
		int no_listno = Integer.parseInt(listno);
		String mustype = null;
		String title = null;
		String description = null;
		String muspic1 = null;
		String muspic2 = null;
		String muspic3 = null;
		String muspic4 = null;

		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, encoding, new DefaultFileRenamePolicy());

			mustype = (String) multi.getParameter("update_type");
			title = (String) multi.getParameter("update_title");
			description = (String) multi.getParameter("update_description");

			muspic1 = (String) multi.getFilesystemName("mus_pic1");
			muspic2 = (String) multi.getFilesystemName("mus_pic2");
			muspic3 = (String) multi.getFilesystemName("mus_pic3");
			muspic4 = (String) multi.getFilesystemName("mus_pic4");

			if(cyoutuu.nullCheck(muspic1)){
				muspic1 = c_muspic1;
			}
			if(cyoutuu.nullCheck(muspic2)){
				muspic2 = c_muspic2;
			}
			if(cyoutuu.nullCheck(muspic3)){
				muspic3 = c_muspic3;
			}
			if(cyoutuu.nullCheck(muspic4)){
				muspic4 = c_muspic4;
			}

			// typeのJSP形式をDB化
			if (mustype.equals("mus_korea")) {
				mustype = "KPOP";
			} else if (mustype.equals("mus_japan")) {
				mustype = "JPOP";
			} else if (mustype.equals("mus_american")) {
				mustype = "APOP";
			} else {
				mustype = "OTHER";
			}

			// descriptionのJSP形式をDB化
			description = description.replaceAll("\r\n", "<br>");

		} catch (Exception e) {
			// データのアップロードを失敗した場合。
			request.setAttribute("message", "ファイルアップロードに失敗しました。");
			return "musicsuccess";
		}

		// プログラミング関連データを呼び出す。
		// 掲示物の番号を条件としてデータを更新する。
		MusicListDto updatedto = new MusicListDto();

		updatedto.setListno(no_listno);
		updatedto.setMustype(mustype);
		updatedto.setTitle(title);
		updatedto.setDescription(description);
		updatedto.setMuspic1(muspic1);
		updatedto.setMuspic2(muspic2);
		updatedto.setMuspic3(muspic3);
		updatedto.setMuspic4(muspic4);

		AbstractApplicationContext update_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MusicDao upd_musicDao = update_ctx.getBean("musicDao", MusicDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。

		int dbresultflg = 0;
		if (no_listno != 0) {
			dbresultflg = upd_musicDao.allUpdatelistno(updatedto);
		}

		update_ctx.close();

		// 異常の場合
		if (dbresultflg == 1) {
			request.setAttribute("message", "データ更新に失敗しました。");
			return "musicsuccess";
		}

		request.setAttribute("message", "修正されました。");
		return "musicsuccess";
	}
}
