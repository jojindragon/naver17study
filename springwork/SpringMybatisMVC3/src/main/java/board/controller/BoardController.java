package board.controller;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.dto.BoardFileDto;
import data.dto.MemberDto;
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
		String writer = memberService.getSelectByMyid(myid).getMname(); 
		
		// dto에 넣기
		dto.setMyid(myid);
		dto.setWriter(writer);
		
		// 게시판 내용 DB에 저장(insert 후 idx 획득 가능)
		boardService.insertBoard(dto);		
		
		/* 파일이 있는 경우에만 해당
		 * 네이버 스토리지에 저장 후 idx와 맞춰 DB(boardfile)에 저장
		 * 반복문 사용
		 */
		if(!upload.get(0).getOriginalFilename().equals("")) {
			BoardFileDto bdto = new BoardFileDto();
			bdto.setIdx(dto.getIdx());
			
			for(MultipartFile f:upload) {
				String file = storageService.uploadFile(bucketName, "board", f);
				bdto.setFilename(file);
				fileService.insertBoardFile(bdto);
			}
		}
		
		return "redirect:./list?pageNum="+pageNum;
	}
	
	@GetMapping("/detail")
	public String detail(HttpSession session, @RequestParam int idx,
			@RequestParam(defaultValue = "1") int pageNum,
			Model model) {
		// 조회수 1 증가
		boardService.updateReadcount(idx);
		
		// 작성글 정보 얻기: idx에 해당하는 dto 얻기
		BoardDto dto = boardService.getSelectByIdx(idx);
		
		// 작성글 사진들 얻기 - idx에 맞는 파일들 가져오기
		List<String> fileList = new Vector<>();
		List<BoardFileDto> flist = fileService.getFiles(idx);
		for(BoardFileDto fdto:flist) {
			fileList.add(fdto.getFilename());
		}
		dto.setPhotos(fileList);
		dto.setPhotoCount(fileList.size());
		 
		// 작성자 사진 얻기
		String writerPhoto = memberService.getSelectByMyid(dto.getMyid()).getMphoto();
		
		// 모델 저장
		model.addAttribute("dto", dto);
		model.addAttribute("wphoto", writerPhoto);
		model.addAttribute("pageNum", pageNum);
		
		// 네이버클라우드 주소
		model.addAttribute("wfronturl", "https://radbwaqf8739.edge.naverncp.com/DaFq6foQou");
		model.addAttribute("wbackurl", "?type=f&w=50&h=50&faceopt=true&ttype=jpg");
		model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/"+bucketName);
		
		String loginid = (String) session.getAttribute("loginid");
		String writer = memberService.getSelectByMyid(loginid).getMname();
		model.addAttribute("writer", writer);
		
		return "board/boarddetail";
	}
	
	@GetMapping("/updateform")
	public String updateForm(Model model, @RequestParam int idx,
			@RequestParam int pageNum) {
		// 작성글 정보 가져오기
		BoardDto dto = boardService.getSelectByIdx(idx);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("fronturl", "https://radbwaqf8739.edge.naverncp.com/DaFq6foQou");
		model.addAttribute("backurl", "?type=f&w=50&h=50&faceopt=true&ttype=jpg");
		
		return "board/updateform";
	}
	
	// 게시글 사진 리스트 보내기
	@GetMapping("/photolist")
	@ResponseBody
	public List<BoardFileDto> photoList(@RequestParam int idx) {
		List<BoardFileDto> list = fileService.getFiles(idx);
		return list;
	}
	
	// 게시글 내용 수정
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDto dto,
			@RequestParam int pageNum) {
		boardService.updateBoard(dto);
		return "redirect:./detail?idx="+dto.getIdx()+"&pageNum="+pageNum;
	}
	
	// boardfile 수정
	@PostMapping("/photoUp")
	@ResponseBody
	public void photoUp(@RequestParam int idx,
			@RequestParam("upload") List<MultipartFile> upload) {
		BoardFileDto dto = new BoardFileDto();
		dto.setIdx(idx);
		
		for(MultipartFile f:upload) {
			String file = storageService.uploadFile(bucketName, "board", f);
			dto.setFilename(file);
			fileService.insertBoardFile(dto);
		}
	}
	
	// boardfile 삭제
	@PostMapping("/photoDel")
	@ResponseBody
	public void photoDel(@RequestParam int num) {
		// 스토리지에서 삭제
		String filename = fileService.getFileName(num); 
		storageService.deleteFile(bucketName, "board", filename);
		
		// DB에서 삭제
		fileService.deleteFile(num);
	}
	
	// 게시글 삭제
	@GetMapping("/delete")
	@ResponseBody
	public void boardDelete(@RequestParam int idx) {
		// 스토리지 관련 사진 삭제
		List<BoardFileDto> list = fileService.getFiles(idx);
		for(BoardFileDto dto:list) {
			String filename = dto.getFilename();
			storageService.deleteFile(bucketName, "board", filename);
		}
		
		// DB 삭제
		boardService.deleteBoard(idx);
	}
	
}
