
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

@WebServlet(urlPatterns={"/favorite/favoritelist"})
public class FavoriteList extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
//			if(session.getAttribute("user") != null){
//        String session_id = (String)session.getAttribute("user");
//        int user_id = Integer.parseInt(session_id);//ここにセッションのユーザIDが入ってます
          //ログインか新規会員登録以外からメニュー画面へ遷移した場合
//			}else{
//  			Cookie[] cookies=request.getCookies();

//		if (cookies!=null) {
//     		int user_id;
//     		for (Cookie cookie : cookies) {
//        	String name=cookie.getName();
//        	if(name.equals("user")){
//          	String value=cookie.getValue();
//          	user_id = Integer.parseInt(value);//ここにセッションのユーザIDが入ってます
//        	}
//      	}
//   		} else {
//		System.out.println("クッキーは存在しません");
// 		}
//		}


			int Keyword=1;

			FavoriteDAO dao=new FavoriteDAO();
			List<Favoritebean> list=dao.search(Keyword);

			request.setAttribute("list", list);
			request.getRequestDispatcher("/favorite/favoritelist.jsp").forward(request,response); //フォワードを行う

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
