package shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.ShopRepleDto;
import data.service.ShopRepleService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ShopRepleController {
	@Autowired
	ShopRepleService shopRepleService;
	
	@PostMapping("/shop/addreple")
	public void insertReple(HttpServletRequest request,
			@RequestParam int num,
			@RequestParam String message,
			@RequestParam("upload") MultipartFile upload) {
		// save의 실제 경로 구하기
		String path = request.getSession().getServletContext().getRealPath("/save");
		// 업로드할 파일명(랜덤문자열.확장자)
		String file = UUID.randomUUID()+"."+upload.getOriginalFilename().split("\\.")[1];
		// 사진 업로드
		try {
			upload.transferTo(new File(path+"/"+file));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
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
	@PostMapping("/shop/repledelete")
	public void deleteReple(HttpServletRequest request,
			@RequestParam int idx, @RequestParam String pname) {
		String path = request.getSession().getServletContext().getRealPath("/save");
		File file = new File(path+"/"+pname);
		if(file.exists()) {
			file.delete();
		}
		
		shopRepleService.deleteShopReple(idx);
	}
	
	// 추천 수 증가
	@PostMapping("/shop/pluslikes")
	public void plusRepleLikes(@RequestParam int idx) {
		shopRepleService.plusRepleLikes(idx);
	}
}
