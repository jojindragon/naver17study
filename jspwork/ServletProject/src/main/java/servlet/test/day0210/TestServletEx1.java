package servlet.test.day0210;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class TestServlteEx1
 */

// url mapping 주소: 임의로 아무거나 지정 가능(폴더에 없는 내용도 가능) 
@WebServlet("/bit/hello.do")
public class TestServletEx1 extends HttpServlet {
	/* 없어도 되는 부분
	 * private static final long serialVersionUID = 1L;
	 * 
	 *//**
		 * @see HttpServlet#HttpServlet()
		 */
	/*
	 * public TestServlteEx1() { super(); // TODO Auto-generated constructor stub }
	 * 
	 *//**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 프로젝트명도 자동으로 획득
		/* 출력문이기에 지운다.
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		
		// request에 각종 데이터 저장하기
		request.setAttribute("today", new Date());
		request.setAttribute("myname", "이영자");
		request.setAttribute("myage", 19);
		
		// 방법 1
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		request.setAttribute("today2", sdf.format(new Date()));
		
		// jsp 파일로 포워드(forward)
		// 포워드: request가 그대로 전달, url 주소 변화 X
		RequestDispatcher rd = request.getRequestDispatcher("../jstltest/result1.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
