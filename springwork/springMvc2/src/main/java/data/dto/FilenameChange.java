package data.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FilenameChange {
	public static String getDateChangeFileName(String originalName) {
		// 파일명에 날짜를 붙여서 업로드
		// (예) a.jpg => a_20250218104231.jpg
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmss");
		String fileName = originalName.split("\\.")[0];
		String extName = originalName.split("\\.")[1];

		// 최종 업로드 파일명
		String uploadFileName = fileName + "_"
				+ sdf.format(new Date()) + "." + extName;

		return uploadFileName;
	}
	
	public static String getRandomChangeFileName(String originalName) {
		// 파일명을 랜덤 값으로 업로드, 확장자만 구하기
		String extName = originalName.split("\\.")[1];
		
		// 최종 업로드 파일명
		String uploadFileName = UUID.randomUUID() + "." + extName;
		
		return uploadFileName;
	}
}
