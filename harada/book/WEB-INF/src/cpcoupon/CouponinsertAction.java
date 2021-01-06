package cpcoupon;

import bean.Application_Coupon;
import dao.Application_CouponDAO;
import tool.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.List;
import tool.Page;
import java.util.Collections;
import javax.servlet.http.Cookie;
import java.io.*;
import javax.servlet.*;
import session.Session;

public class CouponinsertAction extends Action {
	// 表示させる値を取得し、シャッフルするメソッド
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		PrintWriter out=response.getWriter();
		Page.header(out);

		// 追加する coupon_name , sightseeing_idを取得
		String coupon_name=request.getParameter("coupon_name");
		int sightseeing_id=Integer.parseInt(request.getParameter("sightseeing_id"));

		// cookie・sessionよりuser_idを取得
		Session session = new Session();
		int user_id = session.getUser_id(request,response);

		// beanへ値をセット
		Application_Coupon f=new Application_Coupon();
		f.setUser_Id(user_id);
		f.setCoupon_Name(coupon_name);
		f.setSightseeing_Id(sightseeing_id);

		// Sightseeing_PlaceDAOをインスタンス化
		Application_CouponDAO dao = new Application_CouponDAO();
		// sightseeing_idをもとに、DBから必要な値を取得
		int line=dao.insert(f);

		// 値をjspへ送る為にセットする
		request.setAttribute("line",line);

		// jspへフォワードする
		return "coupon_application_result.jsp";
	}
}
