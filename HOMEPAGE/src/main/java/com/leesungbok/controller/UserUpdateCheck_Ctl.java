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
public class UserUpdateCheck_Ctl {

	@RequestMapping(value = "userupdatecheck", method = RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();

		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は「userupdate.jsp」ページに移動する。
		// sessionの"loginuser"情報がない場合は「main.jsp」ページに移動する。
		if (loginuserdto != null) {
			String loginuserid = loginuserdto.getUserid();
			request.setAttribute("userupdatecheck_userid", loginuserid);
			return "userupdatecheck";
		} else {
			return "main";
		}
	}

	@RequestMapping(value = "userupdatecheck", method = RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();

		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がない場合は「main.jsp」ページに移動する。
		if (loginuserdto == null) {
			return "main";
		}

		// sessionの"loginuser"情報がある場合は処理を進む。
		// ID,PW情報確認。
		// IDからDBを取得する。
		String loginuserid = loginuserdto.getUserid();

		// DBのデータを保存するDTO
		MemberDto loginuserid_dto = new MemberDto();

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberDao loginuserid_md = ctx.getBean("memberDao", MemberDao.class);
		loginuserid_dto = loginuserid_md.allSelectById(loginuserid);
		ctx.close();

		// DB情報がない場合、再ログインを要求するメッセージをリターンする。
		if (loginuserid_dto == null) {
			request.setAttribute("userupdatecheck_userid", loginuserid);
			request.setAttribute("userupdatecheck_message", "IDに一致する情報がありません。再ログインしり管理者に連絡してください。");
			return "userupdatecheck";
		}

		// DB情報がある場合ID,PWの比較処理を行う。
		// PWの情報がない場合、PW取得失敗メッセージをリターンする。
		if (loginuserid_dto.getPwd() == null) {
			request.setAttribute("userupdatecheck_userid", loginuserid);
			request.setAttribute("userupdatecheck_message", "PW取得を失敗しました。管理者に連絡してください。");
			return "userupdatecheck";
		} else {
			// 入力したPW
			String input_pw = request.getParameter("userupdatecheck_userpw");
			// DBに保存されているPW
			String db_pw = loginuserid_dto.getPwd();

			// PWを比較する。
			// 一致する場合。
			if (input_pw.equals(db_pw)) {
				// DBの情報を「userupdate」に転送する。
				request.setAttribute("userupdate_input_userpw", loginuserid_dto.getPwd());
				request.setAttribute("userupdate_input_userpw2", loginuserid_dto.getPwd());
				request.setAttribute("userupdate_input_username", loginuserid_dto.getName());
				request.setAttribute("userupdate_input_useremail", loginuserid_dto.getEmail());
				request.setAttribute("userupdate_input_userphone", loginuserid_dto.getPhone());

				return "userupdate";
			} else {
				// 一致しない場合。
				request.setAttribute("userupdatecheck_userid", loginuserid);
				request.setAttribute("userupdatecheck_message", "PWが間違いました。");
				return "userupdatecheck";
			}
		}
	}
}
