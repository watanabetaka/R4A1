package sightseeing_swipe;

import bean.Sightseeing_Place;
import bean.City;
import bean.Genre;
import dao.Sightseeing_PlaceDAO;
import dao.CityDAO;
import dao.GenreDAO;
import tool.Action;
import java.io.IOException;
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
		int user_id = session.getUser_id(request,response);

		// user_idをもとに、DBから必要な値を取得
		Sightseeing_PlaceDAO dao=new Sightseeing_PlaceDAO();
		List<Sightseeing_Place> list = dao.search(user_id);

		CityDAO dao1=new CityDAO();
		List<City> list1 = dao1.search();

		GenreDAO dao2=new GenreDAO();
		List<Genre> list2 = dao2.search();

		// 取得した値をシャッフルする
		Collections.shuffle(list);

		// 値をjspへ送る為にセットする
		request.setAttribute("list",list);

		request.setAttribute("list1",list1);

		request.setAttribute("list2",list2);

		// jspへフォワードする
		return "sightseeing_swipe.jsp";
	}
}
