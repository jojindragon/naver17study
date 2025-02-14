package lombok.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
@Data // 3개 합친 경우
@NoArgsConstructor // default 생성자
@AllArgsConstructor // 모든 변수를 인자로 받는 생성자
public class TestDto {
	private String name;
	private String addr;
	private String hp;
}
