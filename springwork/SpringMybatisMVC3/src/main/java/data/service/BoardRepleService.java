package data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.dto.BoardRepleDto;
import data.mapper.BoardRepleMapper;

@Service
public class BoardRepleService {
	@Autowired
	BoardRepleMapper boardRepleMapper;

	// 댓글 입력
	public void insertReple(BoardRepleDto dto) {
		boardRepleMapper.insertReple(dto);
	}
	
	// 댓글 출력
	public List<BoardRepleDto> getAllReples(int idx) {
		return boardRepleMapper.getAllReples(idx);
	}
	
	public int getRepleCount(int idx) {
		return boardRepleMapper.getRepleCount(idx);
	}
	
	// 댓글 삭제
	public void deleteReple(int num) {
		boardRepleMapper.deleteReple(num);
	}
	
	// 댓글 정보 얻기
	public BoardRepleDto getOneReple(int num) {
		return boardRepleMapper.getOneReple(num);
	}
	
	// 댓글 수정
	public void updateReple(BoardRepleDto dto) {
		boardRepleMapper.updateReple(dto);
	}
}
