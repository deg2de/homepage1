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
import com.leesungbok.kyoutuubuhinn.Cyoutuubuhinn;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class TravelUpdate_Ctl {

	private static String listno = null;
	private static String c_trapic1 = null;
	private static String c_trapic2 = null;
	private static String c_trapic3 = null;
	private static String c_trapic4 = null;

	@RequestMapping(value = "travelupdate", method = RequestMethod.GET)
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
			return "travelsuccess";
		}

		// 掲示物の番号を取得。
		listno = request.getParameter("listno");

		// プログラミング関連データを呼び出す。
		// 掲示物の番号を条件としてデータを取得する。
		TravelListDto traveltext = new TravelListDto();
		AbstractApplicationContext select_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		TravelDao sel_travelDao = select_ctx.getBean("travelDao", TravelDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。
		if (!cyoutuu.nullCheck(listno)) {
			traveltext = sel_travelDao.allSelectListno(listno);
		}
		select_ctx.close();

		// typeデータをJSP形式に変更。
		String dbtype = traveltext.getTratype();

		request.setAttribute("tratype", dbtype);

		if (dbtype.equals("KOREA")) {
			dbtype = "tra_korea";
		} else if (dbtype.equals("JAPAN")) {
			dbtype = "tra_japan";
		} else if (dbtype.equals("TAIWAN")) {
			dbtype = "tra_taiwan";
		} else if (dbtype.equals("CHINA")) {
			dbtype = "tra_china";
		} else if (dbtype.equals("USA")) {
			dbtype = "tra_usa";
		} else {
			dbtype = "tra_other";
		}

		traveltext.setTratype(dbtype);

		// descriptionデータをJSP形式に変更。
		String dbdescription = traveltext.getDescription();
		dbdescription = dbdescription.replaceAll("<br>", "\r\n");
		traveltext.setDescription(dbdescription);

		c_trapic1 = traveltext.getTrapic1();
		c_trapic2 = traveltext.getTrapic2();
		c_trapic3 = traveltext.getTrapic3();
		c_trapic4 = traveltext.getTrapic4();

		request.setAttribute("traveltext", traveltext);
		return "travelupdate";
	}

	@RequestMapping(value = "travelupdate", method = RequestMethod.POST)
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
			return "travelsuccess";
		}

		// // 入力.PICURL1~4を変数に設定する作業。
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("IMG/upload");
		String encoding = "UTF-8";
		int size = 100 * 1024 * 1024;

		// 掲示物の番号を取得。
		int no_listno = Integer.parseInt(listno);
		String tratype = null;
		String title = null;
		String description = null;
		String trapic1 = null;
		String trapic2 = null;
		String trapic3 = null;
		String trapic4 = null;

		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, encoding, new DefaultFileRenamePolicy());

			tratype = (String) multi.getParameter("update_type");
			title = (String) multi.getParameter("update_title");
			description = (String) multi.getParameter("update_description");

			trapic1 = (String) multi.getFilesystemName("tra_pic1");
			trapic2 = (String) multi.getFilesystemName("tra_pic2");
			trapic3 = (String) multi.getFilesystemName("tra_pic3");
			trapic4 = (String) multi.getFilesystemName("tra_pic4");

			if(cyoutuu.nullCheck(trapic1)){
				trapic1 = c_trapic1;
			}
			if(cyoutuu.nullCheck(trapic2)){
				trapic2 = c_trapic2;
			}
			if(cyoutuu.nullCheck(trapic3)){
				trapic3 = c_trapic3;
			}
			if(cyoutuu.nullCheck(trapic4)){
				trapic4 = c_trapic4;
			}

			// typeのJSP形式をDB化
			if (tratype.equals("tra_korea")) {
				tratype = "KOREA";
			} else if (tratype.equals("tra_japan")) {
				tratype = "JAPAN";
			} else if (tratype.equals("tra_china")) {
				tratype = "CHINA";
			} else if (tratype.equals("tra_taiwan")) {
				tratype = "TAIWAN";
			} else if (tratype.equals("tra_usa")) {
				tratype = "USA";
			} else {
				tratype = "OTHER";
			}

			// descriptionのJSP形式をDB化
			description = description.replaceAll("\r\n", "<br>");

		} catch (Exception e) {
			// データのアップロードを失敗した場合。
			request.setAttribute("message", "ファイルアップロードに失敗しました。");
			return "travelsuccess";
		}

		// プログラミング関連データを呼び出す。
		// 掲示物の番号を条件としてデータを更新する。
		TravelListDto updatedto = new TravelListDto();

		updatedto.setListno(no_listno);
		updatedto.setTratype(tratype);
		updatedto.setTitle(title);
		updatedto.setDescription(description);
		updatedto.setTrapic1(trapic1);
		updatedto.setTrapic2(trapic2);
		updatedto.setTrapic3(trapic3);
		updatedto.setTrapic4(trapic4);

		AbstractApplicationContext update_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		TravelDao upd_travelDao = update_ctx.getBean("travelDao", TravelDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。

		int dbresultflg = 0;
		if (no_listno != 0) {
			dbresultflg = upd_travelDao.allUpdatelistno(updatedto);
		}

		update_ctx.close();

		// 異常の場合
		if (dbresultflg == 1) {
			request.setAttribute("message", "データ更新に失敗しました。");
			return "travelsuccess";
		}

		request.setAttribute("message", "修正されました。");
		return "travelsuccess";
	}
}
