package dao;

import bean.Get_Coupon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class Get_CouponDAO extends DAO {


  // 1~3の乱数が格納されているrandom変数をもとに coupon データベースから探索し、coupon_idを取得
  public void search(int random_id) throws Exception {
    Connection con=getConnection();

    PreparedStatement st=con.prepareStatement("select coupon_id from coupon where coupon_id = ?");
    st.setInt(1,random_id);

    st.executeUpdate();

    st.close();
    con.close();
  }

  //  coupon_id , user_id を get_coupon データベースへ挿入
  public void insert(int user_id,int random_id) throws Exception {
    Connection con=getConnection();

    PreparedStatement st=con.prepareStatement("insert into get_coupon (coupon_id,user_id) values (?,?)");
    st.setInt(1,random_id);
    st.setInt(2,user_id);

    st.executeUpdate();

    st.close();
    con.close();
  }
}
