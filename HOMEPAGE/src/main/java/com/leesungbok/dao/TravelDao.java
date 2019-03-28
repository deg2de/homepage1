package com.leesungbok.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.leesungbok.dto.TravelListDto;

public class TravelDao {

	private JdbcTemplate jdbcTemplate;

	public TravelDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// TRAVELデータを全て取得する。
	public List<TravelListDto> allSelect() {

		String sql = "select * from TRAVEL order by LISTNO desc";

		try {
			List<TravelListDto> list = jdbcTemplate.query(sql, new RowMapper<TravelListDto>() {
				@Override
				public TravelListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					TravelListDto travel = new TravelListDto();

					travel.setListno(rs.getInt("LISTNO"));
					travel.setTratype(rs.getString("TRATYPE"));
					travel.setTitle(rs.getString("TITLE"));
					travel.setUserid(rs.getString("USERID"));
					travel.setTradate(rs.getDate("TRADATE"));
					travel.setTracount(rs.getInt("TRACOUNT"));
					travel.setDescription(rs.getString("DESCRIPTION"));
					travel.setTrapic1(rs.getString("TRAPIC1"));
					travel.setTrapic2(rs.getString("TRAPIC2"));
					travel.setTrapic3(rs.getString("TRAPIC3"));
					travel.setTrapic4(rs.getString("TRAPIC4"));

					return travel;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TRAVELデータを全て取得する。（TRACOUNTが高い方から取得する。）
	public List<TravelListDto> allSelectodrcount() {

		String sql = "select * from TRAVEL order by TRACOUNT desc";

		try {
			List<TravelListDto> list = jdbcTemplate.query(sql, new RowMapper<TravelListDto>() {
				@Override
				public TravelListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					TravelListDto travel = new TravelListDto();

					travel.setListno(rs.getInt("LISTNO"));
					travel.setTratype(rs.getString("TRATYPE"));
					travel.setTitle(rs.getString("TITLE"));
					travel.setUserid(rs.getString("USERID"));
					travel.setTradate(rs.getDate("TRADATE"));
					travel.setTracount(rs.getInt("TRACOUNT"));
					travel.setDescription(rs.getString("DESCRIPTION"));
					travel.setTrapic1(rs.getString("TRAPIC1"));
					travel.setTrapic2(rs.getString("TRAPIC2"));
					travel.setTrapic3(rs.getString("TRAPIC3"));
					travel.setTrapic4(rs.getString("TRAPIC4"));

					return travel;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TITLEを条件でTRAVELデータを全て取得する。
	public List<TravelListDto> allSelectTitle(String title) {

		String sql = "select * from TRAVEL where TITLE like '%" + title + "%' order by LISTNO desc";

		try {
			List<TravelListDto> list = jdbcTemplate.query(sql, new RowMapper<TravelListDto>() {
				@Override
				public TravelListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					TravelListDto travel = new TravelListDto();

					travel.setListno(rs.getInt("LISTNO"));
					travel.setTratype(rs.getString("TRATYPE"));
					travel.setTitle(rs.getString("TITLE"));
					travel.setUserid(rs.getString("USERID"));
					travel.setTradate(rs.getDate("TRADATE"));
					travel.setTracount(rs.getInt("TRACOUNT"));
					travel.setDescription(rs.getString("DESCRIPTION"));
					travel.setTrapic1(rs.getString("TRAPIC1"));
					travel.setTrapic2(rs.getString("TRAPIC2"));
					travel.setTrapic3(rs.getString("TRAPIC3"));
					travel.setTrapic4(rs.getString("TRAPIC4"));

					return travel;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TITLEまたはTEXTを条件でTRAVELデータを全て取得する。
	public List<TravelListDto> allSelectTitleText(String text) {

		String sql = "select * from TRAVEL where TITLE like '%" + text + "%' or DESCRIPTION like '%" + text
				+ "%' order by LISTNO desc";

		try {
			List<TravelListDto> list = jdbcTemplate.query(sql, new RowMapper<TravelListDto>() {
				@Override
				public TravelListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					TravelListDto travel = new TravelListDto();

					travel.setListno(rs.getInt("LISTNO"));
					travel.setTratype(rs.getString("TRATYPE"));
					travel.setTitle(rs.getString("TITLE"));
					travel.setUserid(rs.getString("USERID"));
					travel.setTradate(rs.getDate("TRADATE"));
					travel.setTracount(rs.getInt("TRACOUNT"));
					travel.setDescription(rs.getString("DESCRIPTION"));
					travel.setTrapic1(rs.getString("TRAPIC1"));
					travel.setTrapic2(rs.getString("TRAPIC2"));
					travel.setTrapic3(rs.getString("TRAPIC3"));
					travel.setTrapic4(rs.getString("TRAPIC4"));

					return travel;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TYPEを条件でTRAVELデータを全て取得する。
	public List<TravelListDto> allSelectType(String text) {

		String sql = "select * from TRAVEL where TRATYPE like '%" + text + "%' order by LISTNO desc";

		try {
			List<TravelListDto> list = jdbcTemplate.query(sql, new RowMapper<TravelListDto>() {
				@Override
				public TravelListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					TravelListDto travel = new TravelListDto();

					travel.setListno(rs.getInt("LISTNO"));
					travel.setTratype(rs.getString("TRATYPE"));
					travel.setTitle(rs.getString("TITLE"));
					travel.setUserid(rs.getString("USERID"));
					travel.setTradate(rs.getDate("TRADATE"));
					travel.setTracount(rs.getInt("TRACOUNT"));
					travel.setDescription(rs.getString("DESCRIPTION"));
					travel.setTrapic1(rs.getString("TRAPIC1"));
					travel.setTrapic2(rs.getString("TRAPIC2"));
					travel.setTrapic3(rs.getString("TRAPIC3"));
					travel.setTrapic4(rs.getString("TRAPIC4"));

					return travel;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// USERIDを条件でTRAVELデータを全て取得する。
	public List<TravelListDto> allSelectUserid(String text) {

		String sql = "select * from TRAVEL where USERID like '%" + text + "%' order by LISTNO desc";

		try {
			List<TravelListDto> list = jdbcTemplate.query(sql, new RowMapper<TravelListDto>() {
				@Override
				public TravelListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					TravelListDto travel = new TravelListDto();

					travel.setListno(rs.getInt("LISTNO"));
					travel.setTratype(rs.getString("TRATYPE"));
					travel.setTitle(rs.getString("TITLE"));
					travel.setUserid(rs.getString("USERID"));
					travel.setTradate(rs.getDate("TRADATE"));
					travel.setTracount(rs.getInt("TRACOUNT"));
					travel.setDescription(rs.getString("DESCRIPTION"));
					travel.setTrapic1(rs.getString("TRAPIC1"));
					travel.setTrapic2(rs.getString("TRAPIC2"));
					travel.setTrapic3(rs.getString("TRAPIC3"));
					travel.setTrapic4(rs.getString("TRAPIC4"));

					return travel;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// LISTNOを条件でTRAVELデータを全て取得する。
	public TravelListDto allSelectListno(String listno) {

		String sql = "select * from TRAVEL where LISTNO='" + listno + "'";

		try {
			TravelListDto list = jdbcTemplate.queryForObject(sql, new RowMapper<TravelListDto>() {
				@Override
				public TravelListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					TravelListDto travel = new TravelListDto();

					travel.setListno(rs.getInt("LISTNO"));
					travel.setTratype(rs.getString("TRATYPE"));
					travel.setTitle(rs.getString("TITLE"));
					travel.setUserid(rs.getString("USERID"));
					travel.setTradate(rs.getDate("TRADATE"));
					travel.setTracount(rs.getInt("TRACOUNT"));
					travel.setDescription(rs.getString("DESCRIPTION"));
					travel.setTrapic1(rs.getString("TRAPIC1"));
					travel.setTrapic2(rs.getString("TRAPIC2"));
					travel.setTrapic3(rs.getString("TRAPIC3"));
					travel.setTrapic4(rs.getString("TRAPIC4"));

					return travel;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TRACOUNTを+1
	public int countUpdatelistno(final int count, final String listno) {

		final String sql = "update TRAVEL set TRACOUNT = ? where LISTNO = ?";

		// 正常終了の場合：0, 異常の場合：1
		int result = 0;

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setInt(1, count);
					pstmt.setString(2, listno);
					return pstmt;
				}
			});

			return result;
		} catch (DataAccessException ex) {
			result = 1;
			return result;
		}
	}

	// LISTNOを条件としてデータを削除
	public void allDeletelistno(final String listno) {

		final String sql = "delete from TRAVEL where LISTNO= ?";

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1, listno);

					return pstmt;
				}
			});
		} catch (DataAccessException ex) {
			// ログにエラーを表示するように後で作成。
		}
	}

	// TRAVEL情報をINSERT。
	public void insertTravel(final TravelListDto travel) {

		final String sql = "insert into TRAVEL(LISTNO, TRATYPE, TITLE, USERID, TRADATE, TRACOUNT, DESCRIPTION, TRAPIC1, TRAPIC2, TRAPIC3, TRAPIC4) values(LISTNO_SEQ.nextval, ?, ?, ?, SYSDATE + 1, ?, ?, ?, ?, ?, ?)";

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1, travel.getTratype());
					pstmt.setString(2, travel.getTitle());
					pstmt.setString(3, travel.getUserid());
					pstmt.setInt(4, travel.getTracount());
					pstmt.setString(5, travel.getDescription());
					pstmt.setString(6, travel.getTrapic1());
					pstmt.setString(7, travel.getTrapic2());
					pstmt.setString(8, travel.getTrapic3());
					pstmt.setString(9, travel.getTrapic4());
					return pstmt;
				}
			});
		} catch (DataAccessException ex) {
			// ログにエラーを表示するように後で作成。
		}
	}

	// リスト番号を条件としてデータを変更
	public int allUpdatelistno(final TravelListDto travel) {

		final String sql = "update TRAVEL set TRATYPE = ?, TITLE = ?, DESCRIPTION = ?, TRAPIC1 = ?, TRAPIC2 = ?, TRAPIC3 = ?, TRAPIC4 = ? where LISTNO = ?";

		// 正常終了の場合：0, 異常の場合：1
		int result = 0;

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1, travel.getTratype());
					pstmt.setString(2, travel.getTitle());
					pstmt.setString(3, travel.getDescription());
					pstmt.setString(4, travel.getTrapic1());
					pstmt.setString(5, travel.getTrapic2());
					pstmt.setString(6, travel.getTrapic3());
					pstmt.setString(7, travel.getTrapic4());
					pstmt.setInt(8, travel.getListno());
					return pstmt;
				}
			});

			return result;
		} catch (DataAccessException ex) {
			result = 1;
			return result;
		}
	}
}
