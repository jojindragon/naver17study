package shop.data;

import java.util.List;

// ibatis - mybatis 전신, 업데이트 전 이름
import org.apache.ibatis.session.SqlSession;

import mybatis.db.ConnectionManager;

public class ShopDao {
	// 만들었던 것들
	ConnectionManager connectionManager = ConnectionManager.getInstance();
	
	SqlSession session;
	String namespace = "shop.data.ShopDao.";
	
	private SqlSession getSession() {
		session = connectionManager.openSession();
		return session;
	}
	
	// shop의 전체 갯수를 반환하는 메서드
	public int getTotalCount() {
		session = this.getSession();
		// selectOne - 반환타입: T -> 맞게 알아서 반환
		// namespace: 생략은 가능한데, 다른 곳에 동일 id 존재하면 오류 발생 - 즉, 오류방지
		int tot = session.selectOne(namespace+"totalCount");
		session.close();
		return tot;
	}
	
	// 전체 데이터 반환 메서드
	public List<ShopDto> getAllDatas() {
		session = getSession();
		List<ShopDto> list = session.selectList(namespace+"selectAllList");
		return list;
	}
	
	// 값 추가
	public void insertShop(ShopDto dto) {
		session = getSession();
		session.insert(namespace+"insertShop", dto);
		session.close();
	}
	
	// 상세보기 반환
	public ShopDto getSangpum(int num) {
		session = getSession();
		ShopDto dto = session.selectOne(namespace+"selectOneByNum", num);
		session.close();
		return dto;
	}
	
	public void updateSangpum(ShopDto dto) {
		session = getSession();
		session.update(namespace+"updateSangpum", dto);
		session.close();
	}
	
	public void deleteSangpum(int num) {
		session = getSession();
		session.delete(namespace+"deleteSangpum", num);
		session.close();
	}
	
}
