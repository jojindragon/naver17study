package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"controller.test", "lombok.test"}) // default 패키지 바깥쪽도 Scan하겠다.
@ComponentScan({"*.test", "bitcamp.study"}) // 패키지에 공통점이 있는 경우 적용 방식 - wild card
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
