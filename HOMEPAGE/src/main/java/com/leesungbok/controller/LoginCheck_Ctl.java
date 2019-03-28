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
public class LoginCheck_Ctl {

	Main_Ctl main_ctl = new Main_Ctl();

	@RequestMapping(value = "logincheck", method = RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {
		String main = main_ctl.toGet(request, response);
		return main;
	}

	@RequestMapping(value = "logincheck", method = RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {


		String main = main_ctl.toGet(request, response);

		// DBのデータを保存するDTO
		MemberDto member = new MemberDto();

		// input formから入力してもらったIDとPW。
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");

		// 入力したIDを条件としてDB検索。
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		member = memberDao.allSelectById(userid);
		ctx.close();

		// 一致する情報がある場合。
		// DBに保存されているPWと入力PWを比較。
		// PWが一致する場合。
		if (member != null && userpw.equals(member.getPwd())) {
			// sessionに名前とIDを設定。
			String db_userid = member.getUserid();
			String db_username = member.getName();

			// session専用DTOに情報を設定。
			LoginUserDto loginuserdto = new LoginUserDto();
			loginuserdto.setUserid(db_userid);
			loginuserdto.setName(db_username);

			HttpSession session = request.getSession();
			session.setAttribute("loginuser", loginuserdto);
			request.setAttribute("message", "ログインに成功しました。");

			return main;
		} else {
			request.setAttribute("message", "ID,PWが間違いました。");

			return main;
		}
	}
}
