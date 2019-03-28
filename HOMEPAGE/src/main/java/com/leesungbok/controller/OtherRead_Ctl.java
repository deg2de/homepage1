package com.leesungbok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leesungbok.dao.OtherDao;
import com.leesungbok.dto.OtherListDto;
import com.leesungbok.kyoutuubuhinn.Cyoutuubuhinn;

@Controller
public class OtherRead_Ctl {

	@RequestMapping(value="otherread", method=RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response){

		// 共通部品（NULLチェック）
		Cyoutuubuhinn cyoutuu = new Cyoutuubuhinn();

		// 掲示物の番号
		String listno = request.getParameter("list_no");
		request.setAttribute("list_no", listno);

		// プログラミング関連データを呼び出す。
		OtherListDto othertext = new OtherListDto();
		AbstractApplicationContext select_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		OtherDao sel_otherDao = select_ctx.getBean("otherDao", OtherDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。
		if(!cyoutuu.nullCheck(listno)) {
			othertext = sel_otherDao.allSelectListno(listno);
		}
		select_ctx.close();

		// 照会数を+1
		int count = othertext.getOthcount();
		// 照会数が7桁（最大値）だったら初期化する。
		if(count == 9999999){
			count = 0;
		}
		count += 1;

		othertext.setOthcount(count);

		AbstractApplicationContext update_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		OtherDao upd_otherDao = update_ctx.getBean("otherDao", OtherDao.class);
		upd_otherDao.countUpdatelistno(count, listno);
		update_ctx.close();

		request.setAttribute("othertext", othertext);
		return "otherread";
	}
}
