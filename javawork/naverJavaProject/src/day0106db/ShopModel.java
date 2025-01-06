package day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

// DB 처리를 위한 클래스
public class ShopModel {
	MysqlConnect connect = new MysqlConnect();

	// 전체 데이터 반환
	public List<Vector<String>> getAlldatas() {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from shop order by idx desc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("idx"));
				data.add(rs.getString("sangpum"));
				data.add(rs.getString("su"));
				data.add(rs.getString("danga"));

				int tot = rs.getInt("su") * rs.getInt("danga");
				data.add(String.valueOf(tot));
				data.add(rs.getString("ipgoday").substring(0, 10));

				list.add(data);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.dbClose(rs, pstmt, conn);
		}

		return list;
	}

	// insert
	public void insertShop(ShopDto dto) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				insert into shop (sangpum, su, danga, ipgoday)
				values (?, ?, ?, now())
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSangpum());
			pstmt.setInt(2, dto.getSu());
			pstmt.setInt(3, dto.getDanga());

			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.dbClose(pstmt, conn);
		}
	}

	// delete
	public void deleteShop(int idx) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				delete from shop where idx = ?
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);

			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.dbClose(pstmt, conn);
		}

	}

	// update
	public void updateShop(int idx, String sangpum, int su, int danga) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				update shop set sangpum = ?, su = ?, danga = ?
				where idx = ?;
				""";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sangpum);
			pstmt.setInt(2, su);
			pstmt.setInt(3, danga);
			pstmt.setInt(4, idx);

			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.dbClose(pstmt, conn);
		}

	}

	// search
	public List<Vector<String>> getSearchData(String searchWord) {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = """
				select * from shop
				where sangpum like ?
				order by idx desc
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchWord + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("idx"));
				data.add(rs.getString("sangpum"));
				data.add(rs.getString("su"));
				data.add(rs.getString("danga"));

				int tot = rs.getInt("su") * rs.getInt("danga");
				data.add(String.valueOf(tot));
				data.add(rs.getString("ipgoday").substring(0, 10));

				list.add(data);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.dbClose(rs, pstmt, conn);
		}

		return list;
	}

}
