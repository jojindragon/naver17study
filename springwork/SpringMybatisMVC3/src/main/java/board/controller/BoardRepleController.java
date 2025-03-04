package board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardRepleDto;
import data.service.BoardRepleService;
import data.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardRepleController {
	final MemberService memberService;
	final BoardRepleService boardRepleService;
	final NcpObjectStorageService storageService;

	private String bucketName = "bitcamp-bucket-139";
	private String uploadFilename;
	private String updateFile;// 수정할 파일 작업
	
	// 댓글 사진 업로드
	@PostMapping("/repleupload")
	public String upload(@RequestParam("upload") MultipartFile upload) {
		if(uploadFilename!=null) {
			storageService.deleteFile(bucketName, "board", uploadFilename);	
		}
		uploadFilename = storageService.uploadFile(bucketName, "board", upload);
		return uploadFilename;
	}
	
	// 댓글 사진 삭제
	@GetMapping("/replephotodel")
	public void photoDel(@RequestParam String fname) {
		storageService.deleteFile(bucketName, "board", fname);
		uploadFilename=null;
	}
	
	// 댓글 입력
	@PostMapping("addReple")
	public void addReple(HttpSession session, @RequestParam int idx,
			@RequestParam String message) {
		String loginid = (String) session.getAttribute("loginid");
		
		// 클래스명.builder()로 시작해 값을 셋팅 후 build()를 호출해 객체 생성
		
		BoardRepleDto dto = BoardRepleDto.builder()
				.idx(idx).message(message).myid(loginid)
				.photo(uploadFilename).build();
		
		boardRepleService.insertReple(dto);
		uploadFilename=null;
	}
	
	// 댓글 출력
	@GetMapping("/replelist")
	public List<BoardRepleDto> getRepleList(@RequestParam int idx) {
		List<BoardRepleDto> list = boardRepleService.getAllReples(idx);
		for(BoardRepleDto dto:list) {
			String writer = memberService.getSelectByMyid(dto.getMyid()).getMname();
			String profile = memberService.getSelectByMyid(dto.getMyid()).getMphoto();
			dto.setWriter(writer);
			dto.setProfile(profile);
		}
		
		return list;
	}
	
	// 총 댓글 갯수
	@GetMapping("/replecnt")
	public int getRepleCnt(@RequestParam int idx) {
		return boardRepleService.getRepleCount(idx);
	}
	
	// 댓글 삭제
	@PostMapping("deleteReple")
	public void deleteReple(@RequestParam int num) {
		BoardRepleDto dto = boardRepleService.getOneReple(num);
		// 스토리지 삭제
		String photo = "";
		if(dto.getPhoto() != null) {
			photo = dto.getPhoto();
			storageService.deleteFile(bucketName, "board", photo);
		}
		
		// DB에서 삭제
		boardRepleService.deleteReple(num);
	}
	
	/* 수정 관련 작업 */
	@PostMapping("/newPhotoUp")
	public String newPhotoUp(@RequestParam("upload") MultipartFile upload) {
		// 수정할 사진 업로드
		if(updateFile!=null) {
			storageService.deleteFile(bucketName, "board", updateFile);	
		}
		
		updateFile = storageService.uploadFile(bucketName, "board", upload);
		return updateFile;
	}
	
	@GetMapping("/cancelUp")
	public void cancelUp(@RequestParam String fname) {
		// 업로드 취소 작업
		storageService.deleteFile(bucketName, "board", fname);
		updateFile=null;
	}
	
	// 댓글 수정
	@PostMapping("/updateReple")
	public void updateReple(@RequestParam int num,
			@RequestParam String message) {
		// 기존 사진 정보 얻기
		uploadFilename = boardRepleService.getOneReple(num).getPhoto();
		// 기존 사진 삭제
		if(uploadFilename != null) {
			storageService.deleteFile(bucketName, "board", uploadFilename);
			uploadFilename = null;
		}
		
		BoardRepleDto dto = BoardRepleDto.builder()
				.num(num).message(message)
				.photo(updateFile).build();
		
		boardRepleService.updateReple(dto);
		
		updateFile = null;
	}
	
}
