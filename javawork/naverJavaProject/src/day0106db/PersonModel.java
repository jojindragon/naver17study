package day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class PersonModel {
	MysqlConnect c = new MysqlConnect();

	public List<Vector<String>> getAllDatas() {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = """
				select * from person
				order by num
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("age"));
				data.add(rs.getString("blood"));
				data.add(rs.getString("hp"));

				list.add(data);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.dbClose(pstmt, conn);
		}

		return list;

	}

	public void insertP(PersonDTO dto) {
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				insert into person (name, age, blood, hp, today)
				values (?, ?, ?, ?, now())
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getBlood());
			pstmt.setString(4, dto.getHp());

			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.dbClose(pstmt, conn);
		}
	}

	public void deleteP(int idx) {
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				delete from person
				where num = ?
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

	public void updateP(int idx, String name, int age, String blood, String hp) {
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		String sql = """
				update person set
					name = ?, age = ?, blood = ?, hp = ?
				where num = ?
				""";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, blood);
			pstmt.setString(4, hp);
			pstmt.setInt(5, idx);

			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.dbClose(pstmt, conn);
		}
	}

	public List<Vector<String>> searchP(String word) {
		List<Vector<String>> s_list = new Vector<Vector<String>>();
		Connection conn = c.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = """
				select * from person
				where name like ?
				order by num
				""";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + word + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("age"));
				data.add(rs.getString("blood"));
				data.add(rs.getString("hp"));

				s_list.add(data);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.dbClose(pstmt, conn);
		}

		return s_list;

	}

}
