package mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoChange")
public class InfoChange extends HttpServlet {
  protected void doGet (HttpServletRequest request, HttpServletResponse response)
  throws IOException, ServletException{
    this.doPost(request, response);
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");

    String toroku = request.getParameter("toroku");;
    String passward = request.getParameter("passward");;
    String new_pass = request.getParameter("new_pass");
    String new_pass_2 = request.getParameter("new_pass_2");
    String now_pass = request.getParameter("now_pass");
    String new_address = request.getParameter("new_address");
    String new_address_2 = request.getParameter("new_address_2");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("</head>");
    out.println("<body>");
    if(now_pass.equals("pass")){
      if(toroku.equals("email")){
        if(!(new_address.equals(new_address_2))){
          out.println("<p>入力された二つのメールアドレスが一致していません！</p>");
        }else{
          out.println("<p>入力された項目を表示します。</p>");
          out.println("<p>現在のパスワード　　　　　　：" + now_pass + "</p>");
          out.println("<p>新しいメールアドレス　　　　：" + new_address + "</p>");
          out.println("<p>新しいメールアドレス（確認）：" + new_address_2 + "</p>");
        }
      }else if(toroku.equals("pass")){
        if(!(new_pass.equals(new_pass_2))){
          out.println("<p>入力された二つのパスワードが一致していません！</p>");
        }else{
          out.println("<p>入力された項目を表示します。</p>");
          out.println("<p>現在のパスワード　　　　　　：" + now_pass + "</p>");
          out.println("<p>新しいパスワード　　　　　　：" + new_pass + "</p>");
          out.println("<p>新しいパスワード（確認）　　：" + new_pass_2 + "</p>");
        }
      }
    }else{
      out.println("<p>パスワードが違います！</p>");
    }
    out.println("<button type='button' onclick='history.back()'>戻る</button></p>");
    out.println("</body></html>");
  }
}
