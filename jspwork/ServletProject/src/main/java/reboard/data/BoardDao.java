package reboard.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.db.ConnectionManager;

public class BoardDao {
	ConnectionManager connectionManager = ConnectionManager.getInstance();
	SqlSession session;
	String nameSpace = "reboard.data.BoardDao.";
	
	private SqlSession getSession() {
		session = connectionManager.openSession();
		return session;
	}
	
	// group 값을 위해 마지막 게시글 번호 구하기
	public int getMaxNum() {
		session = getSession();
		int n = session.selectOne(nameSpace+"getMaxNum");
		session.close();
		return n;
	}
	
	// 전체 갯수 구하기
	public int getTotalCount() {
		session = getSession();
		int n = session.selectOne(nameSpace+"totalCount");
		session.close();
		return n;
	}
	
	// 게시글 출력
	public List<BoardDto> getPagingList(int start, int perpage) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		session = getSession();
		List<BoardDto> list = session.selectList(nameSpace+"selectPagingList", map);
		session.close();
		return list;
	}
	
	// 글이 추가됨에 따라 restep 설정
	public void updateRestep(int regroup, int restep) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("regroup", regroup);
		map.put("restep", restep);
		
		session = getSession();
		session.update(nameSpace+"updateRestep", map);
		session.close();
	}
	
	// 게시글 추가
	public void insertBoard(BoardDto dto) {
		int num = dto.getNum();
		int regroup = dto.getRegroup();
		int restep = dto.getRestep();
		int relevel = dto.getRelevel();
		
		if(num == 0) { // 신규글(null -> 0으로 변경됨)
			regroup = this.getMaxNum()+1;
			restep = 0;
			relevel = 0;
		} else { // 답글의 경우
			// 같은 그룹 중 전달받은 restep보다 큰 데이터는 모두 +1
			this.updateRestep(regroup, restep);
			
			// 전달받은 레벨과 스텝 1 증가
			restep++;
			relevel++;
		}
		
		// 변경된 데이터들을 다시 dto로
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		session = getSession();
		session.insert(nameSpace+"insertBoard", dto);
		session.close();
	}
	
	// 조회수 갱신
	public void updateReadCount(int num) {
		session = getSession();
		session.update(nameSpace+"updateReadCount", num);
		session.close();
	}
	
	// 게시글 상세보기(조회)
	public BoardDto getData(int num) {
		session = getSession();
		// servlet에서 조회수 증가
		BoardDto dto = session.selectOne(nameSpace+"selectOneByNum", num);
		session.close();
		return dto;
	}
	
	public boolean isCheckPass(int num, String passwd) {
		boolean b;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		map.put("passwd", passwd);
		
		session = getSession();
		int n = session.selectOne(nameSpace+"checkPass", map);
		session.close();
		return n == 1?true:false; 
	}
	
	public void deleteBoard(int num) {
		session = getSession();
		session.delete(nameSpace+"deleteBoard", num);
		session.close();
	}
	
	public void updateBoard(BoardDto dto) {
		session = getSession();
		session.update(nameSpace+"updateBoard", dto);
		session.close();
	}
	
}
