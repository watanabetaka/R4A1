package cpcoupon;

import bean.Sightseeing_Place;
import bean.Application_Coupon;
import dao.Sightseeing_PlaceDAO;
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

public class SightseeingsearchAction extends Action {
	// 表示させる値を取得し、シャッフルするメソッド
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		PrintWriter out=response.getWriter();
		Page.header(out);

		// cookie・sessionよりuser_idを取得
		Session session = new Session();
		int user_id = session.getUser_id(request,response);


		// user_idをもとに、DBから必要な値を取得
		Application_CouponDAO application_dao=new Application_CouponDAO();
		int line = application_dao.search(user_id);

		// user_id が application_coupon DBに存在したら、現在申請中とみなし、
		// そのメッセージを返却する
		if(line > 0){
			String message = "現在申請中です";
			request.setAttribute("message",message);
		}

		// user_idをもとに、DBから必要な値を取得
		Sightseeing_PlaceDAO sightseeing_dao=new Sightseeing_PlaceDAO();
		
		// 引数を合わせるため、0を入力
		List<Sightseeing_Place> sightseeing_list = sightseeing_dao.search(user_id , 0 , 0);

		// 値をjspへ送る為にセットする
		request.setAttribute("list",sightseeing_list);

		// jspへフォワードする
		return "coupon_application.jsp";
	}
}
