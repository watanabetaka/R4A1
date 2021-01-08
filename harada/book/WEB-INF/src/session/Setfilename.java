package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class Setfilename{

  public static String getFileName(Part part) {
    //初期化
    String name = "";
     for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
         if (dispotion.trim().startsWith("filename")) {
             name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
             name = name.substring(name.lastIndexOf("\\") + 1);
             break;
         }
     }
     return name;
   }
}
