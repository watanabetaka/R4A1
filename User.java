package bean;

public class User implements java.io.Serializable {

	private String user_id;
	 	private String  pass;

	public String getuser_ID() {
		return user_id;
	}

	public String getpass() {
		return pass;
	}




	public void setuser_ID(String user_id) {
		this.user_id = user_id;
	}

	public void setpass(String pass) {
		this.pass = pass;
	}


}
