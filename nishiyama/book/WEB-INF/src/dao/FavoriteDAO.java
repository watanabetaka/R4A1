package dao;

//sqlへ接続するためのインポート
import bean.Favorite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class FavoriteDAO extends DAO {
	// favoriteデータベースに挿入する
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
