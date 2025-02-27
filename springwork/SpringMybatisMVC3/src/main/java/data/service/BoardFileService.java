package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.BoardFileDto;
import data.mapper.BoardFileMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardFileService {
	BoardFileMapper fileMapper;
	
	// 파일 사진 삽입
	public void insertBoardFile(BoardFileDto dto) {
		fileMapper.insertBoardFile(dto);
	}
	
	// 게시판 사진 획득
	public List<BoardFileDto> getFiles(int idx) {
		return fileMapper.getFiles(idx);
	}
	
	// 파일 삭제
	public void deleteFile(int num) {
		fileMapper.deleteFile(num);
	}
	
	public String getFileName(int num) {
		return fileMapper.getFileName(num);
	}
	
}
