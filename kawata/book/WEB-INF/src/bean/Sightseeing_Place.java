package bean;

public class Sightseeing_Place implements java.io.Serializable {

	private int sightseeing_id;
	private String sightseeing_name;
	private String  city_name;
	private String  genre_name;
	private String  picture_path;
	private String  postal_code;
	private String  street_adress;
	private String  phone_number;
	private String  business_hour;
	private String  nearest_station;
	private String  URL;

	// setterの開始

	public void setSightseeing_Id(int sightseeing_id) {
		this.sightseeing_id = sightseeing_id;
	}

	public void setSightseeing_Name(String sightseeing_name) {
		this.sightseeing_name = sightseeing_name;
	}

	public void setCity_Name(String city_name) {
		this.city_name = city_name;
	}

	public void setGenre_Name(String genre_name) {
		this.genre_name = genre_name;
	}

	public void setPicture_Path(String picture_path) {
		this.picture_path = picture_path;
	}

	public void setPostal_Code(String postal_code) {
		this.postal_code = postal_code;
	}

	public void setStreet_Adress(String street_adress) {
		this.street_adress = street_adress;
	}

	public void setPhone_Number(String phone_number) {
		this.phone_number = phone_number;
	}

	public void setBusiness_Hour(String business_hour) {
		this.business_hour = business_hour;
	}

	public void setNearest_Station(String nearest_station) {
		this.nearest_station = nearest_station;
	}

	public void setUrl(String URL) {
		this.URL = URL;
	}

	// getterの開始

	public int getSightseeing_Id() {
		return sightseeing_id;
	}

	public String getSightseeing_Name() {
		return sightseeing_name;
	}

	public String getCity_Name() {
		return city_name;
	}

	public String getGenre_Name() {
		return genre_name;
	}

	public String getPicture_Path() {
		return picture_path;
	}

	public String getPostal_Code() {
		return postal_code;
	}

	public String getStreet_Adress() {
		return street_adress;
	}

	public String getPhone_Number() {
		return phone_number;
	}

	public String getBusiness_Hour() {
		return business_hour;
	}

	public String getNearest_Station() {
		return nearest_station;
	}

	public String getUrl() {
		return URL;
	}

}
