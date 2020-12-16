package practice;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/practice/selection"})
public class Practice11 extends HttpServlet {

	public void doPost (
			HttpServletRequest request,HttpServletResponse response
		) throws ServletException, IOException{ 
		response.setContentType("text/html; charset=UTF-8");
		//リクエストからストーリーの値を取り出して、
		//それにより３つのJSPページへ分岐する
		String story = request.getParameter("story");
		if(story.equals("momo")){
			request.getRequestDispatcher("practice11_1.jsp").forward(request,response);
		}else if(story.equals("ura")){
			request.getRequestDispatcher("practice11_2.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("practice11_3.jsp").include(request,response);
			request.getRequestDispatcher("../footer.jsp").include(request,response);
		}
	}
}
			
			
		