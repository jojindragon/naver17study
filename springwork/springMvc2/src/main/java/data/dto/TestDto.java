package data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter&sSetter&ToString 융합
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
	private String name;
	private String addr;
	private String gender;
}
