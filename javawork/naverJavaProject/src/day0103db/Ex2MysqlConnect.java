package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2MysqlConnect {
	// Build Path의 Configure Path로 driver 파일(jar) 적용
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

	// DB 접근 - URL & ID, PWD 필요
	String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username = "root"; // user 명
	String pwd = "1234"; // user 비번

	public Ex2MysqlConnect() {
		try {
			Class.forName(MYSQL_DRIVER); // 실제 클래스 타입으로 변환
			System.out.println("MySQL 드라이버 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL 드라이버 실패: " + e.getMessage());
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, pwd);
			System.out.println("MySQL 접속 성공!");

		} catch (SQLException e) {
			System.out.println("DB 연결 실패: " + e.getMessage());
		}

		return conn;
	}

	public void personWriteData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// Java 17 버전부터 되는 멀티 라인 문자열
		String sql = """
				select name, age, blood, hp,
				date_format(today, \"%Y-%m-%d %H:%i\") today
				from person
				""";

		conn = this.getConnection();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("이름\t나이\t혈액형\t핸드폰\t\t날짜");
			System.out.println("=".repeat(60));
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String blood = rs.getString("blood");
				String hp = rs.getString("hp");
				String today = rs.getString("today");

				System.out.println(name + "\t" + age + "세\t" + blood + "형\t" + hp + "\t" + today);
			}

		} catch (SQLException e) {
			System.out.println("SQL문 오류: " + e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Ex2MysqlConnect ex2 = new Ex2MysqlConnect();
		ex2.personWriteData();
	}

}
