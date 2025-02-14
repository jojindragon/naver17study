package bitcamp.study;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//RestController - 포워드가 안 되므로 Controller 사용
@Controller
public class OneController {
	
	// 같은 타입의 bean을 찾아서 자동으로 주입(DI)
	@Autowired
	MyCar mycar; //bean 등록이 되었기에 new가 없어도 null 값이 안 됨
		
	@GetMapping("/")
	public ModelAndView show() {
		ModelAndView mview = new ModelAndView(); // request 저장 - 방법 1
		// Model에 데이터를 저장(서블릿에서 request에 저장하는 것과 같음)
		mview.addObject("today", new Date());
		mview.addObject("message", "오늘은 즐거운 금요일!!!");

		// 포워드 - 원래는 경로 다 써야함
		mview.setViewName("result1"); // properties에서 설정한 viewresolver에 의해서 포워드
		return mview;
	}
	
	// 매핑 주소가 2가지 이상일 경우 {} 안에 넣기
	@GetMapping({"/board/list", "/board/list.do"})
	public String list1(Model model) { //Model - request 저장용(방법 2)
		model.addAttribute("writer", "한가람");
		return "boardlist";
	}
	
	@GetMapping("/shop/list")
	public String list2(Model model) {
		model.addAttribute("sangpum", "사과");
		model.addAttribute("price", "3000");
		
		return "shoplist";
	}
	
	@GetMapping({"/bitcamp/study", "/bitcamp/study2"})
	public String list3(Model model) {
		model.addAttribute("mycar", mycar.getMycarName());
		model.addAttribute("mycarColor", mycar.getMycarColor());
		
		return "study";
	}
	
}
