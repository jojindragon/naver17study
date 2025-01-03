package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3OracleJoin {
	static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String username = "angel";
	String pwd = "pw1234";

	public Ex3OracleJoin() {
		try {
			Class.forName(ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle 드라이버 실패: " + e.getMessage());
		}
	}

	// DB 연결 성공 후 Connection을 반환
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			System.out.println("DB 연결 실패: " + e.getMessage());
		}
		return conn;
	}

	// DB에 있는 테이블 확인
	public void joinDataWrite() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = """
				select
					s.sangcode, sangname, sangprice, cntnum,
					to_char(cartday, 'yyyy-mm-dd') cartday
				from shop s, cart c
				where s.sangcode = c.sangcode
				""";

		conn = this.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("상품코드\t상품명\t상품단가\t카트수량\t담은날짜");
			System.out.println("=".repeat(60));
			while (rs.next()) {
				String code = rs.getString("sangcode");
				String sname = rs.getString("sangname");
				int price = rs.getInt("sangprice");
				int cntnum = rs.getInt("cntnum");
				String cday = rs.getString("cartday");

				System.out.println(code + "\t" + sname + "\t" + price + "원\t" + cntnum + "개\t" + cday);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// Oracle 데이터베이스 연결
		Ex3OracleJoin ex3 = new Ex3OracleJoin(); // 생성자 호출
		ex3.joinDataWrite();
	}

}
