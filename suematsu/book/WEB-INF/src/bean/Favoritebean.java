package bean;
import java.io.Serializable;
import dao.*;

public class Favoritebean implements java.io.Serializable {

  private String picture_path;
  private String sightseeing_name;
  private int user_id;

  public Favoritebean(){

  }

  public Favoritebean(String picture_path, String sightseeing_name) {
       this.picture_path = picture_path;
       this.sightseeing_name = sightseeing_name;
  }
  public String getPicture_path(){
    return picture_path;
  }
  public String getSightseeing_name(){
    return sightseeing_name;
  }
  public int getUser_id(){
    return user_id;
  }
  public void setPicture_path(String picture_path){
      this.picture_path=picture_path;
  }
  public void setSightseeing_name(String sightseeing_name){
      this.sightseeing_name=sightseeing_name;
  }
  public void setUser_id(int user_id){
      this.user_id=user_id;
  }
}
