package day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.connect.MysqlConnect;

public class Ex1shopMysql {
	MysqlConnect mysqlConnect = new MysqlConnect();

	// shop 에 상품 추가
	public void insertShop(String sangpum, int su, int danga) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = """
				insert into shop (sangpum, su, danga, ipgoday)
				values (?, ?, ?, now())
				""";
		// db 연결
		conn = mysqlConnect.getConnection();

		try {
			pstmt = conn.prepareStatement(sql); // sql문 검사
			// 바인딩 - ? 수만큼 데이터를 넣기, 순서대로&타입별로
			pstmt.setString(1, sangpum);
			pstmt.setInt(2, su);
			pstmt.setInt(3, danga);

			// 바인딩 이후 실행, SQL 보내지말고 실행만
			pstmt.execute();
			System.out.println("상품 추가");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}

	}

	// 전체 shop 데이터 출력
	public void writeShop() {
		System.out.println("전체 상품 출력");
		System.out.println("Index\t상품명\t수량\t단가\t총금액\t입고일");
		System.out.println("=".repeat(60));

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from shop order by idx";

		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩 할 게 없으므로 바로 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int su = rs.getInt("su");
				int dan = rs.getInt("danga");
				int total = su * dan;

				System.out.println(rs.getInt("idx") + "\t" + rs.getString("sangpum") + "\t" + su + "\t" + dan + "\t"
						+ total + "\t" + rs.getString("ipgoday").substring(0, 16));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}

	}

	// 상품 삭제
	public void deleteShop(String sangpum) {
		System.out.println("[" + sangpum + "] 상품 삭제");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = """
				delete from shop
				where sangpum like ?
				""";

		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + sangpum + "%");

			int cnt = pstmt.executeUpdate();

			if (cnt == 0) {
				System.out.println("[" + sangpum + "] 관련 제품은 없습니다.");
			} else {
				System.out.println(cnt + "개의 상품이 제거되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}

	}

	// 상품 조회
	public void searchSangpum(String sangpum) {
		System.out.println("[" + sangpum + "] 상품 조회");
		System.out.println("Index\t상품명\t수량\t단가\t총금액\t입고일");
		System.out.println("=".repeat(60));

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = """
				select * from shop
				where sangpum like ?
				order by idx
				""";

		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + sangpum + "%");
			rs = pstmt.executeQuery();

			int cnt = 0;
			while (rs.next()) {
				cnt++;
				int su = rs.getInt("su");
				int dan = rs.getInt("danga");
				int total = su * dan;

				System.out.println(rs.getInt("idx") + "\t" + rs.getString("sangpum") + "\t" + su + "\t" + dan + "\t"
						+ total + "\t" + rs.getString("ipgoday").substring(0, 16));
			}

			if (cnt == 0)
				System.out.println("[" + sangpum + "] 관련 제품이 없습니다.");
			else
				System.out.println("[" + sangpum + "] 관련 제품이 총 " + cnt + "개 조회");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}
	}

	// 상품 수정
	public void updateShop(int idx, int su, int danga) {
		// idx에 해당하는 su, danga 수정
		// executeUpdate로 int 값 반환
		// 0 - 해당상품이 없습니다.
		// else - 해당상품 정보를 수정했습니다.
		System.out.println(idx + "번 상품 정보 갱신");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = """
				update shop set su = ?, danga = ?
				where idx = ?
				""";

		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, su);
			pstmt.setInt(2, danga);
			pstmt.setInt(3, idx);

			int cnt = pstmt.executeUpdate();

			if (cnt == 0)
				System.out.println("해당 상품이 없습니다.");
			else
				System.out.println("해당 상품 정보를 수정했습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}

	}

	public static void main(String[] args) {
		Ex1shopMysql ex = new Ex1shopMysql();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\t** 상품관리 메뉴 **\n");
			System.out.println("1.상품추가 2.전체출력 3.상품조회 4.상품삭제 5.상품수정 6.종료");
			System.out.print("번호 선택(1~6): ");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1 -> {
				System.out.print("상품명 입력: ");
				String sang = sc.nextLine();
				System.out.print("수량: ");
				int su = Integer.parseInt(sc.nextLine());
				System.out.print("단가: ");
				int dan = Integer.parseInt(sc.nextLine());

				ex.insertShop(sang, su, dan);
			}
			case 2 -> {
				ex.writeShop();
			}
			case 3 -> {
				System.out.print("검색할 상품: ");
				String sang = sc.nextLine();
				ex.searchSangpum(sang);
			}
			case 4 -> {
				System.out.print("삭제할 상품명: ");
				String sang = sc.nextLine();
				ex.deleteShop(sang);
			}
			case 5 -> {
				System.out.print("갱신할 상품 인덱스: ");
				int idx = Integer.parseInt(sc.nextLine());
				System.out.print("수량: ");
				int su = Integer.parseInt(sc.nextLine());
				System.out.print("단가: ");
				int dan = Integer.parseInt(sc.nextLine());

				ex.updateShop(idx, su, dan);
			}
			default -> {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			}
		}

	}

}
