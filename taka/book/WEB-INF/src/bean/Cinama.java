package bean;

public class Cinama implements java.io.Serializable {

	private String movieid;
	private String moviename,movieimage;
	private int count;

	public String getMovieid() {
		return movieid;
	}

	public String getMoviename() {
		return moviename;
	}

	public int getMoviecount() {
		return count;
	}

	public String getMovieimage() {
		return movieimage;
	}

        

	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public void setMoviecount(int count) {
		this. count =  count;
	}

	public void setMovieimage(String movieimage) {
		this.movieimage = movieimage;
	}

}