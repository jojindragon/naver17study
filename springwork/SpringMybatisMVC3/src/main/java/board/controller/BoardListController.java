package board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.BoardDto;
import data.service.BoardFileService;
import data.service.BoardRepleService;
import data.service.BoardService;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardListController {
	final BoardService boardService;
	final BoardFileService fileService;
	final MemberService memberService;
	final BoardRepleService boardRepleService;

	@GetMapping("/board/list")
	public String list(Model model,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
		// 페이징 처리
		int perPage = 5; // 1페이지 당 출력할 글
		int perBlock = 5; // 1블럭 당 출력할 페이지 갯수

		int totalCount = boardService.getTotalCount(); // 전체 게시글 갯수
		int totalPage; // 총 페이지 수

		// 각 페이지 시작번호(mysql: 0, Oracle: 1)
		// DB 상 페이징 처리를 위한 기준 값
		int startNum;
		int startPage; // 각 블럭에서 출력할 시작 페이지
		int endPage; // 각 블럭에서 출력할 끝 페이지
		int no; // 각 페이지에서 출력할 시작 번호

		List<BoardDto> list = null; // 페이징에 필요한 데이터

		// 총 페이지 갯수
		totalPage = (int) Math.ceil((double) totalCount / perPage);// 방법2, 무조건 올림함수

		// 시작 페이지 구하기
		startPage = (pageNum - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		if (endPage > totalPage)
			endPage = totalPage;

		// 각 페이지에서 출력할 시작 번호 - mysql 시작번호: 0, oracle: 1 => +1
		startNum = (pageNum - 1) * perPage;

		list = boardService.getPagingList(startNum, perPage); // 페이징처리
		// 마지막 페이지의 1개 남은 글을 지운 경우
		// -> 해당 페이지로 오게 하면 데이터가 없는 현상
		if (list.size() == 0) {
			return "redirect:./list?pageNum="+(pageNum - 1);
		}

		// list의 각 dto에 사진 갯수 저장하기
		for(int i=0;i<list.size(); i++ ) {
			BoardDto dto = list.get(i);
			int count = fileService.getFiles(dto.getIdx()).size();
			list.get(i).setPhotoCount(count);
			
			// 댓글 갯수
			int repleCnt = boardRepleService.getRepleCount(dto.getIdx());
			list.get(i).setRepleCount(repleCnt);
		}
		
		// 각 페이지의 글 앞에 출력할 시작번호(예: 총 글이 20개, 1페이지는 20, 2페이지는 15...)
		no = totalCount - (pageNum - 1) * perPage;

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		// 페이지 출력에 필요한 모든 변수
		// 총페이지 갯수, 시작페이지, 끝페이지, no, 현재 페이지
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("no", no);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalPage", totalPage);

		return "board/boardlist";
	}
}
