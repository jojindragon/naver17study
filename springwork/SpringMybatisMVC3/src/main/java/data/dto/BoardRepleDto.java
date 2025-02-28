package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("BoardRepleDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardRepleDto {
	private int num;
	private int idx;
	private String myid;
	private String message;
	private String photo;
	@JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp writeday;
	private String writer; // 작성자 닉네임
	private String profile; // 작성자 프로필
}
