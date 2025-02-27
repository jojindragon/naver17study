package member.controller;

import java.util.List;
import java.util.Vector;

/*import java.io.File;
import java.io.IOException;
import java.util.UUID;*/

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.dto.MemberDto;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import naver.storage.NcpObjectStorageService;
//import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
//@AllArgsConstructor // 모든 멤버변수 자동주입 
// @NonNull 또는 final을 붙인 멤버변수만 자동주입
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberDelUpdateController {
//	@Autowired
	final MemberService memberService;
	
	private String bucketName = "bitcamp-bucket-139";
	
//	@Autowired
	final NcpObjectStorageService storageService;
	final BoardService boardService;
	final BoardFileService fileService;

	@GetMapping("/delete")
	public String deleteMember(@RequestParam int num) {
		memberService.deleteMember(num);
		return "redirect:./list";
	}
	
	@GetMapping("/mypagedel")
	@ResponseBody
	public void mypageDelete(@RequestParam int num,
			HttpSession session, HttpServletRequest request) {
		/*
		 * String path = request.getSession().getServletContext().getRealPath("/save");
		 * String file = memberService.getSelectByNum(num).getMphoto(); File f = new
		 * File(path+"/"+file); if(f.exists()) { f.delete(); }
		 */
		
		// 파일 명 얻고 삭제
		String file = memberService.getSelectByNum(num).getMphoto();
		storageService.deleteFile(bucketName, "member", file);
		
		memberService.deleteMember(num);

		// 모든 세션 삭제
		session.removeAttribute("loginstatus");
		session.removeAttribute("loginid");
		session.removeAttribute("loginphoto");
	}
	
	@GetMapping("/checkdel")
	@ResponseBody
	public void checkDeleteMember(@RequestParam String nums) {
		// 삭제할 num들
		String[] num = nums.split(",");
		for(String str:num) {
			int n = Integer.parseInt(str);
			// 파일명 각각 얻기
			String file = memberService.getSelectByNum(n).getMphoto();
			// 삭제
			storageService.deleteFile(bucketName, "member", file);
			
			memberService.deleteMember(n);
		}
	}
	
	@GetMapping("/mypage")
	public String goMypage(HttpSession session, Model model) {
		// 세션에서 아이디 획득
		String myid = (String) session.getAttribute("loginid");
		// 아이디에 해당하는 dto 획득
		MemberDto dto = memberService.getSelectByMyid(myid);
		model.addAttribute("dto", dto);
		// 네이버 스토리지 주소
		model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/bitcamp-bucket-139");
		
		//쓴 게시글 가져오기
		List<BoardDto> list = boardService.getSelectByMyid(myid);
		for(BoardDto bdto:list) {
			// 각 게시글 파일 갯수 저장
			int cnt = fileService.getFiles(bdto.getIdx()).size();
			bdto.setPhotoCount(cnt);
		}
		model.addAttribute("list", list);
		
		return "member/mypage";
	}
	
	@PostMapping("/changephoto")
	@ResponseBody
	public void changePhoto(HttpServletRequest request,
			HttpSession session,
			@RequestParam int num,
			@RequestParam MultipartFile upload) {
		/*
		 * String path = request.getSession().getServletContext().getRealPath("/save");
		 * String file = UUID.randomUUID() + "." +
		 * upload.getOriginalFilename().split("\\.")[1];
		 * 
		 * String oldFile = memberService.getSelectByNum(num).getMphoto(); File old =
		 * new File(path+"/"+oldFile); if(old.exists()) { old.delete(); }
		 * 
		 * try { upload.transferTo(new File(path+"/"+file));
		 * session.setAttribute("loginphoto", file);
		 * 
		 * memberService.changePhoto(file, num); } catch (IllegalStateException |
		 * IOException e) { e.printStackTrace(); }
		 */
		
		// 기존 파일명 삭제
		String oldFile = memberService.getSelectByNum(num).getMphoto();
		storageService.deleteFile(bucketName, "member", oldFile);
		// 새로운 파일 업로드
		String uploadFile = storageService.uploadFile(bucketName, "member", upload);
		// db 수정
		memberService.changePhoto(uploadFile, num);
		// 세션 변경
		session.setAttribute("loginphoto", uploadFile);
	}
	
	@PostMapping("/update")
	@ResponseBody
	public void update(@ModelAttribute MemberDto dto) {
		System.out.println(dto.getNum());
		memberService.updateMember(dto);
	}
	
}
