package bean;

import javax.servlet.http.*;

public class Loginuser implements java.io.Serializable {

	private String email;
	private String  pass;
  private int user_id;
	private int userkind_id;

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}

	public int getUser_id() {
 	 return user_id;
  }

	public int getUserkind_id() {
		return userkind_id;
	}





	public void setEmail(String email) {
		this.email = email;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setUser_id(int user_id) {
 	 this.user_id = user_id;
  }

	public void setUserkind_id(int userkind_id) {
		this.userkind_id = userkind_id;
	}

}
