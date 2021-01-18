package mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MailChange")
public class MailChange extends HttpServlet {
  protected void doGet (HttpServletRequest request, HttpServletResponse response)
  throws IOException, ServletException{
    this.doPost(request, response);
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");

    String mail = request.getParameter("mail");
    String passward = request.getParameter("passward");

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>メールアドレス変更</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<script type='text/javascript'>");
    out.println("function textchange(){");
    out.println("document.getElementById('text').innerText = '更新されました';");
    out.println("}");
    out.println("function textchange2(){");
    out.println("document.getElementById('text').innerText = 'パスワードが違います！';");
    out.println("}");
    out.println("</script>");
    out.println("<form id='checkresult' method='post'></form>");
    out.println("<p>現在のパスワード　　　　　　<input type='text' form='checkresult' formaction='InfoChange' name='now_pass' value='"+passward+"'></p>");
    out.println("<p>新しいメールアドレス　　　　<input type='text' form='checkresult' formaction='InfoChange' name='new_address'></p>");
    out.println("<p>新しいメールアドレス（確認）<input type='text' form='checkresult' formaction='InfoChange' name='new_address_2'></p>");
    out.println("<p>パスワードは");
    out.println("<br>※大文字・小文字・数字・記号を含める");
    out.println("<br>※8文字以上10文字以下</p>");
    out.println("<div id='text2'></div>");
    out.println("<input type='hidden' form='checkresult' formaction='InfoChange' name=passward value="+passward+">");
    out.println("<p><button type='submit' form='checkresult' formaction='InfoChange' name='toroku' value='email'>登録</button>");
    out.println("<button type='button' onclick='history.back()'>戻る</button></p>");
    out.println("</body></html>");
  }
}
