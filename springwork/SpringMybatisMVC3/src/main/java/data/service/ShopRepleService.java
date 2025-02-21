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
	
	public String getPhoto(int idx)
	{
		return shopRepleMapper.getPhoto(idx);
	}
	
	public void updateLikes(int idx)
	{
		shopRepleMapper.updateLikes(idx);
	}
	public int getLikes(int idx)
	{
		return shopRepleMapper.getLikes(idx);
	}
}
