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

public class SortAction extends Action {
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
		// String array_city[] = request.getParameterValues("array_city");
		// String array_genre[] = request.getParameterValues("array_genre");
		// String spot = request.getParameter("spot");

		// テストデータを配列へ挿入
		String array_city[]={"大分市","竹田市"};
		String array_genre[]={"ホテル・旅館","カフェ・スイーツ"};
		String spot = "false";

		// cookie・sessionよりuser_idを取得
		Session session = new Session();
		int user_id = session.getUser_id(request);

		// DAOのインスタンス化
		Sightseeing_PlaceDAO dao=new Sightseeing_PlaceDAO();

		// DAOからの返却値の初期化
		// listには、返却値として、beanに、 観光地ID・観光地名・市名・写真パス が挿入される
		List<Sightseeing_Place> list= dao.search(user_id);

		// 市名が入力されており、ジャンルが入力されていない場合の処理
		if(array_city.length != 0 && array_genre.length == 0 ){
			// user_id , array_city　をもとに、DBから必要な値を取得
			list = dao.search(user_id,array_city);
		}

		// 市名が入力されておらず、ジャンルが入力されている場合の処理
		if(array_city.length == 0 && array_genre.length != 0){
			// user_id , array_genre をもとに、DBから必要な値を取得
			// DAOのsearchメソッドは、オーバーライドで記述しているため、int型で0を渡している
			list = dao.search(user_id,array_genre,0);
		}

		// 市名が入力されており、ジャンルも入力されている場合の処理
		if(array_city.length != 0 && array_genre.length != 0 ){
			// user_id , array_city , array_genre をもとに、DBから必要な値を取得
			list = dao.search(user_id,array_city,array_genre);
		}

		// 位置情報ボタンがONになっている場合は、位置情報が近い順に表示し、
		// OFFの場合は、観光地をシャッフルする処理
		if (spot== "true"){
			// 位置情報で観光地をソートする処理
		}else{
			// 観光地をシャッフルする処理
			Collections.shuffle(list);
		}

		// 値をjspへ送る為にセットする
		request.setAttribute("list",list);

		// jspへフォワードする
		return "sightseeing_swipe.jsp";
	}
}
