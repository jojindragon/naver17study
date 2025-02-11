package shop.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shop.data.ShopDao;
import shop.data.ShopDto;

import java.io.IOException;

@WebServlet("/shop/detail")
public class ShopDetailServlet extends HttpServlet {
	ShopDao dao = new ShopDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// num 읽기
		int num = Integer.parseInt(request.getParameter("num"));
		// dto 얻기
		ShopDto dto = dao.getSangpum(num);
		// request에 dto 저장
		request.setAttribute("dto", dto);
		// shopdetail.jsp로 포워드
		RequestDispatcher rd = request.getRequestDispatcher("./shopdetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
