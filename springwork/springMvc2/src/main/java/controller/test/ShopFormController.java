package controller.test;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.ShopDto;

@Controller
public class ShopFormController {

	@GetMapping("/form1")
	public String form1() {

		return "shop/form1";
	}

	@GetMapping("/form2")
	public String form2() {
		return "shop/form2";
	}

	@GetMapping("/form3")
	public String form3() {
		return "shop/form3";
	}

	/* 결과 출력 부분 */
	@GetMapping("/process1")
	public String list1(Model model,
			// 방법1
//			@RequestParam("myid") String myid, @RequestParam("mypass") String mypass
			
			// 방법2: 폼 태그의 name 값과 변수명이 같을 경우 name 값 생략 가능
//			@RequestParam String myid, @RequestParam String mypass
			
			// 방법3: 이름이 같을 경우 - @RequestParam 도 생략 가능(권장 X - error 가능성)
			String myid, String mypass,
			
			// 특정 값이 넘어올 때도 있고, 안 넘어올때도 있는 경우
			// 아예 pageNum이라는 폼 태그 자체가 없을 경우(null 값)
			// => default 값 지정 가능
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum
			)
	{
		String result = "";
		if (mypass.equals("12345")) {
			result = myid + "님이 로그인";
		} else {
			result = "Invalid Password";
		}
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "shop/list1";
	}
	
	@PostMapping("/process2")
//	public String list2(@ModelAttribute ShopDto dto) {
	public String list2(@ModelAttribute("dto") ShopDto dto) {
		// dto 통째로 읽어서 모델에 저장
		// 기본: 저장 시 타입에서 첫글자가 소문자 형태 - shopDto
		return "shop/list2";
	}
	
	@PostMapping("/process3")
	public String list3(Model model,
			@RequestParam Map<String, String> map) {
		// 폼태그의 name이 key 값, 입력값이 value로 넘어온다.
		model.addAttribute("name", map.get("name"));
		model.addAttribute("age", map.get("age"));
		model.addAttribute("addr", map.get("addr"));
		model.addAttribute("gender", map.get("gender"));
		
		return "shop/list3";
	}
}
