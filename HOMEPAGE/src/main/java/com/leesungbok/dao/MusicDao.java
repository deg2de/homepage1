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

import com.leesungbok.dto.MusicListDto;

public class MusicDao {

	private JdbcTemplate jdbcTemplate;

	public MusicDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	// MUSICデータを全て取得する。
	public List<MusicListDto> allSelect() {

		String sql = "select * from MUSIC order by LISTNO desc";

		try {
			List<MusicListDto> list = jdbcTemplate.query(sql, new RowMapper<MusicListDto>() {
				@Override
				public MusicListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					MusicListDto music = new MusicListDto();

					music.setListno(rs.getInt("LISTNO"));
					music.setMustype(rs.getString("MUSTYPE"));
					music.setTitle(rs.getString("TITLE"));
					music.setUserid(rs.getString("USERID"));
					music.setMusdate(rs.getDate("MUSDATE"));
					music.setMuscount(rs.getInt("MUSCOUNT"));
					music.setDescription(rs.getString("DESCRIPTION"));
					music.setMuspic1(rs.getString("MUSPIC1"));
					music.setMuspic2(rs.getString("MUSPIC2"));
					music.setMuspic3(rs.getString("MUSPIC3"));
					music.setMuspic4(rs.getString("MUSPIC4"));

					return music;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// MUSICデータを全て取得する。（MUSCOUNTが高い方から取得する。）
	public List<MusicListDto> allSelectodrcount() {

		String sql = "select * from MUSIC order by MUSCOUNT desc";

		try {
			List<MusicListDto> list = jdbcTemplate.query(sql, new RowMapper<MusicListDto>() {
				@Override
				public MusicListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					MusicListDto music = new MusicListDto();

					music.setListno(rs.getInt("LISTNO"));
					music.setMustype(rs.getString("MUSTYPE"));
					music.setTitle(rs.getString("TITLE"));
					music.setUserid(rs.getString("USERID"));
					music.setMusdate(rs.getDate("MUSDATE"));
					music.setMuscount(rs.getInt("MUSCOUNT"));
					music.setDescription(rs.getString("DESCRIPTION"));
					music.setMuspic1(rs.getString("MUSPIC1"));
					music.setMuspic2(rs.getString("MUSPIC2"));
					music.setMuspic3(rs.getString("MUSPIC3"));
					music.setMuspic4(rs.getString("MUSPIC4"));

					return music;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TITLEを条件でMUSICデータを全て取得する。
	public List<MusicListDto> allSelectTitle(String title) {

		String sql = "select * from MUSIC where TITLE like '%" + title + "%' order by LISTNO desc";

		try {
			List<MusicListDto> list = jdbcTemplate.query(sql, new RowMapper<MusicListDto>() {
				@Override
				public MusicListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					MusicListDto music = new MusicListDto();

					music.setListno(rs.getInt("LISTNO"));
					music.setMustype(rs.getString("MUSTYPE"));
					music.setTitle(rs.getString("TITLE"));
					music.setUserid(rs.getString("USERID"));
					music.setMusdate(rs.getDate("MUSDATE"));
					music.setMuscount(rs.getInt("MUSCOUNT"));
					music.setDescription(rs.getString("DESCRIPTION"));
					music.setMuspic1(rs.getString("MUSPIC1"));
					music.setMuspic2(rs.getString("MUSPIC2"));
					music.setMuspic3(rs.getString("MUSPIC3"));
					music.setMuspic4(rs.getString("MUSPIC4"));

					return music;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TITLEまたはTEXTを条件でMUSICデータを全て取得する。
	public List<MusicListDto> allSelectTitleText(String text) {

		String sql = "select * from MUSIC where TITLE like '%" + text + "%' or DESCRIPTION like '%" + text
				+ "%' order by LISTNO desc";

		try {
			List<MusicListDto> list = jdbcTemplate.query(sql, new RowMapper<MusicListDto>() {
				@Override
				public MusicListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					MusicListDto music = new MusicListDto();

					music.setListno(rs.getInt("LISTNO"));
					music.setMustype(rs.getString("MUSTYPE"));
					music.setTitle(rs.getString("TITLE"));
					music.setUserid(rs.getString("USERID"));
					music.setMusdate(rs.getDate("MUSDATE"));
					music.setMuscount(rs.getInt("MUSCOUNT"));
					music.setDescription(rs.getString("DESCRIPTION"));
					music.setMuspic1(rs.getString("MUSPIC1"));
					music.setMuspic2(rs.getString("MUSPIC2"));
					music.setMuspic3(rs.getString("MUSPIC3"));
					music.setMuspic4(rs.getString("MUSPIC4"));

					return music;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// TYPEを条件でMUSICデータを全て取得する。
	public List<MusicListDto> allSelectType(String text) {

		String sql = "select * from MUSIC where MUSTYPE like '%" + text + "%' order by LISTNO desc";

		try {
			List<MusicListDto> list = jdbcTemplate.query(sql, new RowMapper<MusicListDto>() {
				@Override
				public MusicListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					MusicListDto music = new MusicListDto();

					music.setListno(rs.getInt("LISTNO"));
					music.setMustype(rs.getString("MUSTYPE"));
					music.setTitle(rs.getString("TITLE"));
					music.setUserid(rs.getString("USERID"));
					music.setMusdate(rs.getDate("MUSDATE"));
					music.setMuscount(rs.getInt("MUSCOUNT"));
					music.setDescription(rs.getString("DESCRIPTION"));
					music.setMuspic1(rs.getString("MUSPIC1"));
					music.setMuspic2(rs.getString("MUSPIC2"));
					music.setMuspic3(rs.getString("MUSPIC3"));
					music.setMuspic4(rs.getString("MUSPIC4"));

					return music;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// USERIDを条件でMUSICデータを全て取得する。
	public List<MusicListDto> allSelectUserid(String text) {

		String sql = "select * from MUSIC where USERID like '%" + text + "%' order by LISTNO desc";

		try {
			List<MusicListDto> list = jdbcTemplate.query(sql, new RowMapper<MusicListDto>() {
				@Override
				public MusicListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					MusicListDto music = new MusicListDto();

					music.setListno(rs.getInt("LISTNO"));
					music.setMustype(rs.getString("MUSTYPE"));
					music.setTitle(rs.getString("TITLE"));
					music.setUserid(rs.getString("USERID"));
					music.setMusdate(rs.getDate("MUSDATE"));
					music.setMuscount(rs.getInt("MUSCOUNT"));
					music.setDescription(rs.getString("DESCRIPTION"));
					music.setMuspic1(rs.getString("MUSPIC1"));
					music.setMuspic2(rs.getString("MUSPIC2"));
					music.setMuspic3(rs.getString("MUSPIC3"));
					music.setMuspic4(rs.getString("MUSPIC4"));

					return music;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// LISTNOを条件でMUSICデータを全て取得する。
	public MusicListDto allSelectListno(String listno) {

		String sql = "select * from MUSIC where LISTNO='" + listno + "'";

		try {
			MusicListDto list = jdbcTemplate.queryForObject(sql, new RowMapper<MusicListDto>() {
				@Override
				public MusicListDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					MusicListDto music = new MusicListDto();

					music.setListno(rs.getInt("LISTNO"));
					music.setMustype(rs.getString("MUSTYPE"));
					music.setTitle(rs.getString("TITLE"));
					music.setUserid(rs.getString("USERID"));
					music.setMusdate(rs.getDate("MUSDATE"));
					music.setMuscount(rs.getInt("MUSCOUNT"));
					music.setDescription(rs.getString("DESCRIPTION"));
					music.setMuspic1(rs.getString("MUSPIC1"));
					music.setMuspic2(rs.getString("MUSPIC2"));
					music.setMuspic3(rs.getString("MUSPIC3"));
					music.setMuspic4(rs.getString("MUSPIC4"));

					return music;
				}
			});

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// MUSCOUNTを+1
	public int countUpdatelistno(final int count, final String listno) {

		final String sql = "update MUSIC set MUSCOUNT = ? where LISTNO = ?";

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

		final String sql = "delete from MUSIC where LISTNO= ?";

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

	// MUSIC情報をINSERT。
	public void insertMusic(final MusicListDto music) {

		final String sql = "insert into MUSIC(LISTNO, MUSTYPE, TITLE, USERID, MUSDATE, MUSCOUNT, DESCRIPTION, MUSPIC1, MUSPIC2, MUSPIC3, MUSPIC4) values(LISTNO_SEQ.nextval, ?, ?, ?, SYSDATE + 1, ?, ?, ?, ?, ?, ?)";

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1, music.getMustype());
					pstmt.setString(2, music.getTitle());
					pstmt.setString(3, music.getUserid());
					pstmt.setInt(4, music.getMuscount());
					pstmt.setString(5, music.getDescription());
					pstmt.setString(6, music.getMuspic1());
					pstmt.setString(7, music.getMuspic2());
					pstmt.setString(8, music.getMuspic3());
					pstmt.setString(9, music.getMuspic4());
					return pstmt;
				}
			});
		} catch (DataAccessException ex) {
			// ログにエラーを表示するように後で作成。
		}
	}

	// リスト番号を条件としてデータを変更
	public int allUpdatelistno(final MusicListDto music) {

		final String sql = "update MUSIC set MUSTYPE = ?, TITLE = ?, DESCRIPTION = ?, MUSPIC1 = ?, MUSPIC2 = ?, MUSPIC3 = ?, MUSPIC4 = ? where LISTNO = ?";

		// 正常終了の場合：0, 異常の場合：1
		int result = 0;

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1, music.getMustype());
					pstmt.setString(2, music.getTitle());
					pstmt.setString(3, music.getDescription());
					pstmt.setString(4, music.getMuspic1());
					pstmt.setString(5, music.getMuspic2());
					pstmt.setString(6, music.getMuspic3());
					pstmt.setString(7, music.getMuspic4());
					pstmt.setInt(8, music.getListno());
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
