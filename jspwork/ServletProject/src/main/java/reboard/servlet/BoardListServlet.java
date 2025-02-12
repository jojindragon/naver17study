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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalCount; // 전체 게시글 갯수
		List<BoardDto> list = null;
		
		totalCount = dao.getTotalCount();
		list = dao.getPagingList(0, 50); // 0~50개, 페이징처리 - 나중에
		
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("./boardlist.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
