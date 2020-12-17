package bean;

public class Sightseeing_Place implements java.io.Serializable {

	private int sightseeing_id;
	private String sightseeing_name;
	private String  city_name;
	private String  picture_path;

	public void setSightseeing_Id(int sightseeing_id) {
		this.sightseeing_id = sightseeing_id;
	}

	public void setSightseeing_Name(String sightseeing_name) {
		this.sightseeing_name = sightseeing_name;
	}

	public void setCity_Name(String city_name) {
		this.city_name = city_name;
	}

	public void setPicture_Path(String picture_path) {
		this.picture_path = picture_path;
	}

	public int getSightseeing_Id() {
		return sightseeing_id;
	}

	public String getSightseeing_Name() {
		return sightseeing_name;
	}

	public String getCity_Name() {
		return city_name;
	}

	public String getPicture_Path() {
		return picture_path;
	}

}
