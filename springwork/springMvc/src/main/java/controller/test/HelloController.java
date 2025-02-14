package controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.test.TestDto;

@Controller	//bean 객체를 자동 등록
// @RestController - json 자동 처리, 포워드 & 리다이렉트는 안 됨 => @ResponseBody 생략 가능
public class HelloController {
	// Controller - 모두 Web으로 나옴(JSON 형식)
	// Mapping 주소 할당 필요 - method 별로 가능
	
	// 기본 형식
	// @ResponseBody - json 형식으로 바로 브라우저 출력
//	@RequestMapping(value = "/", method = RequestMethod.GET) // 모든 스프링 버전에서 가능
//	@RequestMapping("/")	//method 방식 생략 - default: GET
	@GetMapping("/hello2") // 스프링 5부터 가능한 방식
	@ResponseBody 
	public TestDto hello() {
		TestDto dto = new TestDto();
		dto.setName("이영자");
		dto.setAddr("강남구");
		dto.setHp("010-2222-3333");
		System.out.println(dto); // toString() 메서드 이미 호출
		return dto;
	}
}
