package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.BoardRepleDto;

@Mapper
public interface BoardRepleMapper {
	public void insertReple(BoardRepleDto dto);
	public List<BoardRepleDto> getAllReples(int idx);
	public int getRepleCount(int idx);
	public void deleteReple(int num);
	public BoardRepleDto getOneReple(int num);
	public void updateReple(BoardRepleDto dto);
}
