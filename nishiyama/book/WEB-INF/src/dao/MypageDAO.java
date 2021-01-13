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

  public String getmail(int user_id) //メールアドレス取得
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

  public String getpass(int user_id) //パスワード取得(使わない？)
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

  public boolean checkmail(String email)
  throws Exception{
    //入力されたメールアドレスが既に存在していないかどうかチェック
    //存在していればtrue,存在していなければfalseを返す
    boolean checkflag = false;

    Connection con=getConnection();
    PreparedStatement st;
    st=con.prepareStatement(
    "update  user set email = ? where email=? ");
    st.setString(1, email);
    st.setString(2, email);
    int line = st.executeUpdate();

    if(line > 0){
      checkflag = true;
    }
    st.close();
    con.close();
    return checkflag;
  }

  public boolean checkpass(String hashpass)
  throws Exception{
    //入力されたメールアドレスが既に存在していないかどうかチェック
    //存在していればtrue,存在していなければfalseを返す
    boolean checkflag = false;

    Connection con=getConnection();
    PreparedStatement st;
    st=con.prepareStatement(
    "update user set pass = ? where pass=? ");
    st.setString(1, hashpass);
    st.setString(2, hashpass);
    int line = st.executeUpdate();

    if(line > 0){
      checkflag = true;
    }
    st.close();
    con.close();
    return checkflag;
  }

  public boolean updatemail(String email,int user_id,String hashpass) //メールアドレス変更
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

  public boolean updatepass(String hashpass,int user_id) //パスワード変更
  throws Exception {
    //
    boolean passflag = false;

    Connection con=getConnection();
    PreparedStatement st;

    st=con.prepareStatement(
    "update user set pass = ? where user_id=?");
    st.setString(1, hashpass);
    st.setInt(2, user_id);
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
