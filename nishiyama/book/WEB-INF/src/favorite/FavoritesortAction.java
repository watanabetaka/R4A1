package favorite;

import bean.Favorite;
import bean.City;
import bean.Genre;
import dao.FavoriteDAO;
import dao.CityDAO;
import dao.GenreDAO;
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
import java.util.Arrays;

public class FavoritesortAction extends Action {
	// ソート画面からソート情報の値を取得し、
	// 表示させる値をDAOから取得し、
	// 位置情報がONの場合は、位置情報が近い順に表示させ、
	// OFFの場合は、観光地をシャッフルするメソッド

	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		PrintWriter out=response.getWriter();
		Page.header(out);

		// 児玉君から送信されたデータの受け取り
		 String array_city[] = request.getParameterValues("array_city");
		 String array_genre[] = request.getParameterValues("array_genre");
		 Boolean asc_sort = Boolean.valueOf(request.getParameter("asc_sort"));
		 // System.out.println(Arrays.toString(array_city));
		 // System.out.println(Arrays.toString(array_genre));
		 // System.out.println(asc_sort);

		// // テストデータを配列へ挿入
		// String array_city[]={"大分市","竹田市"};
		// String array_genre[]={};
		// String spot = "false";

		// cookie・sessionよりuser_idを取得
		// 取得できなければログイン画面へ
		Session session = new Session();
		int user_id = session.getUser_id(request,response);

		// DAOのインスタンス化
		FavoriteDAO dao=new FavoriteDAO();

		// DAOからの返却値の初期化
		// listには、返却値として、beanに、 観光地ID・写真パス・観光地名 が挿入される
		// DAOのsearchメソッドは、オーバーライドで記述しているため、int型で0を渡している
		List<Favorite> list= dao.search(user_id , "dummy");

		// 市名が入力されており、ジャンルが入力されていない場合の処理
		if(array_city != null && array_genre == null ){
			// user_id , array_city　をもとに、DBから必要な値を取得
			list = dao.search(user_id,array_city);
		}

		// 市名が入力されておらず、ジャンルが入力されている場合の処理
		if(array_city == null && array_genre != null){
			// user_id , array_genre をもとに、DBから必要な値を取得
			// DAOのsearchメソッドは、オーバーライドで記述しているため、int型で0を渡している
			list = dao.search(user_id,array_genre,0);
		}

		// 市名が入力されており、ジャンルも入力されている場合の処理
		if(array_city != null && array_genre != null ){
			// user_id , array_city , array_genre をもとに、DBから必要な値を取得
			list = dao.search(user_id,array_city,array_genre);
		}

		// 古い順に並べ替え ボタンがONになっている場合は、観光地を追加順に表示する
		if (asc_sort == true){
			// 観光地を日時で昇順にソートする処理
			Collections.reverse(list);
		}

		CityDAO dao1=new CityDAO();
		List<City> list1 = dao1.search();

		GenreDAO dao2=new GenreDAO();
		List<Genre> list2 = dao2.search();



		// 値をjspへ送る為にセットする
		request.setAttribute("list",list);

		request.setAttribute("list1",list1);

		request.setAttribute("list2",list2);
		
		// jspへフォワードする
		return "favoritelist.jsp";
	}
}
