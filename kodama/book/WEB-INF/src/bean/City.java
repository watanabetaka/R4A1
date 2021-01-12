package bean;

public class City implements java.io.Serializable {

	private int city_id;
	private String city_name;

	public void setCity_Id(int city_id) {
		this.city_id = city_id;
	}

	public void setCity_Name(String city_name) {
		this.city_name = city_name;
	}


	public int getCity_Id() {
		return city_id;
	}

	public String getCity_Name() {
		return city_name;
	}
}
