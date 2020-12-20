package sightseeing_swipe;

import bean.Sightseeing_Place;
import dao.Sightseeing_PlaceDAO;
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

public class SwipeAction extends Action {
	// 表示させる値を取得し、シャッフルするメソッド
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		PrintWriter out=response.getWriter();
		Page.header(out);

		// cookie・sessionよりuser_idを取得
		Session session = new Session();
		int user_id = session.getUser_id(request);

		// user_idをもとに、DBから必要な値を取得
		Sightseeing_PlaceDAO dao=new Sightseeing_PlaceDAO();
		List<Sightseeing_Place> list = dao.search(user_id);

		// 取得した値をシャッフルする
		Collections.shuffle(list);

		// 値をjspへ送る為にセットする
		request.setAttribute("list",list);

		// jspへフォワードする
		return "sightseeing_swipe.jsp";
	}
}
