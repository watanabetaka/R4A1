package dao;

//ユーザーbeanを呼び出す
import bean.Loginuser;
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginuserDAO extends DAO {
						/*入力されたユーザーIDとパスワードがデータベースにあるも
						のと一致しているか確認する*/
		public Loginuser search(String email, String hashpass)
	 	throws Exception {
				Loginuser user=null;

			  Connection con=getConnection();


		PreparedStatement st;
		st=con.prepareStatement(
			"select * from user where email=? and pass=? ");
		st.setString(1, email);
		st.setString(2, hashpass);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			user =new Loginuser();
			user.setUser_id(rs.getInt("user_id"));
			user.setUserkind_id(rs.getInt("userkind_id"));
		}

		st.close();
		con.close();
		return user;
	}
}
