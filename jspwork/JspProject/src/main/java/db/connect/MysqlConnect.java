package db.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnect {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username = "root";
	String pwd = "1234";
	
	//네이버 클라우드 Mysql 서버
	String url2 = "jdbc:mysql://[Public domain]:3306/[DB명]?serverTimezone=Asia/Seoul";
	String username2 = "User_ID";
	String pwd2 = "비밀번호";
	
	public MysqlConnect() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql Driver 오류: "+e.getMessage());
		}
		
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			System.out.println("Mysql 서버 접속 실패: "+e.getMessage());
		}
		return conn;
	}
	
	public Connection getNaverCloudConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url2, username2, pwd2);
		} catch (SQLException e) {
			System.out.println("NCP Mysql 서버 접속 실패: "+e.getMessage());
		}
		return conn;
	}
	
	public void dbClose(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt != null)
				pstmt.close();
			
			if(conn != null)
				conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null)
				rs.close();
			
			if(pstmt != null)
				pstmt.close();

			if(conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
