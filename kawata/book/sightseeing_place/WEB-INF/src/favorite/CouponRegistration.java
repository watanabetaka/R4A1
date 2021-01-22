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

@WebServlet(urlPatterns={"/coupon/couponregistration"})
public class CouponRegistration extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {

			//乱数生成
			Random rand = new Random();
			int random_id = rand.nextInt(3) + 1;

			// cookie・sessionよりuser_idを取得
			Session session = new Session();
			int user_id = session.getUser_id(request,response);

			Get_CouponDAO dao=new Get_CouponDAO();
			dao.insert(user_id,random_id);

    } catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
