package com.leesungbok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leesungbok.dao.MusicDao;
import com.leesungbok.dto.MusicListDto;
import com.leesungbok.kyoutuubuhinn.Cyoutuubuhinn;

@Controller
public class MusicRead_Ctl {

	@RequestMapping(value="musicread", method=RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response){

		// 共通部品（NULLチェック）
		Cyoutuubuhinn cyoutuu = new Cyoutuubuhinn();

		// 掲示物の番号
		String listno = request.getParameter("list_no");
		request.setAttribute("list_no", listno);

		// プログラミング関連データを呼び出す。
		MusicListDto musictext = new MusicListDto();
		AbstractApplicationContext select_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MusicDao sel_musicDao = select_ctx.getBean("musicDao", MusicDao.class);

		// 掲示物の番号がNULLではない場合、データを取得する。
		if(!cyoutuu.nullCheck(listno)) {
			musictext = sel_musicDao.allSelectListno(listno);
		}
		select_ctx.close();

		// 照会数を+1
		int count = musictext.getMuscount();
		// 照会数が7桁（最大値）だったら初期化する。
		if(count == 9999999){
			count = 0;
		}
		count += 1;

		musictext.setMuscount(count);

		AbstractApplicationContext update_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MusicDao upd_musicDao = update_ctx.getBean("musicDao", MusicDao.class);
		upd_musicDao.countUpdatelistno(count, listno);
		update_ctx.close();

		request.setAttribute("musictext", musictext);
		return "musicread";
	}
}
