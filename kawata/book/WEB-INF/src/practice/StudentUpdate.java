package practice;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(urlPatterns={"/practice/studentUpdate"})
public class StudentUpdate extends HttpServlet {
	public void doPost (
		HttpServletRequest request,HttpServletResponse response
	) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		page.header(out);
		
		try{
			Initialtext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();
			
			String name = request.getParameter("name");
			int studentId =Integer.parseInt(request.getParameter("studentId")

		PreparedStatement st=con.prepareStatement(
			"UPDATE STUDENT SET NAME=? WHERE STUDENTID=?");
		st.setString(1,name);
		st.setInt(2,tudentId);
		
		int line = st.executeUpdate();
		
		
		if(line > 0){
			out.println("更新に成功しました");
			}else{
				out.println("学籍番号が誤っています");
				}
				

			
		st.close();
		con.close();
		} catch (Exception e){
			e.printStackTrace(out);
			}
			
		
			
			
			
		Page.footer(out);
	}
}