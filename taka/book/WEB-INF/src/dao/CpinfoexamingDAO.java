package dao;

//新規会員登録の際に参照するDAO
//ユーザーbeanを呼び出す
import bean.User;
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CpinfoexamingDAO extends DAO {
//企業が企業情報登録ボタンを押した場合に、ユーザIDが一時企業情報にあるか検索するためのdao
public boolean user_idsearch (int user_id)
throws Exception {
		Connection con=getConnection();
		//ユーザIDが存在すればtrueが、存在しなければfalseが
		boolean updateflag = false;

		PreparedStatement st;
		st=con.prepareStatement(
	    "update  TEMP_SIGHTSEEING_PLACE set user_id=? where user_id=?");
    st.setInt(1, user_id);
		st.setInt(2, user_id);
		int line = st.executeUpdate();

		if(line > 0){
			updateflag = true;
		}

st.close();
con.close();
return updateflag;
}
}
