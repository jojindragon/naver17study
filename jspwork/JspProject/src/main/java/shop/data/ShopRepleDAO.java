package shop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class ShopRepleDAO {
	MysqlConnect db = new MysqlConnect();
	
	public void insertShop(int num, ShopRepleDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = """
				insert into shopreple
				(num, star, message, writeday)
				values(?,?,?,now())
				""";
		
		conn = db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, dto.getStar());
			pstmt.setString(3, dto.getMessage());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteShop(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from shopreple where idx=?";				
		
		conn = db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void updateShop(ShopRepleDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = """
				update shop set star=?, message=?
				where idx=?
				""";
		
		conn = db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getStar());
			pstmt.setString(2, dto.getMessage());
			pstmt.setInt(3, dto.getIdx());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 해당 상품(num)의 리뷰 목록 가져오기
	public List<ShopRepleDTO> getAllReple(int num) {
		List<ShopRepleDTO> list = new Vector<ShopRepleDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="""
				select * from shopreple
				where num=?
				""";
		
		
		conn = db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ShopRepleDTO dto = new ShopRepleDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setNum(rs.getInt("num"));
				dto.setStar(rs.getInt("star"));
				dto.setMessage(rs.getString("message"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public ShopRepleDTO getSangpum(int idx) {
		ShopRepleDTO dto = new ShopRepleDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from shopreple where idx=?";
		
		conn = db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setIdx(rs.getInt("idx"));
				dto.setNum(rs.getInt("num"));
				dto.setStar(rs.getInt("star"));
				dto.setMessage(rs.getString("message"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
}
