package chapter14;

import bean.Student;
import dao.StudentDAO;
import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;


@WebServlet(urlPatterns={"/practice/studentUpdate"})
public class StudentUpdate extends HttpServlet {
	public void doPost (
			HttpServletRequest request,HttpServletResponse response
		) throws ServletException, IOException{ 
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		Page.header(out);

		try{
			StudentDAO dao = new StudentDAO();

			Student gakusei = new Student();
			gakusei.setName(request.getParameter("name"));
			gakusei.setStudentId(Integer.parseInt(request.getParameter("studentid")));

			
			int line = dao.update(gakusei);

			if (line>0) {
				out.println("追加に成功しました");
			}else{
				out.println("学籍番号が誤っている可能性があります。");
			}


			
		}catch (Exception e){
			e.printStackTrace(out);
		}
		Page.footer(out);

	}
}
			
			
		