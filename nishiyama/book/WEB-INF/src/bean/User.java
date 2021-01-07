package bean;

public class User implements java.io.Serializable {

	private String user_id;
	 	private String  pass;
		private String email;

	public String getuser_Id() {
		return user_id;
	}

	public String getemail() {
		return email;
	}

	public String getPass() {
		return pass;
	}


	public void setuser_Id(String user_id) {
		this.user_id = user_id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


}
