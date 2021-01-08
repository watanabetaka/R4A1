package dao;

import bean.CouponBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class CouponDAO extends DAO {

	public List<CouponBean> search(int keyword) throws Exception { //サーチ　はセッションID
		List<CouponBean> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("SELECT picture_path,sightseeing_name,coupon_name,get_coupon_etime FROM get_coupon as a JOIN coupon as b ON a.coupon_id = b.coupon_id JOIN sightseeing_place as c ON a.sightseeing_id = c.sightseeing_id where a.user_id = ?");
		st.setInt(1,keyword);

		ResultSet rs=st.executeQuery(); //データベースから取得
		while (rs.next()) {
			CouponBean p = new CouponBean();
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
