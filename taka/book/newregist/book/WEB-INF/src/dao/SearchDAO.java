package dao;

import bean.Student;
import java.sql.*;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class SearchDAO extends DAO {
	
	public List<Student> Search(String name) throws Exception {
		List<Student> list = new ArrayList<>();

		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
		  "SELECT * FROM STUDENT WHERE NAME LIKE ?");
		
		st.setString(1,"%"+name+"%"); 
		ResultSet rs = st.executeQuery();
		
		while(rs.next()){
		Student s =new Student();
		s.setStudentId(rs.getInt("studentId"));
		s.setName(rs.getString("name"));
		s.setDepartment(rs.getString("department"));
		s.setBirthday(rs.getDate("birthday"));
		list.add(s);
	        }

	st.close();
	con.close();

	return list;
}
}
	