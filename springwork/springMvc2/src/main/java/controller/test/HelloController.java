package controller.test;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping("/")
/*	public ModelAndView hello1() { 방법1: 예전 반환 방식 - ModelAndView
		ModelAndView mview = new ModelAndView();
		mview.addObject("message", "오늘은 월요일"); // request 저장
		mview.setViewName("hello"); // 포워드 경로
		
		return mview;
	}*/
	public String hello1(Model model) {
		model.addAttribute("message", "오늘은 월요일");
		model.addAttribute("today", new Date());
		return "hello";
	}
}
