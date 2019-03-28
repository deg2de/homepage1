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
import com.leesungbok.kyoutuubuhinn.Cyoutuubuhinn;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class ProgrammingUpdate_Ctl {

	private static String listno = null;
	private static String c_propic1 = null;
	private static String c_propic2 = null;
	private static String c_propic3 = null;
	private static String c_propic4 = null;

	@RequestMapping(value = "programmingupdate", method = RequestMethod.GET)
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
			return "programmingsuccess";
		}

		// 掲示物の番号を取得。
		listno = request.getParameter("listno");

		// プログラミング関連データを呼び出す。
		// 掲示物の番号を条件としてデータを取得する。
		ProgrammingListDto programmingtext = new ProgrammingListDto();
		AbstractApplicationContext select_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		ProgrammingDao sel_programmingDao = select_ctx.getBean("programmingDao", ProgrammingDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。
		if (!cyoutuu.nullCheck(listno)) {
			programmingtext = sel_programmingDao.allSelectListno(listno);
		}
		select_ctx.close();

		// typeデータをJSP形式に変更。
		String dbtype = programmingtext.getProtype();

		request.setAttribute("protype", dbtype);

		if (dbtype.equals("HTML")) {
			dbtype = "pro_html";
		} else if (dbtype.equals("CSS")) {
			dbtype = "pro_css";
		} else if (dbtype.equals("JavaScript")) {
			dbtype = "pro_javascript";
		} else if (dbtype.equals("JAVA")) {
			dbtype = "pro_java";
		} else if (dbtype.equals("JSP")) {
			dbtype = "pro_jsp";
		} else if (dbtype.equals("PHP")) {
			dbtype = "pro_php";
		} else if (dbtype.equals("ORACLE")) {
			dbtype = "pro_oracle";
		} else if (dbtype.equals("MySQL")) {
			dbtype = "pro_mysql";
		} else if (dbtype.equals("SPRING")) {
			dbtype = "pro_spring";
		} else if (dbtype.equals("XML")) {
			dbtype = "pro_xml";
		} else if (dbtype.equals("C")) {
			dbtype = "pro_c";
		} else if (dbtype.equals("C++")) {
			dbtype = "pro_cplus2";
		} else if (dbtype.equals("C#")) {
			dbtype = "pro_csharp";
		} else if (dbtype.equals("WINDOWS")) {
			dbtype = "pro_windows";
		} else if (dbtype.equals("LINUX")) {
			dbtype = "pro_linux";
		} else {
			dbtype = "pro_other";
		}

		programmingtext.setProtype(dbtype);

		// descriptionデータをJSP形式に変更。
		String dbdescription = programmingtext.getDescription();
		dbdescription = dbdescription.replaceAll("<br>", "\r\n");
		programmingtext.setDescription(dbdescription);

		c_propic1 = programmingtext.getPropic1();
		c_propic2 = programmingtext.getPropic2();
		c_propic3 = programmingtext.getPropic3();
		c_propic4 = programmingtext.getPropic4();

		request.setAttribute("programmingtext", programmingtext);
		return "programmingupdate";
	}

	@RequestMapping(value = "programmingupdate", method = RequestMethod.POST)
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
			return "programmingsuccess";
		}

		// // 入力.PICURL1~4を変数に設定する作業。
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("IMG/upload");
		String encoding = "UTF-8";
		int size = 100 * 1024 * 1024;

		// 掲示物の番号を取得。
		int no_listno = Integer.parseInt(listno);
		String protype = null;
		String title = null;
		String description = null;
		String propic1 = null;
		String propic2 = null;
		String propic3 = null;
		String propic4 = null;

		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, encoding, new DefaultFileRenamePolicy());

			protype = (String) multi.getParameter("update_type");
			title = (String) multi.getParameter("update_title");
			description = (String) multi.getParameter("update_description");

			propic1 = (String) multi.getFilesystemName("pro_pic1");
			propic2 = (String) multi.getFilesystemName("pro_pic2");
			propic3 = (String) multi.getFilesystemName("pro_pic3");
			propic4 = (String) multi.getFilesystemName("pro_pic4");

			if(cyoutuu.nullCheck(propic1)){
				propic1 = c_propic1;
			}
			if(cyoutuu.nullCheck(propic2)){
				propic2 = c_propic2;
			}
			if(cyoutuu.nullCheck(propic3)){
				propic3 = c_propic3;
			}
			if(cyoutuu.nullCheck(propic4)){
				propic4 = c_propic4;
			}

			// typeのJSP形式をDB化
			if (protype.equals("pro_html")) {
				protype = "HTML";
			} else if (protype.equals("pro_css")) {
				protype = "CSS";
			} else if (protype.equals("pro_javascript")) {
				protype = "JavaScript";
			} else if (protype.equals("pro_java")) {
				protype = "JAVA";
			} else if (protype.equals("pro_jsp")) {
				protype = "JSP";
			} else if (protype.equals("pro_php")) {
				protype = "PHP";
			} else if (protype.equals("pro_oracle")) {
				protype = "ORACLE";
			} else if (protype.equals("pro_mysql")) {
				protype = "MySQL";
			} else if (protype.equals("pro_spring")) {
				protype = "SPRING";
			} else if (protype.equals("pro_xml")) {
				protype = "XML";
			} else if (protype.equals("pro_c")) {
				protype = "C";
			} else if (protype.equals("pro_cplus2")) {
				protype = "C++";
			} else if (protype.equals("pro_csharp")) {
				protype = "C#";
			} else if (protype.equals("pro_windows")) {
				protype = "WINDOWS";
			} else if (protype.equals("pro_linux")) {
				protype = "LINUX";
			} else {
				protype = "OTHER";
			}

			// descriptionのJSP形式をDB化
			description = description.replaceAll("\r\n", "<br>");

		} catch (Exception e) {
			// データのアップロードを失敗した場合。
			request.setAttribute("message", "ファイルアップロードに失敗しました。");
			return "programmingsuccess";
		}

		// プログラミング関連データを呼び出す。
		// 掲示物の番号を条件としてデータを更新する。
		ProgrammingListDto updatedto = new ProgrammingListDto();

		updatedto.setListno(no_listno);
		updatedto.setProtype(protype);
		updatedto.setTitle(title);
		updatedto.setDescription(description);
		updatedto.setPropic1(propic1);
		updatedto.setPropic2(propic2);
		updatedto.setPropic3(propic3);
		updatedto.setPropic4(propic4);

		AbstractApplicationContext update_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		ProgrammingDao upd_programmingDao = update_ctx.getBean("programmingDao", ProgrammingDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。

		int dbresultflg = 0;
		if (no_listno != 0) {
			dbresultflg = upd_programmingDao.allUpdatelistno(updatedto);
		}

		update_ctx.close();

		// 異常の場合
		if (dbresultflg == 1) {
			request.setAttribute("message", "データ更新に失敗しました。");
			return "programmingsuccess";
		}

		request.setAttribute("message", "修正されました。");
		return "programmingsuccess";
	}
}
