package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("sdto") // 별칭 주기
public class ShopDto {
	private int num;
	private String sangpum;
	private String scolor;
	private int sprice;
	private int scnt;
	private String sphoto;
	private String ipgoday;
	private Timestamp writeday;
	
	private String mainPhoto;
	private int replecnt; // 댓글 갯수저장
}
