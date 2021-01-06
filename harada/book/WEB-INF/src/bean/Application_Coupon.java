package bean;

import java.util.Date;

public class Application_Coupon implements java.io.Serializable {

	private int user_id;
  private String coupon_name;
	private int sightseeing_id;
  private Date application_day;

	// セッターの開始

	public void setUser_Id(int user_id) {
		this.user_id = user_id;
	}

	public void setCoupon_Name(String coupon_name){
      this.coupon_name=coupon_name;
  }

	public void setSightseeing_Id(int sightseeing_id) {
		this.sightseeing_id = sightseeing_id;
	}

  public void setApplication_Day(Date application_day){
      this.application_day=application_day;
  }

	// ゲッターの開始

	public int getUser_Id() {
		return user_id;
	}

	public String getCoupon_Name(){
    return coupon_name;
  }

	public int getSightseeing_Id() {
		return sightseeing_id;
	}

  public Date getApplication_Day(){
    return application_day;
  }

}
