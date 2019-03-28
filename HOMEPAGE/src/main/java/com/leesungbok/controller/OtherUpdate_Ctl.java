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
import com.leesungbok.kyoutuubuhinn.Cyoutuubuhinn;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class OtherUpdate_Ctl {

	private static String listno = null;
	private static String c_othpic1 = null;
	private static String c_othpic2 = null;
	private static String c_othpic3 = null;
	private static String c_othpic4 = null;

	@RequestMapping(value = "otherupdate", method = RequestMethod.GET)
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
			return "othersuccess";
		}

		// 掲示物の番号を取得。
		listno = request.getParameter("listno");

		// プログラミング関連データを呼び出す。
		// 掲示物の番号を条件としてデータを取得する。
		OtherListDto othertext = new OtherListDto();
		AbstractApplicationContext select_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		OtherDao sel_otherDao = select_ctx.getBean("otherDao", OtherDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。
		if (!cyoutuu.nullCheck(listno)) {
			othertext = sel_otherDao.allSelectListno(listno);
		}
		select_ctx.close();

		// typeデータをJSP形式に変更。
		String dbtype = othertext.getOthtype();

		request.setAttribute("othtype", dbtype);

		dbtype = "oth_other";

		othertext.setOthtype(dbtype);

		// descriptionデータをJSP形式に変更。
		String dbdescription = othertext.getDescription();
		dbdescription = dbdescription.replaceAll("<br>", "\r\n");
		othertext.setDescription(dbdescription);

		c_othpic1 = othertext.getOthpic1();
		c_othpic2 = othertext.getOthpic2();
		c_othpic3 = othertext.getOthpic3();
		c_othpic4 = othertext.getOthpic4();

		request.setAttribute("othertext", othertext);
		return "otherupdate";
	}

	@RequestMapping(value = "otherupdate", method = RequestMethod.POST)
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
			return "othersuccess";
		}

		// // 入力.PICURL1~4を変数に設定する作業。
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("IMG/upload");
		String encoding = "UTF-8";
		int size = 100 * 1024 * 1024;

		// 掲示物の番号を取得。
		int no_listno = Integer.parseInt(listno);
		String othtype = null;
		String title = null;
		String description = null;
		String othpic1 = null;
		String othpic2 = null;
		String othpic3 = null;
		String othpic4 = null;

		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, encoding, new DefaultFileRenamePolicy());

			othtype = (String) multi.getParameter("update_type");
			title = (String) multi.getParameter("update_title");
			description = (String) multi.getParameter("update_description");

			othpic1 = (String) multi.getFilesystemName("oth_pic1");
			othpic2 = (String) multi.getFilesystemName("oth_pic2");
			othpic3 = (String) multi.getFilesystemName("oth_pic3");
			othpic4 = (String) multi.getFilesystemName("oth_pic4");

			if(cyoutuu.nullCheck(othpic1)){
				othpic1 = c_othpic1;
			}
			if(cyoutuu.nullCheck(othpic2)){
				othpic2 = c_othpic2;
			}
			if(cyoutuu.nullCheck(othpic3)){
				othpic3 = c_othpic3;
			}
			if(cyoutuu.nullCheck(othpic4)){
				othpic4 = c_othpic4;
			}

			// typeのJSP形式をDB化
			othtype = "OTHER";

			// descriptionのJSP形式をDB化
			description = description.replaceAll("\r\n", "<br>");

		} catch (Exception e) {
			// データのアップロードを失敗した場合。
			request.setAttribute("message", "ファイルアップロードに失敗しました。");
			return "othersuccess";
		}

		// プログラミング関連データを呼び出す。
		// 掲示物の番号を条件としてデータを更新する。
		OtherListDto updatedto = new OtherListDto();

		updatedto.setListno(no_listno);
		updatedto.setOthtype(othtype);
		updatedto.setTitle(title);
		updatedto.setDescription(description);
		updatedto.setOthpic1(othpic1);
		updatedto.setOthpic2(othpic2);
		updatedto.setOthpic3(othpic3);
		updatedto.setOthpic4(othpic4);

		AbstractApplicationContext update_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		OtherDao upd_otherDao = update_ctx.getBean("otherDao", OtherDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。

		int dbresultflg = 0;
		if (no_listno != 0) {
			dbresultflg = upd_otherDao.allUpdatelistno(updatedto);
		}

		update_ctx.close();

		// 異常の場合
		if (dbresultflg == 1) {
			request.setAttribute("message", "データ更新に失敗しました。");
			return "othersuccess";
		}

		request.setAttribute("message", "修正されました。");
		return "othersuccess";
	}
}
