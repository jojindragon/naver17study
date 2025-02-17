package data.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

// properties 설정 파일에서 emp로 시작하는 값을 읽어온다.
@Configuration // 설정파일로 bean을 등록
//@PropertySource("classpath:/application.properties") // 생략 가능 - default 경로
@ConfigurationProperties(prefix = "emp")
@Data
public class MyPropDto {
	private String addr;
	private String hp;
}
