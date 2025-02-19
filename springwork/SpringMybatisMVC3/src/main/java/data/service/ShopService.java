package data.service;

import java.util.List;

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
}
