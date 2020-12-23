package sightseeing_place;

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

public class DetailAction extends Action {
	// 表示させる値を取得し、シャッフルするメソッド
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		PrintWriter out=response.getWriter();
		Page.header(out);

		// 末松君からsightseeing_idを取得
		// int sightseeing_id=Integer.parseInt(request.getParameter("sightseeing_id"));
		int sightseeing_id = 1;

		// Sightseeing_PlaceDAOをインスタンス化
		Sightseeing_PlaceDAO dao=new Sightseeing_PlaceDAO();
		// sightseeing_idをもとに、DBから必要な値を取得
		List<Sightseeing_Place> list = dao.detail_search(sightseeing_id);

		// 値をjspへ送る為にセットする
		request.setAttribute("list",list);

		// jspへフォワードする
		return "sightseeing_place.jsp";
	}
}
