package dao;

import bean.Coupon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class CouponDAO extends DAO {

	// 取得可能な値をデータベースから取得
	public List<Coupon> search(int user_id) throws Exception {
		List<Coupon> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("SELECT g.get_coupon_id , c.coupon_id , s.picture_path , s.sightseeing_name , c.coupon_name , g.get_coupon_etime FROM get_coupon as g JOIN coupon as c ON g.coupon_id = c.coupon_id JOIN sightseeing_place as s ON c.sightseeing_id = s.sightseeing_id where g.user_id = ? and g.get_coupon_etime is null or g.get_coupon_etime > current_timestamp ; delete from get_coupon as g where g.get_coupon_etime < current_timestamp ;");
		st.setInt(1,user_id);

		ResultSet rs=st.executeQuery(); //データベースから取得
		while (rs.next()) {
			Coupon p = new Coupon();
			p.setGet_coupon_id(rs.getInt("get_coupon_id"));
			p.setCoupon_id(rs.getInt("coupon_id"));
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

	// sightseeing_id , user_id を favorite データベースへ挿入
	public void update(int get_coupon_id) throws Exception {
	  Connection con=getConnection();


		PreparedStatement st=con.prepareStatement("update get_coupon set  get_coupon_stime = current_timestamp , get_coupon_etime = dateadd(minute, 30, current_timestamp) where get_coupon_id = ? ; delete from get_coupon as g where g.get_coupon_etime < current_timestamp ; ");
		st.setInt(1,get_coupon_id);

		st.executeUpdate();

		st.close();
		con.close();
	}

}
