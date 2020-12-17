package bean;

public class Favorite implements java.io.Serializable {

	private int user_id;
	private int sightseeing_id;

	public void setUser_Id(int user_id) {
		this.user_id = user_id;
	}

	public void setSightseeing_Id(int sightseeing_id) {
		this.sightseeing_id = sightseeing_id;
	}

	public int getUser_Id() {
		return user_id;
	}

	public int getSightseeing_Id() {
		return sightseeing_id;
	}


}
