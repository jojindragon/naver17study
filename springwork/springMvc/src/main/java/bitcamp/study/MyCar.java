package bitcamp.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 첫글자가 소문자인 mycar라는 이름으로 bean 등록이 된다.
@Data
public class MyCar {
	@Value("아우디 A6")
	private String mycarName;
	@Value("진주색")
	private String mycarColor;
}
