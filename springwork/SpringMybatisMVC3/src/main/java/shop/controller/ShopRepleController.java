package shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.ShopRepleDto;
import data.service.ShopRepleService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;

@RestController
public class ShopRepleController {
	@Autowired
	ShopRepleService shopRepleService;
	
	private String bucketName = "bitcamp-bucket-139";
	
	@Autowired
	NcpObjectStorageService storageService;
	
	@PostMapping("/shop/addreple")
	public void insertReple(HttpServletRequest request,
			@RequestParam int num,
			@RequestParam String message,
			@RequestParam("upload") MultipartFile upload) {
		// 스토리지 업로드
		String file = storageService.uploadFile(bucketName, "shop", upload);

		// dto 생성
		ShopRepleDto dto = new ShopRepleDto();
		dto.setNum(num);
		dto.setMessage(message);
		dto.setPhoto(file);
		
		// db insert
		shopRepleService.insertShopReple(dto);
	}
	
	@GetMapping("/shop/replelist")
	public List<ShopRepleDto> repleList(@RequestParam int num) {
		List<ShopRepleDto> list = null;
		list = shopRepleService.getRepleByNum(num);
		return list;
	}
	
	// 댓글 삭제
	@GetMapping("/shop/repledel")
	public void repleDelete(@RequestParam int idx) {
		// 삭제할 사진명
		String photo = shopRepleService.getPhoto(idx);
		// 사진 삭제
		storageService.deleteFile(bucketName, "shop", photo);
		shopRepleService.deleteShopReple(idx);
	}
	
	// 추천 수 증가
	@GetMapping("/shop/likes")
	public Map<String, Integer> getLikes(@RequestParam int idx) {
		// likes 1 증가
		shopRepleService.updateLikes(idx);
		// 최종 likes 받기
		int likes = shopRepleService.getLikes(idx);
		//Map 처리
		Map<String, Integer> map = new HashMap<>();
		map.put("likes", likes);
		return map;
	}
}
