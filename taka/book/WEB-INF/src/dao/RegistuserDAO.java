package dao;

//新規会員登録の際に参照するDAO
//ユーザーbeanを呼び出す
import bean.User;
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistuserDAO extends DAO {
						/*入力されたユーザーIDとパスワードがデータベースにあるも
						のと一致しているか確認する*/
		public boolean searchmail(String email)
	 	throws Exception {
			//  入力されたメールアドレスが存在しているか判断する変数
			// 	falseなら存在しない、trueなら存在していると返す
				boolean mailflag = false;

			  Connection con=getConnection();

				PreparedStatement st;
				st=con.prepareStatement(
				"update  user set email = ? where email=? ");
				st.setString(1, email);
				st.setString(2, email);
				int line = st.executeUpdate();

				if(line > 0){
					mailflag = true;
				}

		st.close();
		con.close();
		System.out.println(mailflag);
		return mailflag;
	}
	public int insert(String email,String hashpass)
	throws Exception {

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
		"insert into user values(default,?,1,true,?)");
		st.setString(1, hashpass);
		st.setString(2, email);
		//更新した行数が入る
		int line = st.executeUpdate();
		st.close();
		con.close();
		return line;
}
//ユーザIDを検索するためのメソッド
public int searchid(String email)
throws Exception {
		int user_id=0;

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
    "select * from user where email=?");
    st.setString(1, email);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			 user_id = rs.getInt("user_id");
		}

st.close();
con.close();
return user_id;
}
}
