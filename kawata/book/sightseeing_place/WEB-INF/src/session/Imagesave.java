package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;
import session.*;
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

public class Imagesave{
  public static String aftername(Part part){
    String file = "";
    try{
    // 写真ををファイル名に変換
    file = Setfilename.getFileName(part);
    //以下のコードで写真のサイズと拡張子の変更を行う
    //変更したい縦と横の長さを指定する
    //横
    int resizeW = 300;
    //縦
    int resizeH = 300;
    //変更前の写真をBufferedImageクラスのoriginal変数に読み込ませる
    BufferedImage original = ImageIO.read(new File(file));
    //変更後の写真をBufferedImageクラスのscaleImg変数に読み込ませる
    BufferedImage scaleImg = new BufferedImage(resizeW, resizeH, BufferedImage.TYPE_3BYTE_BGR);
    scaleImg.createGraphics().drawImage(
    original.getScaledInstance(resizeW, resizeH, Image.SCALE_AREA_AVERAGING),
    0, 0, resizeW, resizeH, null);
    //拡張子をpngに指定する
    //afternameに指定した絶対パスに変更後の写真を上書きする
    ImageIO.write(scaleImg, "png",new File(file));
    //写真の絶対パスを指定したものをafternameに入れる
    String aftername = "C:\\work\\tomcat\\webapps\\book\\image\\"+file;
    //afternameに格納している絶対パスに写真を保存する
    part.write(aftername);
    }catch(IOException e){
      System.out.println("error");
    }
    file = "../image/"+file;
    return file;
  }

}
