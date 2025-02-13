package reboard.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;
import java.util.List;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	BoardDao dao = new BoardDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 페이징 처리 02.13 목
		int perPage = 10; // 1페이지 당 출력할 글의 갯수
		int perBlock = 5; // 1블럭 당 출력할 페이지 갯수

		int totalCount; // 전체 게시글 갯수
		int totalPage; // 총 페이지 수

		int startPage; // 각 블럭에서 출력할 시작 페이지
		int endPage; // 각 블럭에서 출력할 끝 페이지
		// 각 페이지 시작번호(mysql: 0, Oracle: 1)
		// DB 상 페이징 처리를 위한 기준 값
		int startNum;

		int no; // 각 페이지에서 출력할 시작 번호
		int pageNum; // 현재 페이지 번호

		List<BoardDto> list = null;

		// 현재 페이지 얻기(null => 1)
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
			pageNum = 1;
		}

		totalCount = dao.getTotalCount(); // 총 글 갯수
		// 총 페이지 갯수
//		totalPage = totalCount / perPage + (totalCount%perPage > 0 ? 1:0);//방법1 나머지 존재하면 무조건 1 더하기
		totalPage = (int) Math.ceil((double) totalCount / perPage);// 방법2, 무조건 올림함수

		// 시작 페이지 구하기
		startPage = (pageNum - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		if (endPage > totalPage)
			endPage = totalPage;

		// 각 페이지에서 출력할 시작 번호 - mysql 시작번호: 0, oracle: 1 => +1
		startNum = (pageNum - 1) * perPage;

		list = dao.getPagingList(startNum, perPage); // 페이징처리
		// 마지막 페이지의 1개 남은 글을 지운 경우
		// -> 해당 페이지로 오게 하면 데이터가 없는 현상
		if (list.size() == 0) {
			response.sendRedirect("./list?pageNum=" + (pageNum - 1));
		}

		// 각 페이지의 글 앞에 출력할 시작번호(예: 총 글이 20개, 1페이지는 20, 2페이지는 15...)
		no = totalCount - (pageNum - 1) * perPage;

		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		// 페이지 출력에 필요한 모든 변수
		// 총페이지 갯수, 시작페이지, 끝페이지, no, 현재 페이지
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("no", no);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPage", totalPage);

		RequestDispatcher rd = request.getRequestDispatcher("./boardlist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
