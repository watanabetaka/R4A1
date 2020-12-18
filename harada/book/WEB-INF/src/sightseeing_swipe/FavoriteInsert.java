package sightseeing_swipe;

import bean.Favorite;
import dao.FavoriteDAO;
import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import session.Session;

// ajax通信の開始
@WebServlet(urlPatterns={"/sightseeing_swipe/favorite_insert"})
public class FavoriteInsert extends HttpServlet {
	// 右スワイプされたsightseeing_idを取得し、favoriteデータベースに挿入するメソッド
	public void doGet(
	HttpServletRequest request,HttpServletResponse response
	)throws ServletException,IOException {
			PrintWriter out=response.getWriter();
			Page.header(out);
			try{

				// 右スワイプされたsighseeing_idを取得し、int型に変換
				int sightseeing_id=Integer.parseInt(request.getParameter("sightseeing_id"));

				// cookie・sessionよりuser_idを取得
				Session session = new Session();
				int user_id = session.getUser_id(request);

				// beanへ値をセット
				Favorite f=new Favorite();
				f.setSightseeing_Id(sightseeing_id);
				f.setUser_Id(user_id);

				// user_id、sightseeing_idを、favoriteデータベースへ挿入
				FavoriteDAO dao=new FavoriteDAO();
				dao.insert(f);

			}catch(Exception e){
				e.printStackTrace(out);
			}
			Page.footer(out);
	}
}
