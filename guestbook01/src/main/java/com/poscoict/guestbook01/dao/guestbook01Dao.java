package com.poscoict.guestbook01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poscoict.guestbook01.vo.guestbook01Vo;

public class guestbook01Dao {
	public List<guestbook01Vo> findAll() {
		
		List<guestbook01Vo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = getConnection();

			// 3.SQL 준비
			String sql = "select no, name, DATE_FORMAT(reg_date, '%Y/%m/%d %H:%i:%s'), message from guestbook order by reg_date desc";
			pstmt = conn.prepareStatement(sql);

			// 4.바인딩(binding)

			// 5.SQL 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
//				String password = rs.getString(3);
				String reg_date = rs.getString(3);
				String message = rs.getString(4);

				guestbook01Vo vo = new guestbook01Vo();
				vo.setNo(no);
				vo.setName(name);
//				vo.setPassword(password);
				vo.setReg_date(reg_date);
				vo.setMessage(message);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.print("error : " + e);
		} finally {
			// 자원 정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;
	}

	public boolean insert(guestbook01Vo vo) throws ClassNotFoundException {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			
			// 3.SQL 준비
			String sql = "insert into guestbook values(null, ?, ?, ?, now()) ";
			pstmt = conn.prepareStatement(sql);

			// 4.바인딩(binding)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());

			// 5.SQL 실행
			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.print("error : " + e);
		} finally {
			// 자원 정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) { // catch하기 싫으면 함수에서 throws SQLException 사용
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;
	}

	public boolean delete(guestbook01Vo vo) throws ClassNotFoundException {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3.SQL 준비
			String sql = " delete from guestbook where no=? and password=?";
			pstmt = conn.prepareStatement(sql);

			// 4.바인딩(binding)
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getPassword());
			
			int deleteNum = pstmt.executeUpdate();
			if (deleteNum != 1)
				result = false;
//			pstmt.setInt(1, vo.getNo());
//			pstmt.setString(2, vo.getName());
//			pstmt.setString(3, vo.getReg_date());
//			pstmt.setString(2, vo.getMessage());

			// 5.SQL 실행
//			result = pstmt.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.print("error : " + e);
		} finally {
			// 자원 정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) { // catch하기 싫으면 함수에서 throws SQLException 사용
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;
	}

	 private Connection getConnection() throws SQLException {
	      Connection conn = null;

	      try {
	         // 1. JDBC 드라이버 로딩
	         Class.forName("org.mariadb.jdbc.Driver");

	         // 2. 연결하기
	         String url = "jdbc:mysql://192.168.0.72:3307/webdb?characterEncoding=UTF-8&serverTimezone=UTC";
	         conn = DriverManager.getConnection(url, "webdb", "webdb");
	      } catch (ClassNotFoundException e) {
	         System.out.print("드라이버 로딩 실패 : " + e);
	      }
	      return conn;
	   }
	}
