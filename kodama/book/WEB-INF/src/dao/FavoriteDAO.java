package dao;

//sqlへ接続するためのインポート
import bean.Favorite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


// favoriteデータベースに挿入する
public class FavoriteDAO extends DAO {


	// sightseeing_id , user_id をもとに favorite データベースから探索し、値を取得
	public void search(int user_id , int sightseeing_id) throws Exception {
	  Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("select * from favorite where sightseeing_id = ? and user_id = ?");
		st.setInt(1,sightseeing_id);
		st.setInt(2,user_id);

		st.executeUpdate();

		st.close();
		con.close();
	}

	// sightseeing_id , user_id を favorite データベースへ挿入
	public void insert(Favorite favorite) throws Exception {
	  Connection con=getConnection();


		PreparedStatement st=con.prepareStatement("insert into favorite values (?,?)");
		st.setInt(1,favorite.getSightseeing_Id());
		st.setInt(2,favorite.getUser_Id());

		st.executeUpdate();

		st.close();
		con.close();
	}

}
