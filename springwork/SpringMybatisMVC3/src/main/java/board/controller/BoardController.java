package board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.dto.BoardFileDto;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	final BoardService boardService;
	final BoardFileService fileService;
	final MemberService memberService;
	final NcpObjectStorageService storageService;
	
	private String bucketName = "bitcamp-bucket-139";
	
	@GetMapping("/writeform")
	public String writeform(
			// 5개의 값은 답글일 때만 넘어온다.
			// 신규 글은 null이므로 모두 defaultValue 처리 또는 required=false
			@RequestParam(value = "idx", defaultValue = "0") int idx,
			@RequestParam(value = "regroup", defaultValue = "0") int regroup,
			@RequestParam(value = "restep", defaultValue = "0") int restep,
			@RequestParam(value = "relevel", defaultValue = "0") int relevel,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			Model model) {
		model.addAttribute("idx", idx);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		model.addAttribute("pageNum", pageNum);
		
		return "board/writeform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam int pageNum,
			@RequestParam("upload") List<MultipartFile> upload,
			HttpSession session) {
		// session에서 아이디 얻기
		String myid = (String) session.getAttribute("loginid");
		
		// 아이디를 이용해서 멤버 테이블에서 작성자를 획득
		dto.setMyid(myid);
		dto.setWriter(memberService.getSelectByMyid(myid).getMname());
		
		// 게시판 내용 DB에 저장(insert 후 idx 획득 가능)
		boardService.insertBoard(dto);		
		
		/* 파일이 있는 경우에만 해당
		 * 네이버 스토리지에 저장 후 idx와 맞춰 DB(boardfile)에 저장
		 * 반복문 사용
		 */
		BoardFileDto bfd = new BoardFileDto();
		bfd.setIdx(dto.getIdx());
		
		for(MultipartFile file:upload) {
			String fileName = storageService.uploadFile(bucketName, "board", file);
			bfd.setFilename(fileName);
			fileService.insertBoardFile(bfd);
		}
		
		return "redirect:./list?pageNum="+pageNum;
	}
	
	@GetMapping("/detail")
	public String detail() {
		return "board/boarddetail";
	}
	
}
