package dao;

//sqlへ接続するためのインポート
import bean.Favorite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class FavoriteDAO extends DAO {


	// sightseeing_id , user_id をもとに favorite データベースから探索し、値を取得
	public void search(int user_id , int sightseeing_id) throws Exception {
	  Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("select * from favorite where sightseeing_id = ? and user_id = ? order by f.favorite_itime desc");
		st.setInt(1,sightseeing_id);
		st.setInt(2,user_id);

		st.executeUpdate();

		st.close();
		con.close();
	}

	// sightseeing_id , user_id を favorite データベースへ挿入
	public void insert(Favorite favorite) throws Exception {
	  Connection con=getConnection();


		PreparedStatement st=con.prepareStatement("insert into favorite values (?,?,current_timestamp)");
		st.setInt(1,favorite.getSightseeing_Id());
		st.setInt(2,favorite.getUser_Id());

		st.executeUpdate();

		st.close();
		con.close();
	}

	public List<Favorite> search(int user_id) throws Exception{
		List<Favorite> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select s.sightseeing_id , s.sightseeing_name , s.picture_path from sightseeing_place as s  join favorite as f  on s.sightseeing_id = f.sightseeing_id where f.user_id= ?　order by f.favorite_itime desc");
		st.setInt(1,user_id);
		ResultSet rs=st.executeQuery();

		while(rs.next()){
			Favorite f=new Favorite();
			f.setSightseeing_Id(rs.getInt("sightseeing_id"));
			f.setSightseeing_Name(rs.getString("sightseeing_name"));
			f.setPicture_Path(rs.getString("picture_path"));
			list.add(f);
		}

		st.close();
		con.close();

		return list;
	}


	public int delete(Favorite favorite) throws Exception {
	  Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("delete from favorite where sightseeing_id = ? and user_id  = ? ;");
		st.setInt(1,favorite.getSightseeing_Id());
		st.setInt(2,favorite.getUser_Id());

		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

	// データベースより、user_idをもとに
 // 観光地ID、観光地名、写真パス を取得するメソッド
	public List<Favorite> search(int user_id , String dummy) throws Exception {
		List<Favorite> list=new ArrayList<>();

		// データベースとの接続
		Connection con=getConnection();

		// favoriteデータベースより、user_idをもとに、sightseeing_idを取得し、
		// そのsightseeing_idが存在しないFavoriteデータベースの行を取得
		PreparedStatement st=con.prepareStatement("SELECT s.sightseeing_id , s.sightseeing_name, s.picture_path FROM sightseeing_place as s join city as c on s.city_id = c.city_id join genre as g on s.genre_id = g.genre_id join favorite as f on s.sightseeing_id = f.sightseeing_id WHERE f.user_id = ? order by f.favorite_itime desc ");

		// user_idをSQL文にセット
		st.setInt(1,user_id);

		// 取得した値をrsに挿入
		ResultSet rs=st.executeQuery();

		// beanに取得した値をセット
		while (rs.next()) {
			Favorite s=new Favorite();
			s.setSightseeing_Id(rs.getInt("sightseeing_id"));
			s.setSightseeing_Name(rs.getString("sightseeing_name"));
			s.setPicture_Path(rs.getString("picture_path"));
			list.add(s);
		}

		// データベースへの接続を終了
		st.close();
		con.close();

		// 取得した値を返却
		return list;
	}

	// データベースより、user_id , city_name をもとに
	// 観光地ID、観光地名、写真パス を取得するメソッド
	public List<Favorite> search(int user_id , String array_city[]) throws Exception {
		List<Favorite> list=new ArrayList<>();

		// データベースとの接続
		Connection con=getConnection();

		// favoriteデータベースより、user_idをもとに、sightseeing_idを取得し、
		// そのsightseeing_idが存在しないFavoriteデータベースの行を取得
		// その行から、取得した city_name と一致する行を取得
		PreparedStatement st=con.prepareStatement("SELECT s.sightseeing_id , s.sightseeing_name, s.picture_path FROM sightseeing_place as s join city as c on s.city_id = c.city_id join genre as g on s.genre_id = g.genre_id join favorite as f on s.sightseeing_id = f.sightseeing_id WHERE f.user_id = ? and c.city_name = ? order by f.favorite_itime desc ");

		// 取得した市名配列の全ての行をループで取得
		for(String city_name:array_city){

			// user_id , city_name をSQL文にセット
			st.setInt(1,user_id);
			st.setString(2,city_name);

			// 取得した値をrsに挿入
			ResultSet rs=st.executeQuery();

			// beanに取得した値をセット
			while (rs.next()) {
				Favorite s=new Favorite();
				s.setSightseeing_Id(rs.getInt("sightseeing_id"));
				s.setSightseeing_Name(rs.getString("sightseeing_name"));
				s.setPicture_Path(rs.getString("picture_path"));
				list.add(s);
			}
		}

		// データベースへの接続を終了
		st.close();
		con.close();

		// 取得した値を返却
		return list;
	}


	// データベースより、user_id , genre_name をもとに
	// 観光地ID、観光地名、写真パス を取得するメソッド
	public List<Favorite> search(int user_id , String array_genre[] , int dummy) throws Exception {
		List<Favorite> list=new ArrayList<>();

		// データベースとの接続
		Connection con=getConnection();

		// favoriteデータベースより、user_idをもとに、sightseeing_idを取得し、
		// そのsightseeing_idが存在しないFavoriteデータベースの行を取得
		// その行から、取得した genre_name と一致する行を取得
		PreparedStatement st=con.prepareStatement("SELECT s.sightseeing_id , s.sightseeing_name, s.picture_path FROM sightseeing_place as s join city as c on s.city_id = c.city_id join genre as g on s.genre_id = g.genre_id join favorite as f on s.sightseeing_id = f.sightseeing_id WHERE f.user_id = ? and g.genre_name= ? order by f.favorite_itime desc");

		// 取得したジャンル名配列の全ての行をループで取得
		for(String genre_name:array_genre){

			// user_id , genre_name をSQL文にセット
			st.setInt(1,user_id);
			st.setString(2,genre_name);

			// 取得した値をrsに挿入
			ResultSet rs=st.executeQuery();

			// beanに取得した値をセット
			while (rs.next()) {
				Favorite s=new Favorite();
				s.setSightseeing_Id(rs.getInt("sightseeing_id"));
				s.setSightseeing_Name(rs.getString("sightseeing_name"));
				s.setPicture_Path(rs.getString("picture_path"));
				list.add(s);
			}
		}

		// データベースへの接続を終了
		st.close();
		con.close();

		// 取得した値を返却
		return list;
	}


	// データベースより、user_id , city_name , genre_name をもとに
	// 観光地ID、観光地名、写真パス を取得するメソッド
	public List<Favorite> search(int user_id , String array_city[] , String array_genre[]) throws Exception {
		List<Favorite> list=new ArrayList<>();

		// データベースとの接続
		Connection con=getConnection();

		// favoriteデータベースより、user_idをもとに、sightseeing_idを取得
		// そのsightseeing_idが存在しないFavorite , city , genreデータベースの行を取得
		// その行から、取得したcity_name と genre_name　の複合条件に一致した行を取得
		PreparedStatement st=con.prepareStatement("SELECT s.sightseeing_id , s.sightseeing_name, s.picture_path FROM sightseeing_place as s join city as c on s.city_id = c.city_id join genre as g on s.genre_id = g.genre_id join favorite as f on s.sightseeing_id = f.sightseeing_id WHERE f.user_id = ? and c.city_name = ? and g.genre_name = ?　order by f.favorite_itime desc");

		// 取得した市名とジャンル名の複合条件を作成する処理
		// 取得した市名配列の全ての行をループで取得
		for(String city_name:array_city){

			// 取得したジャンル名配列の全ての行をループで取得
			for(String genre_name:array_genre){

				// user_id , city_name , genre_name をSQL文にセット
				st.setInt(1,user_id);
				st.setString(2,city_name);
				st.setString(3,genre_name);

				// 取得した値をrsに挿入
				ResultSet rs=st.executeQuery();

				// beanに取得した値をセット
				while (rs.next()) {
					Favorite s=new Favorite();
					s.setSightseeing_Id(rs.getInt("sightseeing_id"));
					s.setSightseeing_Name(rs.getString("sightseeing_name"));

					s.setPicture_Path(rs.getString("picture_path"));
					list.add(s);
				}
			}
		}

		// データベースへの接続を終了
		st.close();
		con.close();

		// 取得した値を返却
		return list;
	}


}
