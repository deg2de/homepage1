package com.leesungbok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Logout_Ctl {

	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {
		return "main";
	}

	@RequestMapping(value="logout", method = RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.removeAttribute("loginuser");
		return "main";
	}
}
