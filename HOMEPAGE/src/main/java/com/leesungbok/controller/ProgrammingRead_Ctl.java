package com.leesungbok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leesungbok.dao.ProgrammingDao;
import com.leesungbok.dto.ProgrammingListDto;
import com.leesungbok.kyoutuubuhinn.Cyoutuubuhinn;

@Controller
public class ProgrammingRead_Ctl {

	@RequestMapping(value="programmingread", method=RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response){

		// 共通部品（NULLチェック）
		Cyoutuubuhinn cyoutuu = new Cyoutuubuhinn();

		// 掲示物の番号
		String listno = request.getParameter("list_no");
		request.setAttribute("list_no", listno);

		// プログラミング関連データを呼び出す。
		ProgrammingListDto programmingtext = new ProgrammingListDto();
		AbstractApplicationContext select_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		ProgrammingDao sel_programmingDao = select_ctx.getBean("programmingDao", ProgrammingDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。
		if(!cyoutuu.nullCheck(listno)) {
			programmingtext = sel_programmingDao.allSelectListno(listno);
		}
		select_ctx.close();

		// 照会数を+1
		int count = programmingtext.getProcount();
		// 照会数が7桁（最大値）だったら初期化する。
		if(count == 9999999){
			count = 0;
		}
		count += 1;

		programmingtext.setProcount(count);

		AbstractApplicationContext update_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		ProgrammingDao upd_programmingDao = update_ctx.getBean("programmingDao", ProgrammingDao.class);
		upd_programmingDao.countUpdatelistno(count, listno);
		update_ctx.close();

		request.setAttribute("programmingtext", programmingtext);
		return "programmingread";
	}
}
