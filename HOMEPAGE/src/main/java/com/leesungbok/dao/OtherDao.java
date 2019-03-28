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

import com.leesungbok.dto.OtherListDto;

public class OtherDao {

	private JdbcTemplate jdbcTemplate;

	public OtherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	// OTHERデータを全て取得する。
	public List<OtherListDto> allSelect() {

		String sql = "select * from OTHER order by LISTNO desc";

		try {
			List<OtherListDto> list = jdbcTemplate.query(sql, new RowMapper<OtherListDto>() {
				@Override
				public OtherListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					OtherListDto other = new OtherListDto();

					other.setListno(rs.getInt("LISTNO"));
					other.setOthtype(rs.getString("OTHTYPE"));
					other.setTitle(rs.getString("TITLE"));
					other.setUserid(rs.getString("USERID"));
					other.setOthdate(rs.getDate("OTHDATE"));
					other.setOthcount(rs.getInt("OTHCOUNT"));
					other.setDescription(rs.getString("DESCRIPTION"));
					other.setOthpic1(rs.getString("OTHPIC1"));
					other.setOthpic2(rs.getString("OTHPIC2"));
					other.setOthpic3(rs.getString("OTHPIC3"));
					other.setOthpic4(rs.getString("OTHPIC4"));

					return other;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// OTHERデータを全て取得する。（OTHCOUNTが高い方から取得する。）
	public List<OtherListDto> allSelectodrcount() {

		String sql = "select * from OTHER order by OTHCOUNT desc";

		try {
			List<OtherListDto> list = jdbcTemplate.query(sql, new RowMapper<OtherListDto>() {
				@Override
				public OtherListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					OtherListDto other = new OtherListDto();

					other.setListno(rs.getInt("LISTNO"));
					other.setOthtype(rs.getString("OTHTYPE"));
					other.setTitle(rs.getString("TITLE"));
					other.setUserid(rs.getString("USERID"));
					other.setOthdate(rs.getDate("OTHDATE"));
					other.setOthcount(rs.getInt("OTHCOUNT"));
					other.setDescription(rs.getString("DESCRIPTION"));
					other.setOthpic1(rs.getString("OTHPIC1"));
					other.setOthpic2(rs.getString("OTHPIC2"));
					other.setOthpic3(rs.getString("OTHPIC3"));
					other.setOthpic4(rs.getString("OTHPIC4"));

					return other;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TITLEを条件でOTHERデータを全て取得する。
	public List<OtherListDto> allSelectTitle(String title) {

		String sql = "select * from OTHER where TITLE like '%" + title + "%' order by LISTNO desc";

		try {
			List<OtherListDto> list = jdbcTemplate.query(sql, new RowMapper<OtherListDto>() {
				@Override
				public OtherListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					OtherListDto other = new OtherListDto();

					other.setListno(rs.getInt("LISTNO"));
					other.setOthtype(rs.getString("OTHTYPE"));
					other.setTitle(rs.getString("TITLE"));
					other.setUserid(rs.getString("USERID"));
					other.setOthdate(rs.getDate("OTHDATE"));
					other.setOthcount(rs.getInt("OTHCOUNT"));
					other.setDescription(rs.getString("DESCRIPTION"));
					other.setOthpic1(rs.getString("OTHPIC1"));
					other.setOthpic2(rs.getString("OTHPIC2"));
					other.setOthpic3(rs.getString("OTHPIC3"));
					other.setOthpic4(rs.getString("OTHPIC4"));

					return other;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TITLEまたはTEXTを条件でOTHERデータを全て取得する。
	public List<OtherListDto> allSelectTitleText(String text) {

		String sql = "select * from OTHER where TITLE like '%" + text + "%' or DESCRIPTION like '%" + text
				+ "%' order by LISTNO desc";

		try {
			List<OtherListDto> list = jdbcTemplate.query(sql, new RowMapper<OtherListDto>() {
				@Override
				public OtherListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					OtherListDto other = new OtherListDto();

					other.setListno(rs.getInt("LISTNO"));
					other.setOthtype(rs.getString("OTHTYPE"));
					other.setTitle(rs.getString("TITLE"));
					other.setUserid(rs.getString("USERID"));
					other.setOthdate(rs.getDate("OTHDATE"));
					other.setOthcount(rs.getInt("OTHCOUNT"));
					other.setDescription(rs.getString("DESCRIPTION"));
					other.setOthpic1(rs.getString("OTHPIC1"));
					other.setOthpic2(rs.getString("OTHPIC2"));
					other.setOthpic3(rs.getString("OTHPIC3"));
					other.setOthpic4(rs.getString("OTHPIC4"));

					return other;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TYPEを条件でOTHERデータを全て取得する。
	public List<OtherListDto> allSelectType(String text) {

		String sql = "select * from OTHER where OTHTYPE like '%" + text + "%' order by LISTNO desc";

		try {
			List<OtherListDto> list = jdbcTemplate.query(sql, new RowMapper<OtherListDto>() {
				@Override
				public OtherListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					OtherListDto other = new OtherListDto();

					other.setListno(rs.getInt("LISTNO"));
					other.setOthtype(rs.getString("OTHTYPE"));
					other.setTitle(rs.getString("TITLE"));
					other.setUserid(rs.getString("USERID"));
					other.setOthdate(rs.getDate("OTHDATE"));
					other.setOthcount(rs.getInt("OTHCOUNT"));
					other.setDescription(rs.getString("DESCRIPTION"));
					other.setOthpic1(rs.getString("OTHPIC1"));
					other.setOthpic2(rs.getString("OTHPIC2"));
					other.setOthpic3(rs.getString("OTHPIC3"));
					other.setOthpic4(rs.getString("OTHPIC4"));

					return other;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// USERIDを条件でOTHERデータを全て取得する。
	public List<OtherListDto> allSelectUserid(String text) {

		String sql = "select * from OTHER where USERID like '%" + text + "%' order by LISTNO desc";

		try {
			List<OtherListDto> list = jdbcTemplate.query(sql, new RowMapper<OtherListDto>() {
				@Override
				public OtherListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					OtherListDto other = new OtherListDto();

					other.setListno(rs.getInt("LISTNO"));
					other.setOthtype(rs.getString("OTHTYPE"));
					other.setTitle(rs.getString("TITLE"));
					other.setUserid(rs.getString("USERID"));
					other.setOthdate(rs.getDate("OTHDATE"));
					other.setOthcount(rs.getInt("OTHCOUNT"));
					other.setDescription(rs.getString("DESCRIPTION"));
					other.setOthpic1(rs.getString("OTHPIC1"));
					other.setOthpic2(rs.getString("OTHPIC2"));
					other.setOthpic3(rs.getString("OTHPIC3"));
					other.setOthpic4(rs.getString("OTHPIC4"));

					return other;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// LISTNOを条件でOTHERデータを全て取得する。
	public OtherListDto allSelectListno(String listno) {

		String sql = "select * from OTHER where LISTNO='" + listno + "'";

		try {
			OtherListDto list = jdbcTemplate.queryForObject(sql, new RowMapper<OtherListDto>() {
				@Override
				public OtherListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					OtherListDto other = new OtherListDto();

					other.setListno(rs.getInt("LISTNO"));
					other.setOthtype(rs.getString("OTHTYPE"));
					other.setTitle(rs.getString("TITLE"));
					other.setUserid(rs.getString("USERID"));
					other.setOthdate(rs.getDate("OTHDATE"));
					other.setOthcount(rs.getInt("OTHCOUNT"));
					other.setDescription(rs.getString("DESCRIPTION"));
					other.setOthpic1(rs.getString("OTHPIC1"));
					other.setOthpic2(rs.getString("OTHPIC2"));
					other.setOthpic3(rs.getString("OTHPIC3"));
					other.setOthpic4(rs.getString("OTHPIC4"));

					return other;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// OTHCOUNTを+1
	public int countUpdatelistno(final int count, final String listno) {

		final String sql = "update OTHER set OTHCOUNT = ? where LISTNO = ?";

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

		final String sql = "delete from OTHER where LISTNO= ?";

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

	// OTHER情報をINSERT。
	public void insertOther(final OtherListDto other) {

		final String sql = "insert into OTHER(LISTNO, OTHTYPE, TITLE, USERID, OTHDATE, OTHCOUNT, DESCRIPTION, OTHPIC1, OTHPIC2, OTHPIC3, OTHPIC4) values(LISTNO_SEQ.nextval, ?, ?, ?, SYSDATE + 1, ?, ?, ?, ?, ?, ?)";

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1, other.getOthtype());
					pstmt.setString(2, other.getTitle());
					pstmt.setString(3, other.getUserid());
					pstmt.setInt(4, other.getOthcount());
					pstmt.setString(5, other.getDescription());
					pstmt.setString(6, other.getOthpic1());
					pstmt.setString(7, other.getOthpic2());
					pstmt.setString(8, other.getOthpic3());
					pstmt.setString(9, other.getOthpic4());
					return pstmt;
				}
			});
		} catch (DataAccessException ex) {
			// ログにエラーを表示するように後で作成。
		}
	}

	// リスト番号を条件としてデータを変更
	public int allUpdatelistno(final OtherListDto other) {

		final String sql = "update OTHER set OTHTYPE = ?, TITLE = ?, DESCRIPTION = ?, OTHPIC1 = ?, OTHPIC2 = ?, OTHPIC3 = ?, OTHPIC4 = ? where LISTNO = ?";

		// 正常終了の場合：0, 異常の場合：1
		int result = 0;

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1, other.getOthtype());
					pstmt.setString(2, other.getTitle());
					pstmt.setString(3, other.getDescription());
					pstmt.setString(4, other.getOthpic1());
					pstmt.setString(5, other.getOthpic2());
					pstmt.setString(6, other.getOthpic3());
					pstmt.setString(7, other.getOthpic4());
					pstmt.setInt(8, other.getListno());
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
