package coupon;

import bean.Coupon;
import dao.CouponDAO;
import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import javax.servlet.http.Cookie;

@WebServlet(urlPatterns={"/coupon/CouponSerch"})
public class CouponSerch extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		System.out.print("iiii");
		try {
      int keyword = 1;
			CouponDAO dao=new CouponDAO();
			List<Coupon> list=dao.search(keyword);

			request.setAttribute("list", list);
			request.getRequestDispatcher("/coupon/CouponH.jsp").forward(request,response); //フォワードを行う

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
