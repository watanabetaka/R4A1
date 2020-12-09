package dao;

//ユーザーbeanを呼び出す
import bean.User;
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DAO {
						/*入力されたユーザーIDとパスワードがデータベースにあるも
						のと一致しているか確認する*/
		public User search(String user_id, String pass)
	 	throws Exception {
				User user=null;

			  Connection con=getConnection();


		PreparedStatement st;
		st=con.prepareStatement(
			"select * from user where user_id=? and pass=?");
		st.setString(1, user_id);
		st.setString(2, pass);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			user =new User();
			user.setuser_Id(rs.getString("user_id"));
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
				user.setuser_Id(rs.getString("user_id"));
				user.setPass(rs.getString("pass"));
			}

			st.close();
			con.close();
			return user;
	}
}
