package ipadress;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

public class Ipadress {
	public String getIpadress( HttpServletRequest request,HttpServletResponse response){
		String ipadress = "192.168.68.103";
		// 設定したユーザIDを戻り値に返します
		return ipadress;
  }
}
