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

import com.leesungbok.dao.ProgrammingDao;
import com.leesungbok.dto.ProgrammingListDto;
import com.leesungbok.kyoutuubuhinn.Cyoutuubuhinn;

@Controller
public class ProgrammingList_Ctl {

	@RequestMapping(value = "programminglist", method = RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {

		// ページの番号（基本設定は1ページにする。）
		int pageno = Integer.parseInt(request.getParameter("pageno"));

		// プログラミング関連データを呼び出す。
		List<ProgrammingListDto> programminglist = new ArrayList<ProgrammingListDto>();
		AbstractApplicationContext allSelect_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		ProgrammingDao programmingDao = allSelect_ctx.getBean("programmingDao", ProgrammingDao.class);
		programminglist = programmingDao.allSelect();
		allSelect_ctx.close();

		// 掲示物出力
		// 20個ずつ出力する。
		List<ProgrammingListDto> pagelist = new ArrayList<ProgrammingListDto>();

		// ページが'1'の場合。
		if (pageno == 1) {
			for (int pagesize = 0; pagesize < 20; pagesize++) {
				// 残りデータチェック用
				if(programminglist.size() - 1 < pagesize){
					break;
				}
				pagelist.add(programminglist.get(pageno * pagesize));
			}
		} else {
			// '1'ページ以外の場合。
			int startpoint = pageno * 20 - 20;
			for (int pagesize = 0; pagesize < 20; pagesize++) {
				// 残りデータチェック用
				if(programminglist.size() - 1 < startpoint + pagesize){
					break;
				}
				pagelist.add(programminglist.get(startpoint + pagesize));
			}
		}

		// ページ番号リスト出力
		//データサイズをチェック及び設定。
		int dbsize = programminglist.size();
		// 総ページ数
		int totalpagesize = dbsize / 20;

		// 残りリストがある場合。
		if((dbsize%20) != 0) {
			// 総ページ数 = 総ページ数 + 1
			totalpagesize = totalpagesize + 1;
		}

		// ページ番号リスト
		int firstlistpage = 1;
		int lastlistpage = 10;
		boolean listpagecheckflg = false;

		// ページ番号リストを10個ずつ出力するように作成。
		// 最後のリストが10個未満の場合は残りものだけ出力する。
		while(listpagecheckflg == false) {
			if(totalpagesize == 0) {
				lastlistpage = 1;
				listpagecheckflg = true;
			}
			if(lastlistpage > totalpagesize) {
				lastlistpage = totalpagesize;
			}
			if(pageno >= firstlistpage && pageno <= lastlistpage) {
				listpagecheckflg = true;
			} else {
				firstlistpage += 10;
				lastlistpage += 10;
			}
		}

		// 現在ページ番号
		request.setAttribute("nowlistpageno", pageno);
		// 総ページ数
		request.setAttribute("totalpagesize", totalpagesize);
		// ページ番号リスト（前）
		request.setAttribute("firstlistpage", firstlistpage);
		// ページ番号リスト（後）
		request.setAttribute("lastlistpage", lastlistpage);
		// ページ内容
		request.setAttribute("programminglist", pagelist);

		return "programminglist";
	}

	@RequestMapping(value = "programminglist", method = RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {

		// 共通部品（NULLチェック）
		Cyoutuubuhinn kyoutuu = new Cyoutuubuhinn();
		// 検索範囲
		String searchprotype = request.getParameter("searchprotype");
		// 検索単語
		String searchtext = request.getParameter("searchtext");
		// ページの番号（基本設定は1ページにする。）
		int pageno = Integer.parseInt(request.getParameter("pageno"));


		// プログラミング関連データを呼び出す。
		List<ProgrammingListDto> programminglist = new ArrayList<ProgrammingListDto>();
		AbstractApplicationContext select_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		ProgrammingDao programmingDao = select_ctx.getBean("programmingDao", ProgrammingDao.class);

		// Titleで検索する場合、
		if(searchprotype.equals("pro_title") && !kyoutuu.nullCheck(searchtext)) {
			programminglist = programmingDao.allSelectTitle(searchtext);
		} else if(searchprotype.equals("pro_titletext") && !kyoutuu.nullCheck(searchtext)) {
			// title + textで検索する場合、
			programminglist = programmingDao.allSelectTitleText(searchtext);
		} else if(searchprotype.equals("pro_type") && !kyoutuu.nullCheck(searchtext)) {
			// 種類で検索する場合、
			programminglist = programmingDao.allSelectType(searchtext);
		} else if(searchprotype.equals("pro_name") && !kyoutuu.nullCheck(searchtext)) {
			// 作成者で検索する場合、
			programminglist = programmingDao.allSelectUserid(searchtext);
		} else {
			// 検索条件がない場合、
			// 条件なしで掲示物を出力
			programminglist = programmingDao.allSelect();
		}

		// 検索結果がない場合、全体検索を行う。
		if(programminglist.size() == 0) {
			programminglist = programmingDao.allSelect();
		}
		select_ctx.close();

		// 掲示物出力
		// 20個ずつ出力する。
		List<ProgrammingListDto> pagelist = new ArrayList<ProgrammingListDto>();

		// データが20個以下の場合。
		if (pageno == 1) {
			for (int pagesize = 0; pagesize < 20; pagesize++) {
				// 残りデータチェック用
				if(programminglist.size() - 1 < pagesize){
					break;
				}
				pagelist.add(programminglist.get(pageno * pagesize));
			}
		} else {
			// データが21個以上の場合。
			int startpoint = pageno * 20 - 20;
			for (int pagesize = 0; pagesize < 20; pagesize++) {
				// 残りデータチェック用
				if(programminglist.size() - 1 < startpoint + pagesize){
					break;
				}
				pagelist.add(programminglist.get(startpoint + pagesize));
			}
		}
		// ページ番号リスト出力
		//データサイズをチェック及び設定。
		int dbsize = programminglist.size();
		// 総ページ数
		int totalpagesize = dbsize / 20;

		// 残りリストがある場合。
		if((dbsize%20) != 0) {
			// 総ページ数 = 総ページ数 + 1
			totalpagesize = totalpagesize + 1;
		}

		// ページ番号リスト
		int firstlistpage = 1;
		int lastlistpage = 10;
		boolean listpagecheckflg = false;

		// ページ番号リストを10個ずつ出力するように作成。
		// 最後のリストが10個未満の場合は残りものだけ出力する。
		while(listpagecheckflg == false) {
			if(totalpagesize == 0) {
				lastlistpage = 1;
				listpagecheckflg = true;
			}
			if(lastlistpage > totalpagesize) {
				lastlistpage = totalpagesize;
			}
			if(pageno >= firstlistpage && pageno <= lastlistpage) {
				listpagecheckflg = true;
			} else {
				firstlistpage += 10;
				lastlistpage += 10;
			}
		}

		// 検索範囲
		request.setAttribute("searchprotype", searchprotype);
		// 検索単語
		request.setAttribute("searchtext", searchtext);
		// 現在ページ番号
		request.setAttribute("nowlistpageno", pageno);
		// 総ページ数
		request.setAttribute("totalpagesize", totalpagesize);
		// ページ番号リスト（前）
		request.setAttribute("firstlistpage", firstlistpage);
		// ページ番号リスト（後）
		request.setAttribute("lastlistpage", lastlistpage);
		// ページ内容
		request.setAttribute("programminglist", pagelist);

		return "programmingsearch";
	}

	@RequestMapping(value = "main_programminglist", method = RequestMethod.GET)
	public String toGetMain(HttpServletRequest request, HttpServletResponse response) {


		// プログラミング関連データを呼び出す。
		List<ProgrammingListDto> programminglist = new ArrayList<ProgrammingListDto>();
		AbstractApplicationContext allSelect_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		ProgrammingDao programmingDao = allSelect_ctx.getBean("programmingDao", ProgrammingDao.class);
		programminglist = programmingDao.allSelectodrcount();
		allSelect_ctx.close();

		// 掲示物出力
		// 20個ずつ出力する。
		List<ProgrammingListDto> pagelist = new ArrayList<ProgrammingListDto>();
		// 照会数上位10個を取得する。
		for (int listsize = 0; listsize <= 10; listsize++) {
			pagelist.add(programminglist.get(listsize));
		}

		// ページ内容
		request.setAttribute("programminglist", pagelist);

		return "main_programminglist";
	}
}
