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
import session.Session;


@WebServlet(urlPatterns={"/coupon/couponsearch"})
public class CouponSearch extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {

			// cookie・sessionよりuser_idを取得
			Session session = new Session();
			int user_id = session.getUser_id(request,response);

			CouponDAO dao=new CouponDAO();
			List<Coupon> list=dao.search(user_id);

			request.setAttribute("list", list);
			request.getRequestDispatcher("CouponH.jsp").forward(request,response); //フォワードを行う

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
