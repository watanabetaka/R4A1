package practice;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/practice/selection"})
public class practice11 extends HttpServlet {


	public void doPost (
		HttpServletRequest request,HttpServletResponse response
	) throws ServletException, IOException{


		response.setContentType("text/html; charset=UTF-8");
		String ryouri=request.getParameter("ryouri");
		if(ryouri.equals("niku")){
			request.getRequestDispatcher("practice11_1.jsp").forward(request,response);
		}else if(ryouri.equals("sakana")){
			request.getRequestDispatcher("practice11_2.jsp").forward(request,response);
		}else if(ryouri.equals("yasai")){
			request.getRequestDispatcher("practice11_3.jsp").include(request,response);
			request.getRequestDispatcher("../footer.jsp").include(request,response);
		} 
		}
	}