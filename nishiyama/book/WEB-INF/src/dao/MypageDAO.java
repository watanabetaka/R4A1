package dao;

//会員情報変更の際に参照するDAO
//ユーザーbeanを呼び出す
import bean.User;
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MypageDAO extends DAO {
						/*メールアドレスおよびパスワードの更新を行う*/
public String getmail(int user_id)
throws Exception{
  String email="";

  Connection con=getConnection();
  PreparedStatement st;

  st=con.prepareStatement(
  "select * from user where user_id=?");
  st.setInt(1, user_id);
  ResultSet rs=st.executeQuery();

  while (rs.next()) {
     email = rs.getString("email");
  }
  st.close();
  con.close();
  return email;
}
public String getpass(int user_id)
throws Exception{
  String pass="";

  Connection con=getConnection();
  PreparedStatement st;

  st=con.prepareStatement(
  "select * from user where user_id=?");
  st.setInt(1, user_id);
  ResultSet rs=st.executeQuery();

  while (rs.next()) {
     pass = rs.getString("");
  }
  st.close();
  con.close();
  return pass;
}
    public boolean updatemail(String email,int user_id,String hashpass)
	 	throws Exception {
			//  入力されたメールアドレスを基に更新を行う
			// 	成功ならtrue,失敗ならfalseを返す
				boolean mailflag = false;

			  Connection con=getConnection();
				PreparedStatement st;
				st=con.prepareStatement(
				"update user set email = ? where user_id=? and pass=?");
				st.setString(1, email);
				st.setInt(2, user_id);
        st.setString(3, hashpass);
				int line = st.executeUpdate();

				if(line > 0){
					mailflag = true;
				}

        st.close();
        con.close();
        System.out.println(mailflag);
        return mailflag;
      }

      public void updatehash(String hashpass,int user_id)
  	 	throws Exception {
  			//  入力されたメールアドレスを基に更新を行う
  			// 	成功ならtrue,失敗ならfalseを返す
  				boolean mailflag = false;

  			  Connection con=getConnection();
  				PreparedStatement st;
  				st=con.prepareStatement(
  				"update user set pass = ? where user_id=?");
  				st.setString(1, hashpass);
  				st.setInt(2, user_id);
  				int line = st.executeUpdate();

  				if(line > 0){
  					mailflag = true;
  				}

          st.close();
          con.close();
        }

        public boolean updatepass(String pass,int user_id,String hashpass)
        throws Exception {
          //  入力されたパスワードを基に更新を行う
    			// 	成功ならtrue,失敗ならfalseを返す
            boolean passflag = false;

            Connection con=getConnection();

            PreparedStatement st;
            st=con.prepareStatement(
            "update  user set pass = ? where user_id=? and pass=?");
            st.setString(1, pass);
            st.setInt(2, user_id);
            st.setString(3, hashpass);
            int line = st.executeUpdate();

            if(line > 0){
              passflag = true;
            }
		st.close();
		con.close();
		System.out.println(passflag);
		return passflag;
	}
}
