package bean;

public class Favorite implements java.io.Serializable {

	private int user_id;
	private int sightseeing_id;
  private String picture_path;
  private String sightseeing_name;

	// セッターの開始

	public void setUser_Id(int user_id) {
		this.user_id = user_id;
	}

	public void setSightseeing_Id(int sightseeing_id) {
		this.sightseeing_id = sightseeing_id;
	}

	public void setPicture_Path(String picture_path){
      this.picture_path=picture_path;
  }

  public void setSightseeing_Name(String sightseeing_name){
      this.sightseeing_name=sightseeing_name;
  }

	// ゲッターの開始

	public int getUser_Id() {
		return user_id;
	}

	public int getSightseeing_Id() {
		return sightseeing_id;
	}

	public String getPicture_Path(){
    return picture_path;
  }

  public String getSightseeing_Name(){
    return sightseeing_name;
  }

}
