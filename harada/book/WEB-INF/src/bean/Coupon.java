package bean;

public class Coupon implements java.io.Serializable {
	private int get_coupon_id;
	private int coupon_id;
	private String picture_path;
  private String sightseeing_name;
  private String coupon_name;
	private String get_coupon_etime;
	private String coupon_eday;

	// セッターの開始

	public void setGet_coupon_id(int get_coupon_id) {
		this.get_coupon_id = get_coupon_id;
	}

	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}

	public void setPicture_path(String picture_path) {
		this.picture_path = picture_path;
	}

	public void setSightseeing_name(String sightseeing_name) {
		this.sightseeing_name = sightseeing_name;
	}

	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public void setGet_coupon_etime(String get_coupon_etime) {
		this.get_coupon_etime = get_coupon_etime;
	}

	public void setCoupon_eday(String coupon_eday) {
		this.coupon_eday = coupon_eday;
	}
	// ゲッターの開始

	public int getGet_coupon_id() {
		return get_coupon_id;
	}

	public int getCoupon_id() {
		return coupon_id;
	}

	public String getPicture_path() {
		return picture_path;
	}

	public String getSightseeing_name() {
		return sightseeing_name;
	}

	public String getCoupon_name() {
		return coupon_name;
	}

	public String getGet_coupon_etime() {
		return get_coupon_etime;
	}

	public String getCoupon_eday() {
		return coupon_eday;
	}

}
