package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import data.dto.MemberDto;
import data.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberListController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/list")
	public String memberList(Model model) {
		List<MemberDto> list = memberService.getAllMembers();
		model.addAttribute("list", list);
//		model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/bitcamp-bucket-139");
		model.addAttribute("fronturl", "https://radbwaqf8739.edge.naverncp.com/DaFq6foQou");
		model.addAttribute("backurl", "?type=f&w=30&h=30&faceopt=true&ttype=jpg");
		return "member/memberlist";
	}
	
}
