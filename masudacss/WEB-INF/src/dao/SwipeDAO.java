package dao;

//ユーザーbeanを呼び出す
import bean.Swipe;
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SwipeDAO extends DAO {
						/*入力されたユーザーIDとパスワードがデータベースにあるも
						のと一致しているか確認する*/
		public User search(String email, String pass)
	 	throws Exception {
				User user=null;

			  Connection con=getConnection();


		PreparedStatement st;
		st=con.prepareStatement(
			"select * from user where email=? and pass=?");
		st.setString(1, email);
		st.setString(2, pass);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			user =new User();
			user.setEmail(rs.getString("email"));
			user.setPass(rs.getString("pass"));
		}

		st.close();
		con.close();
		return user;
	}
	public User insert(String user_id, String pass)
	throws Exception {
			User user=null;

			Connection con=getConnection();

			PreparedStatement st;
			st=con.prepareStatement(
				"insert into  user values(?,?,?)");
			st.setString(1, user_id);
			st.setString(2, pass);
			st.setString(3, "1");
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				user =new User();
				user.setEmail(rs.getString("user_id"));
				user.setPass(rs.getString("pass"));
			}

			st.close();
			con.close();
			return user;
	}
}
