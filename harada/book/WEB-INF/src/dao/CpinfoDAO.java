package dao;

//ユーザーbeanを呼び出す
import bean.User;
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CpinfoDAO extends DAO {
			// ユーザが入力した観光地名が既にないか確認するメソッド
			public boolean sightnamesearch(String sightname)
		  throws Exception {
							//  入力された観光地名が存在しているか判断する変数
							// 	falseなら存在しない、trueなら存在していると返す
								boolean searchflag = false;

								Connection con=getConnection();

								PreparedStatement st;
								st=con.prepareStatement(
								"update  sightseeing_place set sightseeing_name = ? where sightseeing_name = ? ");
								st.setString(1, sightname);
								st.setString(2, sightname);
								int line = st.executeUpdate();
								//更新された行があるか判断している
								if(line > 0){
									searchflag = true;
								}

						st.close();
						con.close();
						return searchflag;
					}
		public boolean cpinfoinsert(int user_id,String sightname,int city_id,int genre_id,String picture_path,String postal_code,String street_address,String phone_number,String business_hour,String nearest_station,String rank,String bookurl)
	 	throws Exception {
				boolean insertflag =false;

			  Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
			"insert into TEMP_SIGHTSEEING_PLACE values (default,?, ?,?,?,?,?,?,?,?,?,?,?)");
		st.setInt(1, user_id);
		st.setString(2,sightname);
		st.setInt(3,city_id);
		st.setInt(4,genre_id);
		st.setString(5,picture_path);
		st.setString(6,postal_code);
		st.setString(7,street_address);
		st.setString(8,phone_number);
		st.setString(9,business_hour);
		st.setString(10,nearest_station);
		st.setString(11,rank);
		st.setString(12,bookurl);

		int line = st.executeUpdate();

		if(line > 0){
			insertflag = true;
		}

		st.close();
		con.close();
		return insertflag;
	}
}
