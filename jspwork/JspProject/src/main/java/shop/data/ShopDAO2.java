package shop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class ShopDAO2 {
	MysqlConnect db = new MysqlConnect();
	
	public void insertShop(ShopDTO2 dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = """
				insert into shop
				(sangpum,scolor,scnt,sprice,sphoto,ipgoday,writeday)
				values(?,?,?,?,?,?,now())
				""";
		
		conn = db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSangpum());
			pstmt.setString(2, dto.getScolor());
			pstmt.setInt(3, dto.getScnt());
			pstmt.setInt(4, dto.getSprice());
			pstmt.setString(5, dto.getSphoto());
			pstmt.setString(6, dto.getIpgoday());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteShop(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from shop where num=?";				
		
		conn = db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void updateShop(ShopDTO2 dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = """
				update shop set
				sangpum=?, scolor=?, sprice=?,
				sphoto=?, scnt=?, ipgoday=?
				where num=?
				""";
		
		conn = db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSangpum());			
			pstmt.setString(2, dto.getScolor());
			pstmt.setInt(3, dto.getSprice());
			pstmt.setString(4, dto.getSphoto());
			pstmt.setInt(5, dto.getScnt());
			pstmt.setString(6, dto.getIpgoday());
			pstmt.setInt(7, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// order: 1. 등록순, 2.높은 가격순, 3.낮은 가격순, 4.상품명순
	public List<ShopDTO2> getAllSangpums(int order) {
		List<ShopDTO2> list = new Vector<ShopDTO2>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="";
		if(order == 1)
			sql = "select * from shop order by num";
		else if(order == 2)
			sql = "select * from shop order by sprice desc";
		else if(order == 3)
			sql = "select * from shop order by sprice asc";
		else if(order == 4)
			sql = "select * from shop order by sangpum asc";
		
		
		conn = db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ShopDTO2 dto = new ShopDTO2();
				dto.setNum(rs.getInt("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setScolor(rs.getString("scolor"));
				dto.setScnt(rs.getInt("scnt"));
				dto.setSprice(rs.getInt("sprice"));
				dto.setSphoto(rs.getString("sphoto"));
				dto.setIpgoday(rs.getString("ipgoday"));
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
	
	public ShopDTO2 getSangpum(int num) {
		ShopDTO2 dto = new ShopDTO2();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from shop where num=?";
		
		conn = db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setScolor(rs.getString("scolor"));
				dto.setScnt(rs.getInt("scnt"));
				dto.setSprice(rs.getInt("sprice"));
				dto.setSphoto(rs.getString("sphoto"));
				dto.setIpgoday(rs.getString("ipgoday"));
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
