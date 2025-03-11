package test.controller;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import test.data.CarDto;

@Controller
public class TestController {
	@GetMapping("/")
	public String home() {
		// Thymeleaf는 template이 기본 경로가 되므로 따로 설정없이 이렇게 지정하면 그만
		return "car/home";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "좋은 하루!");
		model.addAttribute("myCar", "seltos_q_swp.png");
		
		return "car/hello";
	}
	
	@GetMapping("/hello2")
	public String hello2(Model model,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age") int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "car/hello2";
	}
	
	@GetMapping("/hello3")
	public String hello3(Model model) {
		CarDto dto = CarDto.builder()
				.carName("셀토스")
				.carPhoto("seltos_s_swp.png")
				.carPrice(1000000).build();
		model.addAttribute("dto", dto);
		model.addAttribute("bgcolor", "#00ff7f");
		model.addAttribute("today", new Date());
		
		return "car/hello3";
	}
	
	@GetMapping("/hello4")
	public String hello4(Model model) {
		List<CarDto> list = new Vector<>();
		list.add(new CarDto("레이(앞)", 10000, "ray_q_m9y.png"));
		list.add(new CarDto("레이(옆)", 10000, "ray_s_m9y.png"));
		list.add(new CarDto("셀토스(앞)", 15000, "seltos_q_swp.png"));
		list.add(new CarDto("셀토스(옆)", 15000, "seltos_s_swp.png"));
		
		model.addAttribute("list", list);
		
		return "car/hello4";
	}
	
	@GetMapping("/hello5")
	public String hello5(@RequestParam(value = "myid") String myid,
			HttpSession session) {
		session.setAttribute("loginId", myid);
		
		return "car/hello5";
	}
}
