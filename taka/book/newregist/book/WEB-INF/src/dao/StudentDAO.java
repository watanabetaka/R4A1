package dao;

import bean.Student;
import java.sql.*;
import java.util.Date;

public class StudentDAO extends DAO {
	
	public Student search(int studentId) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
		  "SELECT * FROM STUDENT WHERE STUDENTID=?"
		);
		st.setInt(1, studentId);
		ResultSet rs = st.executeQuery();
		
		Student s = new Student();
		rs.next();
		s.setStudentId(rs.getInt("studentId"));
		s.setName(rs.getString("name"));
		s.setBirthday(rs.getDate("birthday"));
		
		return s;
	}
	
	
	public int update(Student student) throws Exception{
		Connection con = getConnection();
		
		Student s = search(student.getStudentId());
		
		if(student.getName() != null) {
			s.setName(student.getName());
		}
		if(student.getBirthday() != null) {
			s.setBirthday(student.getBirthday());
		}
		
		PreparedStatement st = con.prepareStatement(
		  "UPDATE STUDENT SET NAME=?,BIRTHDAY=? WHERE STUDENTID=?"
		);
		
		st.setString(1, s.getName());
		st.setDate(2, s.getBirthday());
		st.setInt(3, s.getStudentId());
		
		int result = st.executeUpdate();
		return result;
	}
}
		