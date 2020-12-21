package dao;

import bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class FavoriteDAO extends DAO {

  public List<Favoritebean> search(int Keyword) throws Exception{
    List<Favoritebean> list=new ArrayList<>();

    Connection con=getConnection();

    PreparedStatement st=con.prepareStatement(
      "SELECT PICTURE_PATH,SIGHTSEEING_NAME FROM sightseeing_place join favorite on sightseeing_place.sightseeing_id = favorite.sightseeing_id WHERE favorite.USER_ID = ?");
    st.setInt(1,Keyword);
    ResultSet rs=st.executeQuery();

    while(rs.next()){
      Favoritebean f=new Favoritebean();
      f.setPicture_path(rs.getString("picture_path"));
      f.setSightseeing_name(rs.getString("sightseeing_name"));
      list.add(f);
    }

		st.close();
		con.close();

		return list;
  }
}
