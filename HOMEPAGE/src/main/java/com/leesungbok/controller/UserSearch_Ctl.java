package com.leesungbok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leesungbok.dao.MemberDao;
import com.leesungbok.dto.LoginUserDto;
import com.leesungbok.dto.MemberDto;

@Controller
public class UserSearch_Ctl {

	@RequestMapping(value = "usersearch", method = RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();

		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は「main.jsp」ページに移動する。
		// sessionの"loginuser"情報がない場合は「usersearch.jsp」ページに移動する。
		if (loginuserdto != null) {
			return "main";
		} else {
			return "usersearch";
		}
	}

	// ID検索用POST
	@RequestMapping(value = "usersearchid", method = RequestMethod.POST)
	public String toPostId(HttpServletRequest request, HttpServletResponse response) {

		String input_name = request.getParameter("search_id_username");
		String input_phone = request.getParameter("search_id_userphone");

		// 「入力パラメーター.携帯番号」を条件として情報検索。
		AbstractApplicationContext ctx_allSelectByPh = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberDao md_allSelectByPh = ctx_allSelectByPh.getBean("memberDao", MemberDao.class);

		// DBのデータを保存するDTO
		MemberDto allSelectByPh_dto = new MemberDto();
		// 入力パラメーター.携帯番号で検索。
		allSelectByPh_dto = md_allSelectByPh.allSelectByPh(input_phone);
		ctx_allSelectByPh.close();

		// 「検索結果の情報」と「検索結果の情報.名前」がある場合、
		if (allSelectByPh_dto != null && allSelectByPh_dto.getName() != null) {
			String db_name = allSelectByPh_dto.getName();
			if (input_name.equals(db_name)) {
				// 一致する情報がある場合、IDを戻り値でリターン。
				String db_userid = allSelectByPh_dto.getUserid();
				request.setAttribute("usersearch_id_message", "IDは「" + db_userid + "」です。");
				return "usersearch";

			} else {
				// 一致する情報がない場合、検索失敗メッセージを出力。
				request.setAttribute("usersearch_id_message", "一致する情報がありません。");
				return "usersearch";
			}
		} else {
			// 一致する情報がない場合、検索失敗メッセージを出力。
			request.setAttribute("usersearch_id_message", "一致する情報がありません。");
			return "usersearch";
		}
	}

	// PW検索用POST
	@RequestMapping(value = "usersearchpw", method = RequestMethod.POST)
	public String toPostPw(HttpServletRequest request, HttpServletResponse response) {

		String input_userid = request.getParameter("search_pw_userid");
		String input_phone = request.getParameter("search_pw_userphone");

		// 「入力パラメーター.携帯番号」を条件として情報検索。
		AbstractApplicationContext ctx_allSelectByPh = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberDao md_allSelectByPh = ctx_allSelectByPh.getBean("memberDao", MemberDao.class);

		// DBのデータを保存するDTO
		MemberDto allSelectByPh_dto = new MemberDto();
		// 入力パラメーター.携帯番号で検索。
		allSelectByPh_dto = md_allSelectByPh.allSelectByPh(input_phone);
		ctx_allSelectByPh.close();

		// 「検索結果の情報」と「検索結果の情報.ID」がある場合、
		if (allSelectByPh_dto != null && allSelectByPh_dto.getUserid() != null) {
			String db_userid = allSelectByPh_dto.getUserid();
			if (input_userid.equals(db_userid)) {
				// 一致する情報がある場合、PWを戻り値でリターン。
				String db_pw = allSelectByPh_dto.getPwd();
				request.setAttribute("usersearch_pw_message", "PWは「" + db_pw + "」です。");
				return "usersearch";

			} else {
				// 一致する情報がない場合、検索失敗メッセージを出力。
				request.setAttribute("usersearch_pw_message", "一致する情報がありません。");
				return "usersearch";
			}
		} else {
			// 一致する情報がない場合、検索失敗メッセージを出力。
			request.setAttribute("usersearch_pw_message", "一致する情報がありません。");
			return "usersearch";
		}
	}
}
