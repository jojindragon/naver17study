package shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dto.ShopDto;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShopAddController {
	
	@Autowired
	ShopService shopService;
	
	@GetMapping("/shop/addform")
	public String addForm() {
		return "shop/addform";
	}
	
	@PostMapping("/shop/insert")
	public String insert(HttpServletRequest request,
			@ModelAttribute ShopDto dto,
			@RequestParam("upload") List<MultipartFile> uploadList) {
		// 업로드할 save 경로 구하기
		String savePath = request.getSession().getServletContext().getRealPath("/save");

		List<MultipartFile> list = new Vector<>();
		
		// dto에 저장할 변수
		String sphoto="";
		
		for(MultipartFile mf : uploadList ) {
			// 파일명 변경
			String extName = mf.getOriginalFilename().split("\\.")[1];
			String uploadFileName = UUID.randomUUID() + "." + extName;
			
			sphoto += uploadFileName + ",";
			
			try {
				mf.transferTo(new File(savePath+"/"+uploadFileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
	
		}
		
		// 마지막 콤마 제거 후 dto 넣기
		sphoto = sphoto.substring(0, sphoto.length()-1);
		dto.setSphoto(sphoto);
		
		shopService.insertShop(dto);
		
		// spring에서는 redirect: 붙이면 자동 인식
		return "redirect:./list";
	}
	
}
