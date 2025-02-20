package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.ShopRepleDto;
import data.mapper.ShopRepleMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShopRepleService {
	ShopRepleMapper shopRepleMapper;
	
	public void insertShopReple(ShopRepleDto dto) {
		shopRepleMapper.insertShopReple(dto);
	}
	
	public void deleteShopReple(int idx) {
		shopRepleMapper.deleteShopReple(idx);
	}
	
	public List<ShopRepleDto> getRepleByNum(int num) {
		return shopRepleMapper.getRepleByNum(num);
	}
	
	public void plusRepleLikes(int idx) {
		shopRepleMapper.plusRepleLikes(idx);
	}
}
