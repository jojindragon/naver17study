package reboard.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reboard.data.BoardDao;

import java.io.IOException;

@WebServlet("/board/delete")
public class BoardDeleteProcessServlet extends HttpServlet {
	BoardDao dao = new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//num
		int num = Integer.parseInt(request.getParameter("num"));
		//pageNum
		String pageNum = request.getParameter("pageNum");
		//passwd
		String passwd = request.getParameter("passwd");
		//비번이 맞는지 boolean 얻기
		boolean b = dao.isCheckPass(num, passwd);

		if(b) {//true - 삭제후 목록 이동(pageNum 전달)
			dao.deleteBoard(num);
			response.sendRedirect("./list?pageNum="+pageNum);
		} else {// false - fail.jsp 포워드
			RequestDispatcher rd = request.getRequestDispatcher("./fail.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
