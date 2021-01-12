package dao;

//sqlへ接続するためのインポート
import bean.Genre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


// cityデータベースに挿入する
public class GenreDAO extends DAO {


	// sightseeing_id , user_id をもとに favorite データベースから探索し、値を取得
	public List<Genre> search() throws Exception {
			List<Genre> list=new ArrayList<>();
	  Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("select * from genre ");

		// 取得した値をrsに挿入
		ResultSet rs=st.executeQuery();

		// beanに取得した値をセット
		while (rs.next()) {
			Genre g=new Genre();
			g.setGenre_Id(rs.getInt("genre_id"));
			g.setGenre_Name(rs.getString("genre_name"));
			list.add(g);
		}

		// データベースへの接続を終了
		st.close();
		con.close();

		// 取得した値を返却
		return list;
	}


}
