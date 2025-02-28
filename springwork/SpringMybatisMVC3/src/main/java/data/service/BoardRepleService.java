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

	public void insertReple(BoardRepleDto dto) {
		boardRepleMapper.insertReple(dto);
	}
	
	public List<BoardRepleDto> getAllReples(int idx) {
		return boardRepleMapper.getAllReples(idx);
	}
	
	public int getRepleCount(int idx) {
		return boardRepleMapper.getRepleCount(idx);
	}
}
