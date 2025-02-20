package data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import data.dto.ShopDto;
import data.mapper.ShopMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor // 무조건 자동 주입 되어야하기에 NoArgs X
public class ShopService {
	ShopMapper shopMapper;
	
	public int getTotalCount() {
		return shopMapper.getTotalCount();
	}
	
	public void insertShop(ShopDto dto) {
		shopMapper.insertShop(dto);
	}
	
	public List<ShopDto> getAllSangpum() {
		return shopMapper.getAllSangpum();
	}
	
	public ShopDto getOneSangpum(int num) {
		return shopMapper.getOneSangpum(num);
	}
	
	public void updateShop(ShopDto dto) {
		shopMapper.updateShop(dto);
	}
	
	public void deleteShop(int num) {
		shopMapper.deleteShop(num);
	}
	
	public void updatePhoto(int num, String sphoto) {
		Map<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("sphoto", sphoto);
		shopMapper.updatePhoto(map);
	}
}
