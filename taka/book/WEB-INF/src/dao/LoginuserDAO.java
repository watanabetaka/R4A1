package dao;

//ユーザーbeanを呼び出す
import bean.User;
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginuserDAO extends DAO {
						/*入力されたユーザーIDとパスワードがデータベースにあるも
						のと一致しているか確認する*/
		public User search(String email, String hashpass)
	 	throws Exception {
				User user=null;

			  Connection con=getConnection();


		PreparedStatement st;
		st=con.prepareStatement(
			"select * from user where email=? and pass=? ");
		st.setString(1, email);
		st.setString(2, hashpass);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			user =new User();
			user.setUser_id(rs.getInt("user_id"));
		}

		st.close();
		con.close();
		return user;
	}
}
