package batch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import session.*;
import tool.*;
import java.io.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Locale;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import dao.CpinfoDAO;
import javax.servlet.http.Cookie;
import java.io.FilenameFilter;

public class ImageresizeAction extends Action {
  public String execute(
		HttpServletRequest request, HttpServletResponse response
	)  throws Exception{

    FilenameFilter filter = new FilenameFilter(){
        public boolean accept(File file, String str){

            //指定文字列でフィルタする
            if(str.equals("cupon.png")||str.equals("hito.png")||str.equals("home.png")||str.equals("okiniiri.png")) {
                return false;
            } else {
                return true;
            }
        }
    };
    //横
    int resizeW = 960;
    //縦
    int resizeH = 1440 ;

    File dir= new File("C:\\work\\tomcat\\webapps\\book\\image\\");
    File[] list = dir.listFiles(filter);
    for(int i=0; i<list.length; i++) {
      if(list[i].isFile()) {
          //変更前の写真をBufferedImageクラスのoriginal変数に読み込ませる
          System.out.println(list[i]);
          BufferedImage original = ImageIO.read(list[i]);
          //変更後の写真をBufferedImageクラスのscaleImg変数に読み込ませる
          BufferedImage scaleImg = new BufferedImage(resizeW, resizeH, BufferedImage.TYPE_3BYTE_BGR);
          scaleImg.createGraphics().drawImage(
          original.getScaledInstance(resizeW, resizeH, Image.SCALE_AREA_AVERAGING),
          0, 0, resizeW, resizeH, null);
          System.out.println(scaleImg.getWidth());
          System.out.println(scaleImg.getHeight());
          //afternameに指定した絶対パスに変更後の写真を上書きする
          // ImageIO.write(scaleImg, "",new File("C:\\work\\tomcat\\webapps\\book\\image\\"+file));
          ImageIO.write(scaleImg, "png",list[i]);
        }
    }
    return "../cpmypage/success.jsp";
  }
}
