package favorite;

import bean.Favorite;
import dao.FavoriteDAO;
import tool.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import tool.Page;
import java.util.Collections;
import javax.servlet.http.Cookie;
import java.io.*;
import javax.servlet.*;
import session.Session;

@WebServlet(urlPatterns={"/favorite/favoritedelete"})
public class Favoritedelete extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {

		// 削除するsightseeing_idを取得
		int sightseeing_id=Integer.parseInt(request.getParameter("sightseeing_id"));
		Boolean ajax_trust = Boolean.valueOf(request.getParameter("ajax_trust"));

		// cookie・sessionよりuser_idを取得
		// 取得できなければログイン画面へ
		Session session = new Session();
		int user_id = session.getUser_id(request,response);

		// beanへ値をセット
		Favorite f=new Favorite();
		f.setSightseeing_Id(sightseeing_id);
		f.setUser_Id(user_id);

		// Sightseeing_PlaceDAOをインスタンス化
		FavoriteDAO dao = new FavoriteDAO();
		// sightseeing_idをもとに、DBから必要な値を取得
		int line=dao.delete(f);

		// String message;
		//
		// if(line > 0){
		// 	message = "観光地を削除しました";
		// }else{
		// 	message = "観光地を削除するのに失敗しました";
		// }

		if(ajax_trust == false){
			// jspへフォワードする
			request.getRequestDispatcher("favoritelist").forward(request,response);
		}

    } catch (Exception e) {
			e.printStackTrace(out);
		}

	Page.footer(out);

	}
}
