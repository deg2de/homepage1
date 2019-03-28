package com.leesungbok.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leesungbok.dao.MusicDao;
import com.leesungbok.dao.OtherDao;
import com.leesungbok.dao.ProgrammingDao;
import com.leesungbok.dao.TravelDao;
import com.leesungbok.dto.MusicListDto;
import com.leesungbok.dto.OtherListDto;
import com.leesungbok.dto.ProgrammingListDto;
import com.leesungbok.dto.TravelListDto;

@Controller
public class Main_Ctl {

	@RequestMapping(value="jquerytest", method=RequestMethod.GET)
	public String toGetJQuery(HttpServletRequest request, HttpServletResponse response) {

		return "jquerytest";
	}

	@RequestMapping(value="main", method=RequestMethod.GET)
	public String toGetMain(HttpServletRequest request, HttpServletResponse response) {

		return toGet(request, response);
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {
		// プログラミング関連データを呼び出す。
		List<ProgrammingListDto> programminglist = new ArrayList<ProgrammingListDto>();
		AbstractApplicationContext allSelect_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		ProgrammingDao programmingDao = allSelect_ctx.getBean("programmingDao", ProgrammingDao.class);
		programminglist = programmingDao.allSelectodrcount();
		allSelect_ctx.close();

		// 旅行関連データを呼び出す。
		List<TravelListDto> travellist = new ArrayList<TravelListDto>();
		AbstractApplicationContext travelSelect_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		TravelDao travelDao = travelSelect_ctx.getBean("travelDao", TravelDao.class);
		travellist = travelDao.allSelectodrcount();
		travelSelect_ctx.close();

		// 音楽関連データを呼び出す。
		List<MusicListDto> musiclist = new ArrayList<MusicListDto>();
		AbstractApplicationContext musicSelect_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MusicDao musicDao = musicSelect_ctx.getBean("musicDao", MusicDao.class);
		musiclist = musicDao.allSelectodrcount();
		musicSelect_ctx.close();

		// 他の関連データを呼び出す。
		List<OtherListDto> otherlist = new ArrayList<OtherListDto>();
		AbstractApplicationContext otherSelect_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		OtherDao otherDao = otherSelect_ctx.getBean("otherDao", OtherDao.class);
		otherlist = otherDao.allSelectodrcount();
		otherSelect_ctx.close();


		// 掲示物出力
		// 20個ずつ出力する。
		List<ProgrammingListDto> propagelist = new ArrayList<ProgrammingListDto>();
		List<TravelListDto> trapagelist = new ArrayList<TravelListDto>();
		List<MusicListDto> muspagelist = new ArrayList<MusicListDto>();
		List<OtherListDto> othpagelist = new ArrayList<OtherListDto>();
		// 照会数上位10個を取得する。
		for (int listsize = 0; listsize < 10; listsize++) {
			propagelist.add(programminglist.get(listsize));
			trapagelist.add(travellist.get(listsize));
			muspagelist.add(musiclist.get(listsize));
			othpagelist.add(otherlist.get(listsize));
		}

		// ページ内容
		request.setAttribute("programminglist", propagelist);
		request.setAttribute("travellist", trapagelist);
		request.setAttribute("musiclist", muspagelist);
		request.setAttribute("otherlist", othpagelist);
		return "main";
	}

	@RequestMapping(value="main", method=RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {
		return toGet(request, response);
	}
}
