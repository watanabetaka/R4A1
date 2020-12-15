package dao;

import dao.DAO;
import bean.Cinama;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class CinamaDAO extends DAO {
	
	public List<Cinama> hyouzi() throws Exception {
		List<Cinama> list = new ArrayList<>();

		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
		  "SELECT * FROM CINAMA");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()){
		Cinama c =new Cinama();
		c.setMovieid(rs.getString("id"));
		c.setMoviename(rs.getString("name"));
		c.setMoviecount(rs.getInt("count"));
		c.setMovieimage(rs.getString("image"));
		list.add(c);
	        }

	st.close();
	con.close();

	return list;
}
public int Update(String a,int b) throws Exception{
	Cinama c =new Cinama();

	c.setMovieid(a);
	c.setMoviecount(--b);
	Connection con = getConnection();
		
	PreparedStatement st = con.prepareStatement(
	"UPDATE CINAMA SET COUNT=? WHERE ID = ?");

	st.setInt(1,c.getMoviecount());
	st.setString(2,c.getMovieid());
	int line=st.executeUpdate();

	st.close();
	con.close();

	return line;
	
	}
}
	