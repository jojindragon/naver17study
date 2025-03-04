package data.dto;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("BoardDto")
public class BoardDto {
	private int idx;
	private String myid;
	private String writer;
	private String subject;
	private String content;
	private int readcount;
	private int regroup;
	private int relevel;
	private int restep;
	private Timestamp writeday;
	private List<String> photos; // join으로 사진을 가져온다.
	private int photoCount; // photos에 몇개가 들어가있느냐 계산
	private int repleCount; // 댓글 갯수
}
