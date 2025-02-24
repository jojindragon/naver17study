package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/member")
public class MemberDelUpdateController {
	MemberService memberService;
	
	@GetMapping("/delete")
	public String deleteMember(@RequestParam int num) {
		memberService.deleteMember(num);
		return "redirect:./list";
	}
	
	@GetMapping("/mypagedel")
	@ResponseBody
	public void mypageDelete(@RequestParam int num,
			HttpSession session, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/save");
		String file = memberService.getSelectByNum(num).getMphoto();
		File f = new File(path+"/"+file);
		if(f.exists()) {
			f.delete();
		}
		
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
		return "member/mypage";
	}
	
	@PostMapping("/changephoto")
	@ResponseBody
	public void changePhoto(HttpServletRequest request,
			HttpSession session,
			@RequestParam int num,
			@RequestParam MultipartFile upload) {
		String path = request.getSession().getServletContext().getRealPath("/save");
		String file = UUID.randomUUID() + "." + upload.getOriginalFilename().split("\\.")[1];

		String oldFile = memberService.getSelectByNum(num).getMphoto();
		File old = new File(path+"/"+oldFile);
		if(old.exists()) {
			old.delete();
		}
		
		try {
			upload.transferTo(new File(path+"/"+file));
			session.setAttribute("loginphoto", file);
			
			memberService.changePhoto(file, num);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@PostMapping("/update")
	@ResponseBody
	public void updateMember(@ModelAttribute MemberDto dto) {
		memberService.updateMember(dto);
	}
	
}
