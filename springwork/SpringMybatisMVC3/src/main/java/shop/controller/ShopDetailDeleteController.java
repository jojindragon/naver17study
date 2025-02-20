package shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.ShopDto;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShopDetailDeleteController {
	
	@Autowired
	ShopService shopService;
	
	@GetMapping("/shop/detail")
	public String detail(Model model, @RequestParam int num) {
		ShopDto dto = shopService.getOneSangpum(num);
		String mainPhoto = dto.getSphoto().split(",")[0];
		dto.setMainPhoto(mainPhoto);
		
		model.addAttribute("dto", dto);
		return "shop/detail";
	}
	
	@GetMapping("/shop/delete")
	public String delete(HttpServletRequest request, @RequestParam int num) {
		// 배포된 프로젝트의 save 위치 구하기
		String path = request.getSession().getServletContext().getRealPath("/save");
		
		// 삭제 전 사진명 획득
		String photos = shopService.getOneSangpum(num).getSphoto();
		String[] photo = photos.split(",");
		
		// 실제 경로에서 파일 찾아 삭제
		for(String f:photo) {
			File file = new File(path+"/"+f);
			if(file.exists()) {
				file.delete();
			}
		}
		
		// DB 삭제
		shopService.deleteShop(num);
		return "redirect:./list";
	}
	
	@GetMapping("/shop/photos")
	public String shopPhotos(@RequestParam int num, Model model) {
		String sphoto = shopService.getOneSangpum(num).getSphoto();
		model.addAttribute("num", num);
		model.addAttribute("sphoto", sphoto);
		return "shop/photos";
	}
	
	@GetMapping("/shop/delphoto")
	@ResponseBody
	public void deletePhoto(@RequestParam int num, @RequestParam String pname, HttpServletRequest request) {
		// num에 해당하는 sphoto를 db에서 획득
		String sphoto = shopService.getOneSangpum(num).getSphoto();
		
		String path = request.getSession().getServletContext().getRealPath("/save");
		File file = new File(path+"/"+pname);
		if(file.exists()) {
			file.delete();
		}
		
		// sphoto에서 pname 부분을 삭제, 중간일 경우 뒤에 컴마도 삭제
		String changePhoto = "";
		if(sphoto.endsWith(pname)) {
			changePhoto=sphoto.replace(pname, "");
		} else {
			changePhoto=sphoto.replace(pname+",", "");
		}
		
		// 변경된 changePhoto를 updatePhoto로 보낸다
		shopService.updatePhoto(num, changePhoto);
	}
	
	@PostMapping("/shop/addphoto")
	@ResponseBody
	public void addPhoto(@RequestParam int num,
			@RequestParam("upload") List<MultipartFile> uploadList,
			HttpServletRequest request) {
		
		// upload 경로
		String path = request.getSession().getServletContext().getRealPath("/save");
		// 새로 업로드할 파일명
		String photos = "";
		for(MultipartFile mf:uploadList) {
			String uploadFile = UUID.randomUUID()+"."+mf.getOriginalFilename().split("\\.")[1];
			photos+=uploadFile+",";
			try {
				mf.transferTo(new File(path+"/"+uploadFile));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		photos = photos.substring(0, photos.length()-1);
		String sphoto = shopService.getOneSangpum(num).getSphoto();
		
		// sphoto가 값이 없을 경우 photos 대입, 이미 있는 경우 콤마 추가후 photos 추가
		if(sphoto.length()==0) {
			sphoto = photos;
		} else {
			sphoto = sphoto+","+photos;
		}
		
		// 수정
		shopService.updatePhoto(num, sphoto);
	}
	
}
