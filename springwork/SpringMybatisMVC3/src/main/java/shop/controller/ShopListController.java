package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import data.dto.ShopDto;
import data.service.ShopRepleService;
import data.service.ShopService;

@Controller
public class ShopListController {
	@Autowired
	ShopService shopService;
	
	@Autowired
	ShopRepleService shopRepleService;
	
	@GetMapping("/shop/list")
	public String shopList(Model model) {
		// 총 상품 갯수
		int totalCount = shopService.getTotalCount();
		
		// 전체 상품 가져오기
		List<ShopDto> list = shopService.getAllSangpum();
		for(ShopDto dto:list) {
			String mainPhoto = dto.getSphoto().split(",")[0];
			dto.setMainPhoto(mainPhoto);
			
			// 댓글 수 저장
			int replecount = shopRepleService.getRepleByNum(dto.getNum()).size();
			dto.setReplecnt(replecount);
		}
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("fronturl", "https://radbwaqf8739.edge.naverncp.com/DaFq6foQou/shop");
		model.addAttribute("backurl", "?type=f&w=100&h=120&faceopt=true&ttype=jpg");
		
		return "shop/shoplist";
	}
	
}
