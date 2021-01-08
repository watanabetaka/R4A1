package bean;

public class Coupon implements java.io.Serializable {
	private String picture_path;
  private String sightseeing_name;
  private String coupon_name;
	private String get_coupon_etime;

	public String getPicture_path() {
		return picture_path;
	}
	public void setPicture_path(String picture_path) {
		this.picture_path = picture_path;
	}

	public String getSightseeing_name() {
		return sightseeing_name;
	}
	public void setSightseeing_name(String sightseeing_name) {
		this.sightseeing_name = sightseeing_name;
	}

	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public String getGet_coupon_etime() {
		return get_coupon_etime;
	}
	public void setGet_coupon_etime(String get_coupon_etime) {
		this.get_coupon_etime = get_coupon_etime;
	}

}
