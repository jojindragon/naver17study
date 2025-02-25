package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;

@Controller
@RequestMapping("/member")
public class MemberAddController {
	@Autowired
	MemberService memberService;
	
	// 버킷 이름: 각자 자기 것 사용
	private String bucketName = "bitcamp-bucket-139";
	
	@Autowired
	NcpObjectStorageService storageService;
	
	@GetMapping("/form")
	public String form() {
		return "member/memberform";
	}
	
	// 아이디 유효성 검사
	// 아이디가 존재하면 result에 fail, 존재하지 않으면 success 보내기
	@GetMapping("/idcheck")
	@ResponseBody
	public Map<String, String> idCheck(@RequestParam String myid) {
		Map<String, String> map = new HashMap<>();
		
		if(memberService.isMyidCheck(myid)) {
			map.put("result", "fail");
		} else {
			map.put("result", "success");
		}
		
		return map;
	}
	
	// 회원가입 - member 정보 넣기
	@PostMapping("/insert")
	public String insert(HttpServletRequest request,
			@ModelAttribute MemberDto dto,
			@RequestParam("upload") MultipartFile upload) {
		/* 사진 선택을 안 한 경우
		 * upload 파일명 확인 후 upload하지말고 mphoto에 "no" 저장
		 */
//		System.out.println("filename: "+upload.getOriginalFilename());
		
		if(upload.getOriginalFilename().equals("")) {
			dto.setMphoto("no");
		} else {
			/*
			 * // 업로드할 폴더명 String path =
			 * request.getSession().getServletContext().getRealPath("save"); // 업로드할 파일명
			 * String file =
			 * UUID.randomUUID()+"."+upload.getOriginalFilename().split("\\.")[1]; try {
			 * upload.transferTo(new File(path+"/"+file)); } catch (IllegalStateException |
			 * IOException e) { e.printStackTrace(); } dto.setMphoto(file);
			 */
			
			// 네이버 스토리지 사진 저장
			// 네이버 오브젝트 스토리지에 사진 업로드 후 업로드한 파일명 반환
			String uploadFilename = storageService.uploadFile(bucketName, "member", upload);
			dto.setMphoto(uploadFilename);
		}
		
		memberService.insertMember(dto);
		
		return "redirect:../"; // 일단 홈 이동
	}
	
}
