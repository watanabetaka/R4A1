package bean;

public class Genre implements java.io.Serializable {

	private int genre_id;
	private String genre_name;

	public void setGenre_Id(int genre_id) {
		this.genre_id = genre_id;
	}

	public void setGenre_Name(String genre_name) {
		this.genre_name = genre_name;
	}


	public int getGenre_Id() {
		return genre_id;
	}

	public String getGenre_Name() {
		return genre_name;
	}
}
