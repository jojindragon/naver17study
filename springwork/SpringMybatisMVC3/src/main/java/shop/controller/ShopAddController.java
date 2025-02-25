package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dto.ShopDto;
import data.service.ShopService;
import naver.storage.NcpObjectStorageService;

@Controller
public class ShopAddController {
	@Autowired
	ShopService shopService;
	
	private String bucketName = "bitcamp-bucket-139";
	
	@Autowired
	NcpObjectStorageService storageService;
	
	@GetMapping("/shop/addform")
	public String addForm() {
		return "shop/addform";
	}
	
	@PostMapping("/shop/insert")
	public String insert(@ModelAttribute ShopDto dto,
			@RequestParam("upload") List<MultipartFile> uploadList) {
		// dto에 저장할 변수
		String sphoto="";
		
		for(MultipartFile mf : uploadList ) {
			// 스토리지에 파일 업로드
			String uploadFileName = storageService.uploadFile(bucketName, "shop", mf);
			// DB sphoto 작업
			sphoto += uploadFileName + ",";
		}
		
		// 마지막 콤마 제거 후 dto 넣기
		sphoto = sphoto.substring(0, sphoto.length()-1);
		dto.setSphoto(sphoto);
		
		shopService.insertShop(dto);
		
		// spring에서는 redirect: 붙이면 자동 인식
		return "redirect:./list";
	}
	
}
