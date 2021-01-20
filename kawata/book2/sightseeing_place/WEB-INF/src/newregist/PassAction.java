package newregist;

import bean.User;
import dao.RegistuserDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import session.Passwordutil;

public class PassAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		//既存のsession取得
		HttpSession session=request.getSession();
		// 入力されたパスワード取得
		String pass = request.getParameter("pass");
		  /* sessionにメールアドレスが格納されているか確認し、あればメールアドレスと
		  	パスワードの登録を、なければトップ画面へ戻す*/
		if(session.getAttribute("email") != null){
			//セッションからメールアドレスを取得
			String email = (String)session.getAttribute("email");
			/*パスワードとメールアドレスを連結してハッシュ化したものをパスワード
			として格納*/
			String hashpass = Passwordutil.getSafetyPassword("pass","email");
			// 一般ユーザー登録用のdaoを呼び出し
			RegistuserDAO dao=new RegistuserDAO();
			// lineに更新された行が入る
			int line = dao.insert(email,hashpass);
			// 更新された行が存在しているか確認
			if(line > 0){
				//sessionに格納されているメールアドレスを削除する
				session.removeAttribute("email");
				// メールアドレスを元にユーザIDをデータベースから探す
				int user_id = dao.searchid(email);
				// sessionに名前はuserで値にユーザIDを入れたものを格納する
				session.setAttribute("user", Integer.toString(user_id));
				// cookieに名前はuserで値にユーザIDを入れたものを格納する
				Cookie cookie = new Cookie("user", Integer.toString(user_id));
				//cookieの生存期間を２か月に設定
				cookie.setMaxAge(60*60*24*60);
				//cookieのpathを"/book"にする
				cookie.setPath("/book");
				//cookieの追加を行う
				response.addCookie(cookie);
				//スワイプ操作画面へ遷移する
				RequestDispatcher dispatch = request.getRequestDispatcher("../sightseeing_swipe/Swipe.action");
				dispatch.forward(request, response);
			}
		}

			//アプリ起動時の画面へ遷移する
			return "../firstselect/userfirstselect.jsp";
	}
	}
