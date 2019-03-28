package com.leesungbok.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.leesungbok.dto.MemberDto;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// IDを条件として一致するIDを検索。
	public MemberDto idSelectById(String id) {

		String userid = id;
		String sql = "select USERID from MEMBER where USERID = ?";

		try {
			MemberDto list = jdbcTemplate.queryForObject(sql, new RowMapper<MemberDto>() {
				@Override
				public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					MemberDto member = new MemberDto();

					member.setUserid(rs.getString("USERID"));

					return member;
				}
			}, userid);

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// PHONEを条件として一致するUSERID,PHONEを検索。
	public MemberDto allSelectByPh(String phone) {

		String userphone = phone;
		String sql = "select * from MEMBER where PHONE = ?";

		try {
			MemberDto list = jdbcTemplate.queryForObject(sql, new RowMapper<MemberDto>() {
				@Override
				public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					MemberDto member = new MemberDto();

					member.setName(rs.getString("NAME"));
					member.setUserid(rs.getString("USERID"));
					member.setPwd(rs.getString("PWD"));
					member.setEmail(rs.getString("EMAIL"));
					member.setPhone(rs.getString("PHONE"));

					return member;
				}
			}, userphone);

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// IDを条件で一致する会員の情報を全て取得。
	public MemberDto allSelectById(String id) {

		String userid = id;
		String sql = "select * from MEMBER where USERID = ?";

		try {
			MemberDto list = jdbcTemplate.queryForObject(sql, new RowMapper<MemberDto>() {
				@Override
				public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {

					if (rs == null) {
						return null;
					}
					MemberDto member = new MemberDto();

					member.setName(rs.getString("NAME"));
					member.setUserid(rs.getString("USERID"));
					member.setPwd(rs.getString("PWD"));
					member.setEmail(rs.getString("EMAIL"));
					member.setPhone(rs.getString("PHONE"));
					member.setAdmin(rs.getInt("ADMIN"));

					return member;
				}
			}, userid);

			return list;

		} catch (DataAccessException ex) {
			return null;
		}

	}

	// 使用者情報をINSERT。
	public void insertMember(final MemberDto member) {

		final String sql = "insert into MEMBER(NAME, USERID, PWD, EMAIL, PHONE, ADMIN) values(?, ?, ?, ?, ?, ?)";

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1, member.getName());
					pstmt.setString(2, member.getUserid());
					pstmt.setString(3, member.getPwd());
					pstmt.setString(4, member.getEmail());
					pstmt.setString(5, member.getPhone());
					pstmt.setInt(6, member.getAdmin());
					return pstmt;
				}
			});
		} catch (DataAccessException ex) {
			// ログにエラーを表示するように後で作成。
		}
	}

	// 使用者情報をINSERT。
	public int allUpdateId(final String userid, final String userpw, final String username, final String useremail,
			final String userphone) {

		final String sql = "update MEMBER set PWD = ?, NAME = ?, EMAIL = ?, PHONE = ? where USERID = ?";

		// 正常終了の場合：0, 異常の場合：1
		int result = 0;

		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1, userpw);
					pstmt.setString(2, username);
					pstmt.setString(3, useremail);
					pstmt.setString(4, userphone);
					pstmt.setString(5, userid);
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
