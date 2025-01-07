package day0107db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class FoodModel {
	MysqlConnect c = new MysqlConnect();

	// 메뉴등록 - insert 메소드
	public void foodMenuInsert(String foodName, int foodPrice, String foodSize) {
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				insert into foodrest (foodname, foodprice, foodsize)
				values (?, ?, ?)
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, foodName);
			pstmt.setInt(2, foodPrice);
			pstmt.setString(3, foodSize);

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.dbClose(pstmt, conn);
		}

	}

	// 메뉴데이터
	public List<Vector<String>> getMenus() {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = """
				select * from foodrest
				order by num
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<String> menu = new Vector<String>();
				menu.add(rs.getString("num"));
				menu.add(rs.getString("foodname"));
				menu.add(rs.getString("foodprice"));
				menu.add(rs.getString("foodsize"));

				list.add(menu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.dbClose(rs, pstmt, conn);
		}

		return list;
	}

	// 예약데이터 - insert
	public void foodOrderInsert(FoodOrderDTO dto) {
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				insert into foodorder (num, ordername, ordercnt, bookingday)
				values (?, ?, ?, ?)
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getOrderName());
			pstmt.setInt(3, dto.getOrderCnt());
			pstmt.setString(4, dto.getBookingDay());

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.dbClose(pstmt, conn);
		}
	}

	// 예약내역
	public List<Vector<String>> getOrders() {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = """
				select
					idx, ordername, foodname, foodprice,
					foodsize, ordercnt, bookingday
				from foodrest fr, foodorder fo
				where fr.num = fo.num
				order by idx;
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<String> order = new Vector<String>();
				order.add(rs.getString("idx"));
				order.add(rs.getString("ordername"));
				order.add(rs.getString("foodname"));
				order.add(rs.getString("foodprice"));
				order.add(rs.getString("foodsize"));
				order.add(rs.getString("ordercnt"));
				order.add(rs.getString("bookingday"));

				list.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.dbClose(rs, pstmt, conn);
		}

		return list;
	}

	// 메뉴삭제 - 관련 예약 내역도 같이 삭제
	public void deleteFoodMenu(int num) {
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				delete from foodrest
				where num = ?
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.dbClose(pstmt, conn);
		}

	}

	// 등록메뉴를 예약한 건수 반환
	public int getOrderMenuCount(int num) {
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int cnt = 0;
		String sql = """
				select count(*) count from foodorder
				where num = ?
				""";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next())
				cnt = rs.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.dbClose(pstmt, conn);
		}

		return cnt;
	}

	// 예약취소
	public void deleteOrder(int idx) {
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				delete from foodorder
				where idx = ?
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.dbClose(pstmt, conn);
		}

	}

}
