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
import com.leesungbok.dto.MusicListDto;
import com.leesungbok.kyoutuubuhinn.Cyoutuubuhinn;

@Controller
public class MusicList_Ctl {

	@RequestMapping(value = "musiclist", method = RequestMethod.GET)
	public String toGet(HttpServletRequest request, HttpServletResponse response) {

		// ページの番号（基本設定は1ページにする。）
		int pageno = Integer.parseInt(request.getParameter("pageno"));

		// 旅行関連データを呼び出す。
		List<MusicListDto> musiclist = new ArrayList<MusicListDto>();
		AbstractApplicationContext allSelect_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MusicDao musicDao = allSelect_ctx.getBean("musicDao", MusicDao.class);
		musiclist = musicDao.allSelect();
		allSelect_ctx.close();

		// 掲示物出力
		// 20個ずつ出力する。
		List<MusicListDto> pagelist = new ArrayList<MusicListDto>();

		// ページが'1'の場合。
		if (pageno == 1) {
			for (int pagesize = 0; pagesize < 20; pagesize++) {
				// 残りデータチェック用
				if(musiclist.size() - 1 < pagesize){
					break;
				}
				pagelist.add(musiclist.get(pageno * pagesize));
			}
		} else {
			// '1'ページ以外の場合。
			int startpoint = pageno * 20 - 20;
			for (int pagesize = 0; pagesize < 20; pagesize++) {
				// 残りデータチェック用
				if(musiclist.size() - 1 < startpoint + pagesize){
					break;
				}
				pagelist.add(musiclist.get(startpoint + pagesize));
			}
		}

		// ページ番号リスト出力
		//データサイズをチェック及び設定。
		int dbsize = musiclist.size();
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
		request.setAttribute("musiclist", pagelist);

		return "musiclist";
	}

	@RequestMapping(value = "musiclist", method = RequestMethod.POST)
	public String toPost(HttpServletRequest request, HttpServletResponse response) {

		// 共通部品（NULLチェック）
		Cyoutuubuhinn kyoutuu = new Cyoutuubuhinn();
		// 検索範囲
		String searchmustype = request.getParameter("searchmustype");
		// 検索単語
		String searchtext = request.getParameter("searchtext");
		// ページの番号（基本設定は1ページにする。）
		int pageno = Integer.parseInt(request.getParameter("pageno"));


		// 旅行関連データを呼び出す。
		List<MusicListDto> musiclist = new ArrayList<MusicListDto>();
		AbstractApplicationContext select_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MusicDao musicDao = select_ctx.getBean("musicDao", MusicDao.class);

		// Titleで検索する場合、
		if(searchmustype.equals("mus_title") && !kyoutuu.nullCheck(searchtext)) {
			musiclist = musicDao.allSelectTitle(searchtext);
		} else if(searchmustype.equals("mus_titletext") && !kyoutuu.nullCheck(searchtext)) {
			// title + textで検索する場合、
			musiclist = musicDao.allSelectTitleText(searchtext);
		} else if(searchmustype.equals("mus_type") && !kyoutuu.nullCheck(searchtext)) {
			// 種類で検索する場合、
			musiclist = musicDao.allSelectType(searchtext);
		} else if(searchmustype.equals("mus_name") && !kyoutuu.nullCheck(searchtext)) {
			// 作成者で検索する場合、
			musiclist = musicDao.allSelectUserid(searchtext);
		} else {
			// 検索条件がない場合、
			// 条件なしで掲示物を出力
			musiclist = musicDao.allSelect();
		}

		// 検索結果がない場合、全体検索を行う。
		if(musiclist.size() == 0) {
			musiclist = musicDao.allSelect();
		}
		select_ctx.close();

		// 掲示物出力
		// 20個ずつ出力する。
		List<MusicListDto> pagelist = new ArrayList<MusicListDto>();

		// データが20個以下の場合。
		if (pageno == 1) {
			for (int pagesize = 0; pagesize < 20; pagesize++) {
				// 残りデータチェック用
				if(musiclist.size() - 1 < pagesize){
					break;
				}
				pagelist.add(musiclist.get(pageno * pagesize));
			}
		} else {
			// データが21個以上の場合。
			int startpoint = pageno * 20 - 20;
			for (int pagesize = 0; pagesize < 20; pagesize++) {
				// 残りデータチェック用
				if(musiclist.size() - 1 < startpoint + pagesize){
					break;
				}
				pagelist.add(musiclist.get(startpoint + pagesize));
			}
		}
		// ページ番号リスト出力
		//データサイズをチェック及び設定。
		int dbsize = musiclist.size();
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
		request.setAttribute("searchmustype", searchmustype);
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
		request.setAttribute("musiclist", pagelist);

		return "musicsearch";
	}

	@RequestMapping(value = "main_musiclist", method = RequestMethod.GET)
	public String toGetMain(HttpServletRequest request, HttpServletResponse response) {


		// 旅行関連データを呼び出す。
		List<MusicListDto> musiclist = new ArrayList<MusicListDto>();
		AbstractApplicationContext allSelect_ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MusicDao musicDao = allSelect_ctx.getBean("musicDao", MusicDao.class);
		musiclist = musicDao.allSelectodrcount();
		allSelect_ctx.close();

		// 掲示物出力
		// 20個ずつ出力する。
		List<MusicListDto> pagelist = new ArrayList<MusicListDto>();
		// 照会数上位10個を取得する。
		for (int listsize = 0; listsize <= 10; listsize++) {
			pagelist.add(musiclist.get(listsize));
		}

		// ページ内容
		request.setAttribute("musiclist", pagelist);

		return "main_musiclist";
	}
}
