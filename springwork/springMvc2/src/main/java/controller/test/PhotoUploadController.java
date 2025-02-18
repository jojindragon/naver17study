package controller.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.FilenameChange;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PhotoUploadController {
	
	@GetMapping("/uploadform")
	public String upload() {
		return "upload/uploadform";
	}
	
	@PostMapping("/uploadprocess")
	public String uploadPhoto(
			Model model,
			HttpServletRequest request,
			@RequestParam String title,
			@RequestParam("upload") MultipartFile upload
			) {
		
		// 업로드할 프로젝트 내의 위치 지정(webapp/save)
		String uploadFolder = request.getSession()
				.getServletContext().getRealPath("/save");
		
		// 업로드 할 파일명
		// 원래 파일명으로 저장할 경우, 같은 이름 업로드 시 덮어써지는 문제
//		String uploadFile = upload.getOriginalFilename();
		
		// 클래스 함수화
		String uploadFile = FilenameChange.getDateChangeFileName(upload.getOriginalFilename());
				
		// 업로드
		try {
			upload.transferTo(new File(uploadFolder+"/"+uploadFile));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("title", title);
		model.addAttribute("photo", uploadFile);
		
		return "upload/uploadresult";
	}
	
	@GetMapping("/multiform")
	public String multi() {
		return "upload/uploadformmulti";
	}
	
	@PostMapping("/multiprocess")
	public String multiUpload(
			Model model,
			HttpServletRequest request,
			@RequestParam String title,
			@RequestParam("upload") List<MultipartFile> uploadList
			) {
		
		model.addAttribute("title", title);
		
		String uploadFolder = request.getSession()
				.getServletContext().getRealPath("/save");
		
		// 업로드 된 파일명을 저장할 리스트변수
		List<String> list = new Vector<>();
		
		// 여러 개의 파일들을 업로드(파일명 뒤에 날짜 붙이기)
		for(MultipartFile mf : uploadList) {
			// 업로드 할 파일명 구하기
//			String uploadFile = FilenameChange.getDateChangeFileName(mf.getOriginalFilename());
			String uploadFile = FilenameChange.getRandomChangeFileName(mf.getOriginalFilename());

			// 사진들 업로드
			try {
				mf.transferTo(new File(uploadFolder+"/"+uploadFile));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			// list 추가
			list.add(uploadFile);
		}
		
		// model에 list 저장
		model.addAttribute("list", list);
		
		return "upload/uploadresultmulti";
	}
	
	// ajax
	@GetMapping("/ajaxupload")
	public String ajaxForm() {
		return "upload/ajaxphotoupload";
	}
	
	// 사진 업로드 후 json 형태로 파일명 반환
	// ajax 함수로 호출되는 메서드
	@PostMapping("/oneupload")
	@ResponseBody
	public Map<String, String> photoUpload(HttpServletRequest request,
			@RequestParam("upload") MultipartFile upload) {
		
		// 업로드 할 경우
		String uploadPath = request.getSession().getServletContext().getRealPath("/save");
		String uploadFileName = FilenameChange.getDateChangeFileName(upload.getOriginalFilename());
		
		try {
			upload.transferTo(new File(uploadPath+"/"+uploadFileName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<>();
		map.put("photo", uploadFileName);
		
		return map;
	}
	
	@GetMapping("/multiajaxupload")
	public String multiForm() {
		return "upload/ajaxmultiuploadform";
	}
	
	@PostMapping("/multiupload")
	@ResponseBody
	public List<Map<String, String>> ajaxMultiUpload(
			HttpServletRequest request,
			@RequestParam("upload") List<MultipartFile> uploadList) {

		List<Map<String, String>> list = new Vector<>();
		
		String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
		
		// 여러 개의 파일들을 업로드(파일명 UUID)
		for(MultipartFile mf : uploadList) {
			// 업로드 할 파일명 구하기
			String uploadFile = FilenameChange.getRandomChangeFileName(mf.getOriginalFilename());

			// 사진들 업로드
			try {
				mf.transferTo(new File(uploadFolder+"/"+uploadFile));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			// list 추가
			Map<String, String> map = new HashMap<>();
			map.put("photo", uploadFile);
			list.add(map);
		}
		
		
		return list;
	}
	
}
