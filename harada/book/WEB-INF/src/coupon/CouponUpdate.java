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


@WebServlet(urlPatterns={"/coupon/couponupdate"})
public class CouponUpdate extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {

			// 発行日を登録する get_coupon_idを取得
			int get_coupon_id=Integer.parseInt(request.getParameter("get_coupon_id"));

			// cookie・sessionよりuser_idを取得
			Session session = new Session();
			int user_id = session.getUser_id(request,response);

			// 発行クーポンの発行時刻と発行終了時刻を、Couponデータベースへ挿入
			CouponDAO dao=new CouponDAO();
			dao.update(get_coupon_id);

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
