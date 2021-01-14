package dao;

//sqlへ接続するためのインポート
import bean.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


// cityデータベースに挿入する
public class CityDAO extends DAO {


	// sightseeing_id , user_id をもとに favorite データベースから探索し、値を取得
	public List<City> search() throws Exception {
			List<City> list=new ArrayList<>();
	  Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("select * from city ");

		// 取得した値をrsに挿入
		ResultSet rs=st.executeQuery();

		// beanに取得した値をセット
		while (rs.next()) {
			City c=new City();
			c.setCity_Id(rs.getInt("city_id"));
			c.setCity_Name(rs.getString("city_name"));
			list.add(c);
		}

		// データベースへの接続を終了
		st.close();
		con.close();

		// 取得した値を返却
		return list;
	}


}
