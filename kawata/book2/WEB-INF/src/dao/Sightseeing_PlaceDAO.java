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

	// sightseeing_id をもとに、観光地詳細画面にて表示する値を取得
	public List<Sightseeing_Place> detail_search(int sightseeing_id) throws Exception {
		List<Sightseeing_Place> list=new ArrayList<>();

		// データベースとの接続
		Connection con=getConnection();

		// favoriteデータベースより、sightseeing_idをもとに、観光地詳細画面にて必要な値を取得
		PreparedStatement st=con.prepareStatement("SELECT s.sightseeing_id , s.sightseeing_name, c.city_name ,  g.genre_name , s.picture_path , s.postal_code , s.street_adress , s.phone_number , s.business_hour , s.nearest_station , s.URL FROM sightseeing_place as s join city as c on s.city_id = c.city_id join genre as g on s.genre_id = g.genre_id where s.sightseeing_id = ? ;");

		// user_idをSQL文にセット
		st.setInt(1,sightseeing_id);

		// 取得した値をrsに挿入
		ResultSet rs=st.executeQuery();

		// beanに取得した値をセット
		while (rs.next()) {
			Sightseeing_Place s=new Sightseeing_Place();
			s.setSightseeing_Id(rs.getInt("sightseeing_id"));
			s.setSightseeing_Name(rs.getString("sightseeing_name"));
			s.setCity_Name(rs.getString("city_name"));
			s.setGenre_Name(rs.getString("genre_name"));
			s.setPicture_Path(rs.getString("picture_path"));;
			s.setPostal_Code(rs.getString("postal_code"));;
			s.setStreet_Adress(rs.getString("street_adress"));
			s.setPhone_Number(rs.getString("phone_number"));
			s.setBusiness_Hour(rs.getString("business_hour"));
			s.setNearest_Station(rs.getString("nearest_station"));
			s.setUrl(rs.getString("URL"));
			list.add(s);
		}

		// データベースへの接続を終了
		st.close();
		con.close();

		// 取得した値を返却
		return list;
	}

	// sightseeing_placeデータベースより、user_idをもとに、
	// sightseeing_id , sightseeing_name を取得するメソッド
	public List<Sightseeing_Place> search(int user_id,int dummy,int dummy1) throws Exception {
		List<Sightseeing_Place> list=new ArrayList<>();

		// データベースとの接続
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("SELECT sightseeing_id , sightseeing_name FROM sightseeing_place where user_id = ? ");

		// user_idをSQL文にセット
		st.setInt(1,user_id);

		// 取得した値をrsに挿入
		ResultSet rs=st.executeQuery();

		// beanに取得した値をセット
		while (rs.next()) {
			Sightseeing_Place s=new Sightseeing_Place();
			s.setSightseeing_Id(rs.getInt("sightseeing_id"));
			s.setSightseeing_Name(rs.getString("sightseeing_name"));
			list.add(s);
		}

		// データベースへの接続を終了
		st.close();
		con.close();

		// 取得した値を返却
		return list;
	}

		// データベースより、user_idをもとに
	 // 観光地ID、観光地名、市名、写真パス を取得するメソッド
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

		// データベースより、user_id , city_name をもとに
		// 観光地ID、観光地名、市名、写真パス を取得するメソッド
		public List<Sightseeing_Place> search(int user_id , String array_city[]) throws Exception {
			List<Sightseeing_Place> list=new ArrayList<>();

			// データベースとの接続
			Connection con=getConnection();

			// favoriteデータベースより、user_idをもとに、sightseeing_idを取得し、
			// そのsightseeing_idが存在しないsightseeing_placeデータベースの行を取得
			// その行から、取得した city_name と一致する行を取得
			PreparedStatement st=con.prepareStatement("SELECT s.sightseeing_id , s.sightseeing_name, c.city_name , s.picture_path FROM sightseeing_place as s join city as c on s.city_id = c.city_id where s.sightseeing_id NOT IN (select sightseeing_id from favorite where user_id = ?) and c.city_name = ? ");

			// 取得した市名配列の全ての行をループで取得
      for(String city_name:array_city){

				// user_id , city_name をSQL文にセット
				st.setInt(1,user_id);
				st.setString(2,city_name);

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
			}

			// データベースへの接続を終了
			st.close();
			con.close();

			// 取得した値を返却
			return list;
		}



		// データベースより、user_id , genre_name をもとに
	  // 観光地ID、観光地名、市名、写真パス を取得するメソッド
		public List<Sightseeing_Place> search(int user_id , String array_genre[] , int count) throws Exception {
			List<Sightseeing_Place> list=new ArrayList<>();

			// データベースとの接続
			Connection con=getConnection();

			// favoriteデータベースより、user_idをもとに、sightseeing_idを取得し、
			// そのsightseeing_idが存在しないsightseeing_placeデータベースの行を取得
			// その行から、取得した genre_name と一致する行を取得
			PreparedStatement st=con.prepareStatement("SELECT s.sightseeing_id , s.sightseeing_name, c.city_name , s.picture_path FROM sightseeing_place as s join city as c on s.city_id = c.city_id join genre as g on s.genre_id = g.genre_id where s.sightseeing_id NOT IN (select sightseeing_id from favorite where user_id = ?) and g.genre_name= ? ");

			// 取得したジャンル名配列の全ての行をループで取得
      for(String genre_name:array_genre){

				// user_id , genre_name をSQL文にセット
				st.setInt(1,user_id);
				st.setString(2,genre_name);

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
			}

			// データベースへの接続を終了
			st.close();
			con.close();

			// 取得した値を返却
			return list;
		}


		// データベースより、user_id , city_name , genre_name をもとに
	 	// 観光地ID、観光地名、市名、写真パス を取得するメソッド
		public List<Sightseeing_Place> search(int user_id , String array_city[] , String array_genre[]) throws Exception {
			List<Sightseeing_Place> list=new ArrayList<>();

			// データベースとの接続
			Connection con=getConnection();

			// favoriteデータベースより、user_idをもとに、sightseeing_idを取得
			// そのsightseeing_idが存在しないsightseeing_place , city , genreデータベースの行を取得
			// その行から、取得したcity_name と genre_name　の複合条件に一致した行を取得
			PreparedStatement st=con.prepareStatement("SELECT s.sightseeing_id , s.sightseeing_name, c.city_name , s.picture_path FROM sightseeing_place as s join city as c on s.city_id = c.city_id join genre as g on s.genre_id = g.genre_id where s.sightseeing_id NOT IN (select sightseeing_id from favorite where user_id = ?) and c.city_name= ? and g.genre_name= ? ");

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
						Sightseeing_Place s=new Sightseeing_Place();
						s.setSightseeing_Id(rs.getInt("sightseeing_id"));
						s.setSightseeing_Name(rs.getString("sightseeing_name"));
						s.setCity_Name(rs.getString("city_name"));
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
