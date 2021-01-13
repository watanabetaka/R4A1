package dao;

//ユーザ種別を取得する際に参照するDAO
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CookiejudgeDAO extends DAO {

  //ユーザIDを検索するためのメソッド
  public int searchuserkind_id(int user_id)
  throws Exception {
  		int userkind_id=0;

  		Connection con=getConnection();

  		PreparedStatement st;
  		st=con.prepareStatement(
      "select * from user where user_id=?");
      st.setInt(1, user_id);
  		ResultSet rs=st.executeQuery();

  		while (rs.next()) {
  			 userkind_id = rs.getInt("userkind_id");
  		}

  st.close();
  con.close();
  return userkind_id;
  }  
  }
