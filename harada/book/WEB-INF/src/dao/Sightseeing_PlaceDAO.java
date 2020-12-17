package dao;

//beanを呼び出すためのインポート
import bean.Sightseeing_Place;
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class Sightseeing_PlaceDAO extends DAO {

	// データベースより値を取得するメソッド
		public List<Sightseeing_Place> search(int user_id) throws Exception {
			List<Sightseeing_Place> list=new ArrayList<>();

			// データベースとの接続
		  Connection con=getConnection();

			// favoriteデータベースより、user_idをもとに、sightseeing_idを取得し、
			// そのsightseeing_idが存在しないsightseeing_placeデータベースの行を取得
			PreparedStatement st=con.prepareStatement("SELECT s.sightseeing_id , s.sightseeing_name, c.city_name , s.picture_path FROM sightseeing_place as s join city as c on s.city_id = c.city_id where s.sightseeing_id NOT IN (select sightseeing_id from favorite where user_id = ?)");

			// user_idをSQL文にセット
			st.setInt(1,user_id);

			// 取得した値をrsに挿入
			ResultSet rs=st.executeQuery();

			// beanに取得した値をセット
			while (rs.next()) {
				Sightseeing_Place s=new Sightseeing_Place();
				s.setSightseeing_Id(rs.getInt("sightseeing_id"));
				s.setSightseeing_Name(rs.getString("sightseeing_name"));
				s.setCity_Name(rs.getString("city_name"));
				s.setPicture_Path(rs.getString("picture_path"));
				list.add(s);
			}

			// データベースへの接続を終了
			st.close();
			con.close();

			// 取得した値を返却
			return list;
		}

}
