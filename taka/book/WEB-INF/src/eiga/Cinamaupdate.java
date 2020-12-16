package chapter15;

import tool.Page;
import bean.Cinama;
import dao.CinamaDAO;
import eiga.Cinamadata;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(urlPatterns={"/eiga/cinamaupdate"})
public class Cinamaupdate extends HttpServlet {
	
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);

		String hoge2;
		try {
			Cinama rs =new Cinama();
			Cinamadata d = new Cinamadata();
			hoge2 = request.getParameter("payment");
			rs.setMovieid(hoge2);
			CinamaDAO dao = new CinamaDAO();
			List<Cinama> list=dao.hyouzi();
		for(Cinama  c : list){
			if(hoge2.equals(c.getMovieid())){
				if(dao.Update(c.getMovieid(),c.getMoviecount()) > 0 ){
					out.println("予約しました。");
				}
					
			}
		}
				

		} catch(Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}