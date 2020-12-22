package bean;

import javax.servlet.http.*;

public class Hash extends org.apache.commons.codec.digest.DigestUtils {
	public String pass(String pass){
		String pass1 = DigestUtils.sha3_256Hex(pass);
		System.out.println("SHA3-256：" + pass1);
		return pass;
	}
}
