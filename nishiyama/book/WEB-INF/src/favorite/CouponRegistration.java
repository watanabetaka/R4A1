package favorite;

import bean.Get_Coupon;
import dao.Get_CouponDAO;
import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import java.util.Random;
import session.Session;
import java.util.Date;

@WebServlet(urlPatterns={"/favorite/couponregistration"})
public class CouponRegistration extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {

			// cookie・sessionよりuser_idを取得
			Session session = new Session();
			int user_id = session.getUser_id(request,response);

			// beanへ値をセット
			Get_Coupon g=new Get_Coupon();
			g.setUser_Id(user_id);

			Get_CouponDAO dao=new Get_CouponDAO();
			dao.insert(g);
			List<Get_Coupon> list=dao.search(user_id);

			request.setAttribute("list", list);
			request.getRequestDispatcher("/favorite/share_result.jsp").forward(request,response); //フォワードを行う

    } catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
