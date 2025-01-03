package day0103db;

import java.sql.Connection; // sql 연결 관련 패키지
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1OracleConnect {
	// Build Path의 Configure Path로 driver 파일(jar) 적용
	static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";

	// DB 접근 - URL & ID, PWD 필요
	// @127.0.0.1 == localhost == 지금 PC
	// :Port 번호
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String username = "angel"; // user 명
	String pwd = "pw1234"; // user 비번

	public Ex1OracleConnect() {
		try {
			Class.forName(ORACLE_DRIVER); // String 이름의 클래스로 반환
			System.out.println("Oracle 드라이버 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle 드라이버 실패: " + e.getMessage());
		}
	}

	// DB 연결 성공 후 Connection을 반환
	public Connection getConnection() {
		Connection conn = null;
		try {
			// DB 연결
			conn = DriverManager.getConnection(url, username, pwd);
			System.out.println("Oracle 접속 성공!");

		} catch (SQLException e) {
			System.out.println("DB 연결 실패: " + e.getMessage());
		}
		return conn;
	}

	// DB에 있는 테이블 확인
	public void shopWriteData() {
		Connection conn = null;
		Statement stmt = null; // 기본 객체, 텍스트 SQL 호출
		ResultSet rs = null; // 쿼리에 대한 결과 반환
		String sql = "select * from shop";

		conn = this.getConnection();

		try {
			stmt = conn.createStatement();
			// select 문 - ResultSet이 반환되는 executeQuery만 가능
			rs = stmt.executeQuery(sql);

			// 데이터가 여러개 - 반복문으로 rs.next()가 true인 동안 반복
			System.out.println("상품코드\t상품명\t상품단가");
			System.out.println("=".repeat(25));
			while (rs.next()) {
				// column index보다 label로 가져오는 게 더 정확
				// 컬럼명말고 인덱스로 가져올 때 - index는 1부터
//				String code = rs.getString(1);
//				String sname = rs.getString(2);
//				int sprice = rs.getInt(3);
				String code = rs.getString("sangcode");
				String sname = rs.getString("sangname");
				int sprice = rs.getInt("sangprice");

				System.out.println(code + "\t" + sname + "\t" + sprice);

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
		// Oracle 데이터베이스 연결
		Ex1OracleConnect ex1 = new Ex1OracleConnect(); // 생성자 호출
		ex1.shopWriteData();
	}

}
