package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex4MysqlJoin {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username = "root";
	String pwd = "1234";

	public Ex4MysqlJoin() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL 드라이버 실패: " + e.getMessage());
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			System.out.println("DB 연결 실패: " + e.getMessage());
		}

		return conn;
	}

	public void joinDataWrite() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = """
				select
					name, blood, age, hp, kor, eng, sum
				from person p inner join stu s
				on p.num = s.num;
				""";

		conn = this.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("이름\t나이\t국어\t영어\t합계\t핸드폰");
			System.out.println("=".repeat(60));
			while (rs.next()) {
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int sum = rs.getInt("sum");
				String hp = rs.getString("hp");

				System.out.println(name + "\t" + blood + "\t" + kor + "\t" + eng + "\t" + sum + "\t" + hp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void personBloodGroup() {
		// 혈액형별 인원수 & 나이 평균 구하기
		String sql = """
				select
					blood, count(*) count, round(avg(age), 1) avgage
				from person
				group by blood order by count
				""";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = this.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("혈액형\t인원수\t평균 나이");
			System.out.println("=".repeat(25));
			while (rs.next()) {
				String blood = rs.getString("blood");
				int cnt = rs.getInt("count");
				float avgAge = rs.getFloat("avgage");

				System.out.println(blood + "\t" + cnt + "명\t" + avgAge + "세");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Ex4MysqlJoin ex4 = new Ex4MysqlJoin();
		ex4.joinDataWrite();
		System.out.println();
		ex4.personBloodGroup();
	}

}