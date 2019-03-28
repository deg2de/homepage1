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
public class UserUpdate_Ctl {

	@RequestMapping(value="userupdate", method=RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();

		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は「userupdate.jsp」ページに移動する。
		// sessionの"loginuser"情報がない場合は「main.jsp」ページに移動する。
		if (loginuserdto != null) {
			return "userupdate";
		} else {
			return "main";
		}
	}

	@RequestMapping(value="userupdate", method=RequestMethod.POST)
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
		// 変更する情報を設定。
		String userid = loginuserdto.getUserid();
		String userpw = request.getParameter("userpw");
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String userphone = request.getParameter("userphone");

		// PHONEの中腹チェック
		// DBのデータを保存するDTO
		MemberDto allSelectByPh_dto = new MemberDto();

		AbstractApplicationContext allSelectByPh_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberDao allSelectByPh_md = allSelectByPh_ctx.getBean("memberDao", MemberDao.class);
		allSelectByPh_dto = allSelectByPh_md.allSelectByPh(userphone);
		allSelectByPh_ctx.close();

		// 中腹の場合、中腹メッセージを設定してリターンする。
		if(allSelectByPh_dto != null) {

			// 他人が使う携帯番号かを確認。
			if(!userid.equals(allSelectByPh_dto.getUserid())) {
				request.setAttribute("userupdate_input_userpw", userpw);
				request.setAttribute("userupdate_input_userpw2", userpw);
				request.setAttribute("userupdate_input_username", username);
				request.setAttribute("userupdate_input_useremail", useremail);
				request.setAttribute("userupdate_input_userphone", userphone);
				request.setAttribute("update_message_userphone", "使っている番号です。");
				return "userupdate";
			}
		}

		// DB変更作業
		// DBのデータを保存するDTO
		AbstractApplicationContext allUpdateId_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberDao allUpdateId_md = allUpdateId_ctx.getBean("memberDao", MemberDao.class);
		int result = allUpdateId_md.allUpdateId(userid, userpw, username, useremail, userphone);
		allUpdateId_ctx.close();

		// update失敗の場合（正常：0、異常：1）
		if(result != 0) {
			request.setAttribute("userupdate_input_userpw", userpw);
			request.setAttribute("userupdate_input_username", username);
			request.setAttribute("userupdate_input_useremail", useremail);
			request.setAttribute("userupdate_input_userphone", userphone);
			request.setAttribute("update_message", "更新に失敗しました。管理者に連絡してください。");
			return "userupdate";
		}

		request.setAttribute("success_message", userid + "様、情報更新を完了しました。");
		return "usersuccess";
	}
}
