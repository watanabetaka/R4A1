package dao;

import bean.Get_Coupon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class Get_CouponDAO extends DAO {

  //対象の全クーポンIDを取得
  public void insert(Get_Coupon get_coupon) throws Exception {
    Connection con=getConnection();

    PreparedStatement st=con.prepareStatement("insert into get_coupon(coupon_id,user_id) SELECT coupon_id , ? as user_id FROM COUPON　where year(coupon_sday) = year(current_timestamp) and month(coupon_sday) = month (current_timestamp) order by rand() limit 1 ");
    st.setInt(1,get_coupon.getUser_Id());

    st.executeUpdate();

    st.close();
    con.close();
  }

  //取得したクーポンの内容とそのクーポンが利用できる観光地名を取得
  public List<Get_Coupon> search(int user_id) throws Exception {
    List<Get_Coupon> list=new ArrayList<>();

    // データベース接続
    Connection con=getConnection();

    // SQL文生成
    PreparedStatement st=con.prepareStatement("select get_coupon_id, sightseeing_name,coupon_name from get_coupon join coupon on get_coupon.coupon_id = coupon.coupon_id join sightseeing_place on sightseeing_place.sightseeing_id =coupon.sightseeing_id where get_coupon.user_id = ? order by get_coupon.get_coupon_id  desc limit 1");

    // coupon_idとuser_idをSQL文にセット
    st.setInt(1,user_id);

    // 取得した値をrsにセット
    ResultSet rs=st.executeQuery();

    // beanへ値をセット
    while(rs.next()){
			Get_Coupon c=new Get_Coupon();
			c.setCoupon_Name(rs.getString("coupon_name"));
      c.setSightseeing_Name(rs.getString("sightseeing_name"));
			list.add(c);
		}

    st.close();
    con.close();

    return list;

  }
}
