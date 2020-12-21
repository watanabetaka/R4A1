package bean;

public class User implements java.io.Serializable {

	private String user_id;
	 	private String  pass;

	public String getuser_Id() {
		return user_id;
	}

	public String getPass() {
		return pass;
	}




	public void setuser_Id(String user_id) {
		this.user_id = user_id;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


}
