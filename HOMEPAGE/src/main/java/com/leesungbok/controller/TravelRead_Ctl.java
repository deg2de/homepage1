package com.leesungbok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leesungbok.dao.TravelDao;
import com.leesungbok.dto.TravelListDto;
import com.leesungbok.kyoutuubuhinn.Cyoutuubuhinn;

@Controller
public class TravelRead_Ctl {

	@RequestMapping(value="travelread", method=RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response){

		// 共通部品（NULLチェック）
		Cyoutuubuhinn cyoutuu = new Cyoutuubuhinn();

		// 掲示物の番号
		String listno = request.getParameter("list_no");
		request.setAttribute("list_no", listno);

		// プログラミング関連データを呼び出す。
		TravelListDto traveltext = new TravelListDto();
		AbstractApplicationContext select_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		TravelDao sel_travelDao = select_ctx.getBean("travelDao", TravelDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。
		if(!cyoutuu.nullCheck(listno)) {
			traveltext = sel_travelDao.allSelectListno(listno);
		}
		select_ctx.close();

		// 照会数を+1
		int count = traveltext.getTracount();
		// 照会数が7桁（最大値）だったら初期化する。
		if(count == 9999999){
			count = 0;
		}
		count += 1;

		traveltext.setTracount(count);

		AbstractApplicationContext update_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		TravelDao upd_travelDao = update_ctx.getBean("travelDao", TravelDao.class);
		upd_travelDao.countUpdatelistno(count, listno);
		update_ctx.close();

		request.setAttribute("traveltext", traveltext);
		return "travelread";
	}
}
