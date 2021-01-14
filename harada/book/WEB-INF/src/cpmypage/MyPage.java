package mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.DAO;
import dao.UserDAO;

@WebServlet("/MyPage")
public class MyPage extends HttpServlet {
  protected void doGet (HttpServletRequest request, HttpServletResponse response)
  throws IOException, ServletException{
    this.doPost(request, response);
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");

    UserDAO ud=new UserDAO();
    String mail = request.getParameter("mail");
    String pass = request.getParameter("pass");
    int count = pass.length();

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>会員情報</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<form id='gamenjump' method='post'></form>");
    out.println("<p>メールアドレス　　　　<button type='submit' name='johochange' form='gamenjump' formaction='MailChange'>変更</button></p>");
    out.println("<u>"+mail+"</u>"); //下線
    out.println("<p>パスワード　　　　　　<button type='submit' name='johochange' form='gamenjump' formaction='PassChange'>変更</button></p>");
    out.println("<input type='hidden' form='gamenjump' formaction='MailChange' name=mail value="+mail+">");
    out.println("<input type='hidden' form='gamenjump' formaction='MailChange' name=passward value="+pass+">");
    out.println("<input type='hidden' form='gamenjump' formaction='PassChange' name=mail value="+mail+">");
    out.println("<input type='hidden' form='gamenjump' formaction='PassChange' name=passward value="+pass+">");
    out.println("<u>");
    for(int i=0;i<count;i++){
      out.println("*");
    }
    out.println("</u>"); //下線
    out.println("<p><button type='submit' formaction='Test.html'>ログアウト</button></p>");
    out.println("</body></html>");
  }
}
