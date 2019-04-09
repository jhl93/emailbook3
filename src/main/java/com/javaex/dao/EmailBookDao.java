package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.EmailBookVo;

@Repository
public class EmailBookDao {

	@Autowired
	private SqlSession sqlsession;
	
	public List<EmailBookVo> getList(){
		
		List<EmailBookVo> list = sqlsession.selectList("emailbook.selectList");
		System.out.println(list.toString());
		return list;
	}
	
	public int insert(EmailBookVo vo) {
		int count = sqlsession.insert("emailbook.insert", vo);
		return count;
	}
	
	/*
	public List<EmailBookVo> getList() {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EmailBookVo> list = new ArrayList<EmailBookVo>();

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url, "webdb", "webdb");
			conn = oracleDataSource.getConnection();
			
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "SELECT NO, " + 
						   "       LAST_NAME, " + 
						   "       FIRST_NAME, " + 
						   "       EMAIL " + 
						   "FROM EMAILBOOK";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int no = rs.getInt("NO");
				String lastName = rs.getString("LAST_NAME");
				String firstName = rs.getString("FIRST_NAME");
				String email = rs.getString("email");

				EmailBookVo vo = new EmailBookVo(no, lastName, firstName, email);
				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
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
				System.out.println("error:" + e);
			}

		}

		return list;
	}
	*/
	
	/*
	public int insert(EmailBookVo vo) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url, "webdb", "webdb");
			conn = oracleDataSource.getConnection();
			
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "INSERT INTO EMAILBOOK " + 
						   "            (NO, " + 
						   "            LAST_NAME, " + 
						   "            FIRST_NAME, " + 
						   "            EMAIL) " + 
						   "VALUES (SEQ_EMAILBOOK_NO.NEXTVAL, " + 
						   "        ?, " + 
						   "        ?, " + 
						   "        ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getLastName());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getEmail());
			
			count = pstmt.executeUpdate();

			// 4.결과처리

			

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}

		return count;
	}
	*/
}
