package bean;

public class User implements java.io.Serializable {

	private String email;
	 	private String  pass;
		private int user_id;

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}

	public int getUser_id() {
 	 return user_id;
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

}
