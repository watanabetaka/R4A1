package dao;

//ユーザーbeanを呼び出す
import bean.Application_Coupon;
//sqlへ接続するためのインポート
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Application_CouponDAO extends DAO {
	// user_id をもとに Application_Coupon データベースから探索し、値を取得
	public int search(int user_id) throws Exception{
		int line=0;

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("select * from application_coupon where user_id = ?");
		st.setInt(1,user_id);
		ResultSet rs=st.executeQuery();

		while(rs.next()){
			line++;
		}

		st.close();
		con.close();

		return line;
	}

	public int insert(Application_Coupon application_coupon) throws Exception {
	  Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("insert into application_coupon values ( ? , ? , ? ,current_timestamp)");
		st.setInt(1,application_coupon.getUser_Id());
		st.setString(2,application_coupon.getCoupon_Name());
		st.setInt(3,application_coupon.getSightseeing_Id());

		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

}
