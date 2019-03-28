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
import com.leesungbok.kyoutuubuhinn.Cyoutuubuhinn;

@Controller
public class UserCreate_Ctl {

	Cyoutuubuhinn cyoutuu = new Cyoutuubuhinn();

	@RequestMapping(value = "usercreate", method = RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {

		// ログイン状態を確認。
		HttpSession session = request.getSession();

		LoginUserDto loginuserdto = new LoginUserDto();

		loginuserdto = (LoginUserDto) session.getAttribute("loginuser");

		// sessionの"loginuser"情報がある場合は「main.jsp」ページに移動する。
		// sessionの"loginuser"情報がない場合は「usercreate.jsp」ページに移動する。
		if (loginuserdto != null) {
			return "main";
		} else {

			request.setAttribute("create_message_userid", "英語（小文字）、数字で4~10桁（空白x）");
			request.setAttribute("create_message_userpw", "英語、数字、記号で6~10桁（空白x）");
			request.setAttribute("create_message_userpw2", "PWと同じに入力（空白x）");
			request.setAttribute("create_message_username", "韓国語で2~5桁（空白x）");
			request.setAttribute("create_message_useremail", "20桁以下、ex)****@**.**（空白x）");
			request.setAttribute("create_message_userphone", "ex)***-****-****（空白x）");
			return "usercreate";
		}
	}

	@RequestMapping(value = "usercreate", method = RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {

		// 入力パラメーター.ID
		String input_id = request.getParameter("userid");
		// 入力パラメーター.PW
		String input_pw = request.getParameter("userpw");
		// 入力パラメーター.PW確認
		String input_pw2 = request.getParameter("userpw2");
		// 入力パラメーター.名前
		String input_name = request.getParameter("username");
		// 入力パラメーター.メール
		String input_email = request.getParameter("useremail");
		// 入力パラメーター.携帯番号
		String input_phone = request.getParameter("userphone");

		// 入力パラメーターのnull,空白確認。（共通部品使用）
		if (cyoutuu.nullCheck(input_id)) {
			request.setAttribute("create_message_userid", "IDを入力してください。");
			return "usercreate";
		} else if (cyoutuu.nullCheck(input_pw)) {
			request.setAttribute("create_message_userpw", "PWを入力してください。");
			return "usercreate";
		} else if (cyoutuu.nullCheck(input_pw2)) {
			request.setAttribute("create_message_userpw2", "PW Checkを入力してください。");
			return "usercreate";
		} else if (cyoutuu.nullCheck(input_name)) {
			request.setAttribute("create_message_username", "Nameを入力してください。");
			return "usercreate";
		} else if (cyoutuu.nullCheck(input_email)) {
			request.setAttribute("create_message_useremail", "Emailを入力してください。");
			return "usercreate";
		} else if (cyoutuu.nullCheck(input_phone)) {
			request.setAttribute("create_message_userphone", "Phoneを入力してください。");
			return "usercreate";
		}

		// 正常入力の場合、IDの中腹チェックを行う。
		AbstractApplicationContext ctx_idSelectById = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberDao md_idSelectById = ctx_idSelectById.getBean("memberDao", MemberDao.class);

		// DBのデータを保存するDTO
		MemberDto idSelectById_dto = new MemberDto();
		// 入力パラメーター.IDで検索。
		idSelectById_dto = md_idSelectById.idSelectById(input_id);
		ctx_idSelectById.close();

		// 正常入力の場合、PHONEの中腹チェックを行う。
		AbstractApplicationContext ctx_allSelectByPh = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberDao md_allSelectByPh = ctx_allSelectByPh.getBean("memberDao", MemberDao.class);

		// DBのデータを保存するDTO
		MemberDto allSelectByPh_dto = new MemberDto();
		// 入力パラメーター.携帯番号で検索。
		allSelectByPh_dto = md_allSelectByPh.allSelectByPh(input_phone);
		ctx_allSelectByPh.close();

		// 中腹IDがある場合。
		if (idSelectById_dto != null) {
			// 入力した情報をリダイレクトする。
			request.setAttribute("create_message_userid", "入力したIDは使用されています。");
			request.setAttribute("input_userid", input_id);
			request.setAttribute("input_userpw", input_pw);
			request.setAttribute("input_userpw2", input_pw2);
			request.setAttribute("input_username", input_name);
			request.setAttribute("input_useremail", input_email);
			request.setAttribute("input_userphone", input_phone);
			return "usercreate";
		} else if(allSelectByPh_dto != null) {
			// 中腹PHONEがある場合。
			// 入力した情報をリダイレクトする。
			request.setAttribute("create_message_userphone", "入力したPHONEは使用されています。");
			request.setAttribute("input_userid", input_id);
			request.setAttribute("input_userpw", input_pw);
			request.setAttribute("input_userpw2", input_pw2);
			request.setAttribute("input_username", input_name);
			request.setAttribute("input_useremail", input_email);
			request.setAttribute("input_userphone", input_phone);
			return "usercreate";
		}else {
			// 中腹ではない場合、入力情報をDBに格納する。
			AbstractApplicationContext ctx_insertMember = new GenericXmlApplicationContext("classpath:appCtx.xml");
			MemberDao md_insertMember = ctx_insertMember.getBean("memberDao", MemberDao.class);

			// DBのデータに保存するDTO
			// 使用者のadminは'0'、管理者は'1'
			MemberDto insertMember_dto = new MemberDto();
			insertMember_dto.setUserid(input_id);
			insertMember_dto.setPwd(input_pw);
			insertMember_dto.setName(input_name);
			insertMember_dto.setEmail(input_name);
			insertMember_dto.setPhone(input_phone);
			insertMember_dto.setAdmin(0);

			// データを格納するためにinsert文を実行する。
			md_insertMember.insertMember(insertMember_dto);

			ctx_insertMember.close();

			// 完了ページに表示するメッセージを設定。
			request.setAttribute("success_message",input_name + "様、会員加入が完了されました。");
			return "usersuccess";
		}
	}
}
