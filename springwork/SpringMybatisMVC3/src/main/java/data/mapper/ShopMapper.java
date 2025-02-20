package data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import data.dto.ShopDto;

@Mapper
public interface ShopMapper {
	public int getTotalCount(); // 메서드명과 id 이름을 똑같게 해준다. - 자동 연결
	public void insertShop(ShopDto dto);
	public List<ShopDto> getAllSangpum();
	public ShopDto getOneSangpum(int num);
	public void updateShop(ShopDto dto);
	public void deleteShop(int num);
	public void updatePhoto(Map<String, Object> map);
}
