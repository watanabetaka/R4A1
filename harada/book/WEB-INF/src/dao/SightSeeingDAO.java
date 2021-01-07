package dao;

//ユーザーbeanを呼び出す
import bean.SightSeeing;
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class SightSeeingDAO extends DAO {
						/*入力されたユーザーIDとパスワードがデータベースにあるも
						のと一致しているか確認する*/
		public List<SightSeeing> search() throws Exception {
			List<SightSeeing> list=new ArrayList<>();

		  Connection con=getConnection();


			PreparedStatement st=con.prepareStatement("select * from sightseeing_place");
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				SightSeeing s=new SightSeeing();
				s.setSightSeeing_Name(rs.getString("sightseeing_name"));
				s.setCity_Id(rs.getInt("city_id"));
				s.setPicture_Path(rs.getString("picture_path"));
				list.add(s);
			}

			st.close();
			con.close();
			return list;
		}

	// public User insert(String user_id, String pass) throws Exception {
	// 		User user=null;
	//
	// 		Connection con=getConnection();
	//
	// 		PreparedStatement st;
	// 		st=con.prepareStatement(
	// 			"insert into  user values(?,?,?)");
	// 		st.setString(1, user_id);
	// 		st.setString(2, pass);
	// 		st.setString(3, "1");
	// 		ResultSet rs=st.executeQuery();
	//
	// 		while (rs.next()) {
	// 			user =new User();
	// 			user.setEmail(rs.getString("user_id"));
	// 			user.setPass(rs.getString("pass"));
	// 		}
	//
	// 		st.close();
	// 		con.close();
	// 		return user;
	// }
}
