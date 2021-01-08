package dao;

import bean.Coupon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class CouponDAO extends DAO {

	public List<Coupon> search(int keyword) throws Exception { //サーチ　はセッションID
		List<Coupon> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("SELECT s.picture_path , s.sightseeing_name , c.coupon_name , g.get_coupon_etime FROM get_coupon as g JOIN coupon as c ON g.coupon_id = c.coupon_id JOIN sightseeing_place as s ON c.sightseeing_id = s.sightseeing_id where g.user_id = ?");
		st.setInt(1,keyword);

		ResultSet rs=st.executeQuery(); //データベースから取得
		while (rs.next()) {
			Coupon p = new Coupon();
			p.setPicture_path(rs.getString("picture_path"));
			p.setSightseeing_name(rs.getString("sightseeing_name"));
			p.setCoupon_name(rs.getString("coupon_name"));
      p.setGet_coupon_etime(rs.getString("get_coupon_etime"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}
}
//データベース検索
