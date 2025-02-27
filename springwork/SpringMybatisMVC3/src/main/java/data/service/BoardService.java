package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.BoardDto;
import data.mapper.BoardMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {
	BoardMapper boardMapper;
	
	public int getTotalCount() {
		return boardMapper.getTotalCount();
	}
	
	public int getMaxIdx() {
		return boardMapper.getMaxIdx();
	}
	
	public void updateRestep(int regroup, int restep) {
		boardMapper.updateRestep(regroup, restep);
	}
	
	/* 새글과 답글에 따라 group, level, step 등의 로직 필요 */
	public void insertBoard(BoardDto dto) {
		int idx = dto.getIdx(); // null 인 경우 0으로 넘어옴
		int regroup = dto.getRegroup();
		int restep = dto.getRestep();
		int relevel = dto.getRelevel();
		
		if(idx == 0) {
			// 신규 글
			regroup = this.getMaxIdx()+1;
			relevel = 0;
			restep = 0;
		} else {
			// 답글
			// 같은 그룹 중 전달받은 restep 보다 큰 값: +1
			this.updateRestep(regroup, restep);
			// 전달받은 값보다 1 증가
			restep++;
			relevel++;
		}
		
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		// DB 삽입
		boardMapper.insertBoard(dto);
	}
	
	// 게시글 출력
	public List<BoardDto> getPagingList(int start, int perpage) {
		return boardMapper.getPagingList(start, perpage);
	}
	
	// 조회수 증가
	public void updateReadcount(int idx) {
		boardMapper.updateReadcount(idx);
	}
	
	// 게시글 상세보기 - idx로 찾기
	public BoardDto getSelectByIdx(int idx) {
		return boardMapper.getSelectByIdx(idx);
	}
	
	// 마이페이지: 쓴 글 목록 가져오기
	public List<BoardDto> getSelectByMyid(String myid) {
		return boardMapper.getSelectByMyid(myid);
	}
	
	// 게시글 수정: 제목&내용
	public void updateBoard(BoardDto dto) {
		boardMapper.updateBoard(dto);
	}
	
	// 게시글 삭제
	public void deleteBoard(int idx) {
		boardMapper.deleteBoard(idx);
	}
}
