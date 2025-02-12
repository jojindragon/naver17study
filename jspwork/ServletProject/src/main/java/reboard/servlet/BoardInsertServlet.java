package reboard.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;

@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	BoardDao dao = new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDto dto = new BoardDto();
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setRegroup(Integer.parseInt(request.getParameter("regroup")));
		dto.setRestep(Integer.parseInt(request.getParameter("restep")));
		dto.setRelevel(Integer.parseInt(request.getParameter("relevel")));
		
		dto.setWriter(request.getParameter("writer"));
		dto.setPhoto(request.getParameter("photo"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		
		dao.insertBoard(dto); //insert 후
		
		response.sendRedirect("./list"); // 목록이동
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
