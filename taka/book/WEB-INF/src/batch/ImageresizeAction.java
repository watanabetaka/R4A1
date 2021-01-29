package cpoperation;

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

@MultipartConfig( maxFileSize=100048576)
public class CpinfoAction extends Action {
  public String execute(
		HttpServletRequest request, HttpServletResponse response
	)  throws Exception{

    //横
    int resizeW = 960;
    //縦
    int resizeH = 1440;

    File dir = new File("C:\\work\\tomcat\\webapps\\book\\image\\");
    File[] list = dir.listFiles();
    //変更前の写真をBufferedImageクラスのoriginal変数に読み込ませる
    BufferedImage original = ImageIO.read(new File("C:\\work\\tomcat\\webapps\\book\\image\\"+file));
    //変更後の写真をBufferedImageクラスのscaleImg変数に読み込ませる
    BufferedImage scaleImg = new BufferedImage(resizeW, resizeH, BufferedImage.TYPE_3BYTE_BGR);
    scaleImg.createGraphics().drawImage(
    original.getScaledInstance(resizeW, resizeH, Image.SCALE_AREA_AVERAGING),
    0, 0, resizeW, resizeH, null);
    //afternameに指定した絶対パスに変更後の写真を上書きする
    ImageIO.write(scaleImg, "",new File("C:\\work\\tomcat\\webapps\\book\\image\\"+file));
