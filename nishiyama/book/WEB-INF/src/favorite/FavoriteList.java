package favorite;

import bean.*;
import dao.*;
import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import session.Session;

@WebServlet(urlPatterns={"/favorite/favoritelist"})
public class FavoriteList extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {

			// cookie・sessionよりuser_idを取得
			// 取得できなければログイン画面へ
			Session session = new Session();
			int user_id = session.getUser_id(request,response);

			FavoriteDAO dao=new FavoriteDAO();
			List<Favorite> list=dao.search(user_id);

			CityDAO dao1=new CityDAO();
			List<City> list1 = dao1.search();

			GenreDAO dao2=new GenreDAO();
			List<Genre> list2 = dao2.search();

			request.setAttribute("list", list);

			request.setAttribute("list1",list1);

			request.setAttribute("list2",list2);

			request.getRequestDispatcher("/favorite/favoritelist.jsp").forward(request,response); //フォワードを行う

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
