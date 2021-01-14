package bean;

import java.util.Date;

public class Get_Coupon implements java.io.Serializable {

  private int user_id;
	private String sightseeing_name;
	private String coupon_name;

    // セッターの開始

      public void setUser_Id(int user_id){
      this.user_id = user_id;
    }

		public void setSightseeing_Name(String sightseeing_name){
	      this.sightseeing_name = sightseeing_name;
	  }

		public void setCoupon_Name(String coupon_name){
	      this.coupon_name = coupon_name;
	  }

// ゲッターの開始

		public int getUser_Id(){
			return user_id;
		}

		public String getSightseeing_Name(){
			return sightseeing_name;
		}

		public String getCoupon_Name(){
			return coupon_name;
		}
}
