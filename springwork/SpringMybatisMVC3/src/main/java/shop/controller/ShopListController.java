package shop.controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import data.dto.ShopDto;
import data.service.ShopService;

@Controller
public class ShopListController {
	
	@Autowired
	ShopService shopService;
	
	@GetMapping("/shop/list")
	public String shopList(Model model) {
		// 총 상품 갯수 모델에 저장 후 포워드
		int totalCount = shopService.getTotalCount();
		model.addAttribute("totalCount", totalCount);
		
		// 전체 상품 가져오기
		List<ShopDto> list = shopService.getAllSangpum();
		for(ShopDto dto:list) {
			String mainPhoto = dto.getSphoto().split(",")[0];
			dto.setMainPhoto(mainPhoto);
		}
		model.addAttribute("list", list);
		
		return "shop/shoplist";
	}
	
}
