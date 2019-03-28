package com.leesungbok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leesungbok.dao.ProgrammingDao;

@Controller
public class ProgrammingDelete_Ctl {

	@RequestMapping(value="programmingdelete", method=RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response){

		String listno = request.getParameter("listno");

		// LISTNOを条件としてデータを削除する。
		AbstractApplicationContext delete_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		ProgrammingDao programmingDao = delete_ctx.getBean("programmingDao", ProgrammingDao.class);
		programmingDao.allDeletelistno(listno);
		delete_ctx.close();

		// 完了メッセージを出力する。
		request.setAttribute("message", "削除されました。Programming掲示板に移動します。");

		return "programmingsuccess";
	}
}
