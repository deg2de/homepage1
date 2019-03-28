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

import com.leesungbok.dto.ProgrammingListDto;

public class ProgrammingDao {

	private JdbcTemplate jdbcTemplate;

	public ProgrammingDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// PROGRAMMINGデータを全て取得する。
	public List<ProgrammingListDto> allSelect() {

		String sql = "select * from PROGRAMMING order by LISTNO desc";

		try {
			List<ProgrammingListDto> list = jdbcTemplate.query(sql, new RowMapper<ProgrammingListDto>() {
				@Override
				public ProgrammingListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					ProgrammingListDto programming = new ProgrammingListDto();

					programming.setListno(rs.getInt("LISTNO"));
					programming.setProtype(rs.getString("PROTYPE"));
					programming.setTitle(rs.getString("TITLE"));
					programming.setUserid(rs.getString("USERID"));
					programming.setProdate(rs.getDate("PRODATE"));
					programming.setProcount(rs.getInt("PROCOUNT"));
					programming.setDescription(rs.getString("DESCRIPTION"));
					programming.setPropic1(rs.getString("PROPIC1"));
					programming.setPropic2(rs.getString("PROPIC2"));
					programming.setPropic3(rs.getString("PROPIC3"));
					programming.setPropic4(rs.getString("PROPIC4"));

					return programming;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// PROGRAMMINGデータを全て取得する。（PROCOUNTが高い方から取得する。）
	public List<ProgrammingListDto> allSelectodrcount() {

		String sql = "select * from PROGRAMMING order by PROCOUNT desc";

		try {
			List<ProgrammingListDto> list = jdbcTemplate.query(sql, new RowMapper<ProgrammingListDto>() {
				@Override
				public ProgrammingListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					ProgrammingListDto programming = new ProgrammingListDto();

					programming.setListno(rs.getInt("LISTNO"));
					programming.setProtype(rs.getString("PROTYPE"));
					programming.setTitle(rs.getString("TITLE"));
					programming.setUserid(rs.getString("USERID"));
					programming.setProdate(rs.getDate("PRODATE"));
					programming.setProcount(rs.getInt("PROCOUNT"));
					programming.setDescription(rs.getString("DESCRIPTION"));
					programming.setPropic1(rs.getString("PROPIC1"));
					programming.setPropic2(rs.getString("PROPIC2"));
					programming.setPropic3(rs.getString("PROPIC3"));
					programming.setPropic4(rs.getString("PROPIC4"));

					return programming;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TITLEを条件でPROGRAMMINGデータを全て取得する。
	public List<ProgrammingListDto> allSelectTitle(String title) {

		String sql = "select * from PROGRAMMING where TITLE like '%" + title + "%' order by LISTNO desc";

		try {
			List<ProgrammingListDto> list = jdbcTemplate.query(sql, new RowMapper<ProgrammingListDto>() {
				@Override
				public ProgrammingListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					ProgrammingListDto programming = new ProgrammingListDto();

					programming.setListno(rs.getInt("LISTNO"));
					programming.setProtype(rs.getString("PROTYPE"));
					programming.setTitle(rs.getString("TITLE"));
					programming.setUserid(rs.getString("USERID"));
					programming.setProdate(rs.getDate("PRODATE"));
					programming.setProcount(rs.getInt("PROCOUNT"));
					programming.setDescription(rs.getString("DESCRIPTION"));
					programming.setPropic1(rs.getString("PROPIC1"));
					programming.setPropic2(rs.getString("PROPIC2"));
					programming.setPropic3(rs.getString("PROPIC3"));
					programming.setPropic4(rs.getString("PROPIC4"));

					return programming;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TITLEまたはTEXTを条件でPROGRAMMINGデータを全て取得する。
	public List<ProgrammingListDto> allSelectTitleText(String text) {

		String sql = "select * from PROGRAMMING where TITLE like '%" + text + "%' or DESCRIPTION like '%" + text
				+ "%' order by LISTNO desc";

		try {
			List<ProgrammingListDto> list = jdbcTemplate.query(sql, new RowMapper<ProgrammingListDto>() {
				@Override
				public ProgrammingListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					ProgrammingListDto programming = new ProgrammingListDto();

					programming.setListno(rs.getInt("LISTNO"));
					programming.setProtype(rs.getString("PROTYPE"));
					programming.setTitle(rs.getString("TITLE"));
					programming.setUserid(rs.getString("USERID"));
					programming.setProdate(rs.getDate("PRODATE"));
					programming.setProcount(rs.getInt("PROCOUNT"));
					programming.setDescription(rs.getString("DESCRIPTION"));
					programming.setPropic1(rs.getString("PROPIC1"));
					programming.setPropic2(rs.getString("PROPIC2"));
					programming.setPropic3(rs.getString("PROPIC3"));
					programming.setPropic4(rs.getString("PROPIC4"));

					return programming;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TYPEを条件でPROGRAMMINGデータを全て取得する。
	public List<ProgrammingListDto> allSelectType(String text) {

		String sql = "select * from PROGRAMMING where PROTYPE like '%" + text + "%' order by LISTNO desc";

		try {
			List<ProgrammingListDto> list = jdbcTemplate.query(sql, new RowMapper<ProgrammingListDto>() {
				@Override
				public ProgrammingListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					ProgrammingListDto programming = new ProgrammingListDto();

					programming.setListno(rs.getInt("LISTNO"));
					programming.setProtype(rs.getString("PROTYPE"));
					programming.setTitle(rs.getString("TITLE"));
					programming.setUserid(rs.getString("USERID"));
					programming.setProdate(rs.getDate("PRODATE"));
					programming.setProcount(rs.getInt("PROCOUNT"));
					programming.setDescription(rs.getString("DESCRIPTION"));
					programming.setPropic1(rs.getString("PROPIC1"));
					programming.setPropic2(rs.getString("PROPIC2"));
					programming.setPropic3(rs.getString("PROPIC3"));
					programming.setPropic4(rs.getString("PROPIC4"));

					return programming;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// USERIDを条件でPROGRAMMINGデータを全て取得する。
	public List<ProgrammingListDto> allSelectUserid(String text) {

		String sql = "select * from PROGRAMMING where USERID like '%" + text + "%' order by LISTNO desc";

		try {
			List<ProgrammingListDto> list = jdbcTemplate.query(sql, new RowMapper<ProgrammingListDto>() {
				@Override
				public ProgrammingListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					ProgrammingListDto programming = new ProgrammingListDto();

					programming.setListno(rs.getInt("LISTNO"));
					programming.setProtype(rs.getString("PROTYPE"));
					programming.setTitle(rs.getString("TITLE"));
					programming.setUserid(rs.getString("USERID"));
					programming.setProdate(rs.getDate("PRODATE"));
					programming.setProcount(rs.getInt("PROCOUNT"));
					programming.setDescription(rs.getString("DESCRIPTION"));
					programming.setPropic1(rs.getString("PROPIC1"));
					programming.setPropic2(rs.getString("PROPIC2"));
					programming.setPropic3(rs.getString("PROPIC3"));
					programming.setPropic4(rs.getString("PROPIC4"));

					return programming;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// LISTNOを条件でPROGRAMMINGデータを全て取得する。
	public ProgrammingListDto allSelectListno(String listno) {

		String sql = "select * from PROGRAMMING where LISTNO='" + listno + "'";

		try {
			ProgrammingListDto list = jdbcTemplate.queryForObject(sql, new RowMapper<ProgrammingListDto>() {
				@Override
				public ProgrammingListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					ProgrammingListDto programming = new ProgrammingListDto();

					programming.setListno(rs.getInt("LISTNO"));
					programming.setProtype(rs.getString("PROTYPE"));
					programming.setTitle(rs.getString("TITLE"));
					programming.setUserid(rs.getString("USERID"));
					programming.setProdate(rs.getDate("PRODATE"));
					programming.setProcount(rs.getInt("PROCOUNT"));
					programming.setDescription(rs.getString("DESCRIPTION"));
					programming.setPropic1(rs.getString("PROPIC1"));
					programming.setPropic2(rs.getString("PROPIC2"));
					programming.setPropic3(rs.getString("PROPIC3"));
					programming.setPropic4(rs.getString("PROPIC4"));

					return programming;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// PROCOUNTを+1
	public int countUpdatelistno(final int count, final String listno) {

		final String sql = "update PROGRAMMING set PROCOUNT = ? where LISTNO = ?";

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

		final String sql = "delete from PROGRAMMING where LISTNO= ?";

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

	// PROGRAMMING情報をINSERT。
	public void insertProgramming(final ProgrammingListDto programming) {

		final String sql = "insert into PROGRAMMING(LISTNO, PROTYPE, TITLE, USERID, PRODATE, PROCOUNT, DESCRIPTION, PROPIC1, PROPIC2, PROPIC3, PROPIC4) values(LISTNO_SEQ.nextval, ?, ?, ?, SYSDATE + 1, ?, ?, ?, ?, ?, ?)";

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1, programming.getProtype());
					pstmt.setString(2, programming.getTitle());
					pstmt.setString(3, programming.getUserid());
					pstmt.setInt(4, programming.getProcount());
					pstmt.setString(5, programming.getDescription());
					pstmt.setString(6, programming.getPropic1());
					pstmt.setString(7, programming.getPropic2());
					pstmt.setString(8, programming.getPropic3());
					pstmt.setString(9, programming.getPropic4());
					return pstmt;
				}
			});
		} catch (DataAccessException ex) {
			// ログにエラーを表示するように後で作成。
		}
	}

	// リスト番号を条件としてデータを変更
	public int allUpdatelistno(final ProgrammingListDto programming) {

		final String sql = "update PROGRAMMING set PROTYPE = ?, TITLE = ?, DESCRIPTION = ?, PROPIC1 = ?, PROPIC2 = ?, PROPIC3 = ?, PROPIC4 = ? where LISTNO = ?";

		// 正常終了の場合：0, 異常の場合：1
		int result = 0;

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1, programming.getProtype());
					pstmt.setString(2, programming.getTitle());
					pstmt.setString(3, programming.getDescription());
					pstmt.setString(4, programming.getPropic1());
					pstmt.setString(5, programming.getPropic2());
					pstmt.setString(6, programming.getPropic3());
					pstmt.setString(7, programming.getPropic4());
					pstmt.setInt(8, programming.getListno());
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
