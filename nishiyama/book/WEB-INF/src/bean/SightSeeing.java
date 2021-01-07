package bean;

public class SightSeeing implements java.io.Serializable {

	private String sightseeing_name;
	private int  city_id;
	private String  picture_path;

	public void setSightSeeing_Name(String sightseeing_name) {
		this.sightseeing_name = sightseeing_name;
	}

	public void setCity_Id(int city_id) {
		this.city_id = city_id;
	}

	public void setPicture_Path(String picture_path) {
		this.picture_path = picture_path;
	}


	public String getSightSeeing_Name() {
		return sightseeing_name;
	}

	public int getCity_Id() {
		return city_id;
	}

	public String getPicture_Path() {
		return picture_path;
	}

}
