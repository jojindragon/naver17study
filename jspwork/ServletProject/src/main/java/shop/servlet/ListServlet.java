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
import java.util.List;

@WebServlet("/shop/list")
public class ListServlet extends HttpServlet {

	public ListServlet() {
        super();
    }

	ShopDao dao = new ShopDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 갯수 및 상품 목록 가져오기
		int tot = dao.getTotalCount();
		List<ShopDto> list = dao.getAllDatas();
		
		// request에 저장
		request.setAttribute("tot", tot);
		request.setAttribute("list", list);
		
		// forward
		RequestDispatcher rd = request.getRequestDispatcher("./shoplist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
