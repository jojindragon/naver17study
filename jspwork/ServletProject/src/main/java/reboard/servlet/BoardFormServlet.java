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

@WebServlet("/board/writeform")
public class BoardFormServlet extends HttpServlet {
	BoardDao dao = new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//num, regroup, restep relevel
		// 새글일 경우: null 값
		// 답글일 경우: 정수타입 숫자
		int num, regroup, restep, relevel;
		String subject = ""; // 답글의 경우 - 원글 제목을 표시
		
		try {
			// 답글 - 원글의 값들을 가져온다.
			num = Integer.parseInt(request.getParameter("num"));
			regroup = Integer.parseInt(request.getParameter("regroup"));
			restep = Integer.parseInt(request.getParameter("restep"));
			relevel = Integer.parseInt(request.getParameter("relevel"));
			
			// 원글 제목 얻기
			subject = dao.getData(num).getSubject();
			
		} catch (NumberFormatException e) {
			// 신규글 예외처리(익셉션 발생)
			num = regroup = restep = relevel = 0;
		}
		//request에 설정
		request.setAttribute("num", num);
		request.setAttribute("regroup", regroup);
		request.setAttribute("restep", restep);
		request.setAttribute("relevel", relevel);
		request.setAttribute("subject", subject);
		
		RequestDispatcher rd = request.getRequestDispatcher("./writeform.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
