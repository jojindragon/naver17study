package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex5MysqlInsertSelect {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username = "root";
	String pwd = "1234";

	public Ex5MysqlInsertSelect() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류: " + e.getMessage());
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			System.out.println("MySQL 접속 실패: " + e.getMessage());
		}

		return conn;
	}

	public void insertPerson(String name, String blood, int age, String hp) {
		Connection conn = null;
		Statement stmt = null;
		String sql = "insert into person (name, blood, age, hp, today) values ('" + name + "','" + blood.toUpperCase()
				+ "','" + age + "','" + hp + "',now())";
//		System.out.println(sql);

		conn = this.getConnection();
		try {
			stmt = conn.createStatement();
			// insert 문 실행
			stmt.execute(sql); // 반환이 필요 없기에 단순 실행
			System.out.println(name + " 정보를 DB에 추가");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}

	}

	public void writePerson() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from person order by num";

		conn = this.getConnection();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("\t\t** Person Table **\n");
			System.out.println("이름\t혈액형\t나이\t날짜\t\t핸드폰");
			System.out.println("=".repeat(60));
			while (rs.next()) {
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String age = rs.getString("age");
				String today = rs.getString("today").substring(0, 10);
				String hp = rs.getString("hp");

				System.out.println(name + "\t" + blood + "형\t" + age + "세\t" + today + "\t" + hp);
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

	// 이름 검색
	public void searchName(String name) {
		int cnt = 0; // 찾은 인원수를 얻을 변수
		/*
		 * 문제: name이 '영자'인 경우 영자를 포함하는 모든 데이터 출력
		 * 
		 * 없을 경우 '영자'가 포함된 회원은 없습니다.
		 */
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
//		String sql = "select * from person where name like '%" + name + "%' order by num"; // 방법1
		String sql = "select * from person where name like concat('%', '" + name + "','%') order by num"; // 방법2

		conn = this.getConnection();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				cnt++;
				System.out.println(cnt + "번째 회원: " + rs.getString("name"));
				System.out.println("혈액형: " + rs.getString("blood") + "형");
				System.out.println("나이: " + rs.getInt("age") + "세");
				System.out.println("핸드폰: " + rs.getString("hp"));
				System.out.println("-".repeat(15));
			}

			if (cnt == 0) {
				System.out.println("'" + name + "'이 포함된 회원은 없습니다.");
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

	// 데이터 삭제
	public void deletePerson(String name) {
		// name이 있을 경우 - 1명의 데이터가 삭제되었습니다.
		// 없을 경우 - "name"님은 존재하지 않습니다.
		// 중복 인원도 제거 - n명의 데이터가 삭제되었습니다.
		// 삭제된 갯수 반환 - int executeUpdate(String sql)
		// -> n명 삭제 (n 반환), 삭제 X (0 반환)
		Connection conn = null;
		Statement stmt = null;
		String sql = "delete from person where name like concat('%', '" + name + "', '%')";

		conn = this.getConnection();

		try {
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql);

			if (cnt == 0) {
				System.out.println("\"" + name + "\" 님은 존재하지 않습니다.");
			} else {
				System.out.println(cnt + "명의 데이터가 삭제되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Ex5MysqlInsertSelect ex5 = new Ex5MysqlInsertSelect();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. 데이터 추가 2. 전체출력 3. 이름검색 4. 멤버삭제 5. 종료");
			System.out.print("메뉴 선택: ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1: {
				System.out.println("*데이터 추가*");
				System.out.print("이름: ");
				String name = sc.nextLine();
				System.out.print("혈액형: ");
				String blood = sc.nextLine();
				System.out.print("나이: ");
				int age = Integer.parseInt(sc.nextLine());
				System.out.print("핸드폰: ");
				String hp = sc.nextLine();

				ex5.insertPerson(name, blood, age, hp);
				break;
			}

			case 2:
				ex5.writePerson();
				break;

			case 3: {
				System.out.print("검색할 이름 입력: ");
				String name = sc.nextLine();
				ex5.searchName(name);
				break;
			}

			case 4: {
				System.out.print("삭제할 이름 입력: ");
				String name = sc.nextLine();
				ex5.deletePerson(name);
				break;
			}

			default:
				System.out.println("* 프로그램 종료 *");
				System.exit(0);
			}
			System.out.println("-".repeat(15));
		}
	}

}
