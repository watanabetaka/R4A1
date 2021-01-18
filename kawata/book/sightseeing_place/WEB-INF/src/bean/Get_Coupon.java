package bean;

public class Get_Coupon implements java.io.Serializable {

  private int random_id;
	private int coupon_id;
  private int user_id;

    // セッターの開始

    public void random_Id(int random_id) {
      this.random_id = random_id;
    }

    public void coupon_Id(int coupon_id) {
      this.coupon_id = coupon_id;
    }

    public void user_Id(int user_id){
      this.user_id = user_id;
    }

    // ゲッターの開始

	  public int getRandom_Id() {
		    return random_id;
	  }

	  public int Coupon_Id() {
		    return coupon_id;
	  }

	  public int User_Id(){
        return user_id;
    }
}
