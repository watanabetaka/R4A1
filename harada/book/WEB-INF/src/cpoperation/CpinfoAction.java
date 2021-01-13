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

// @WebServlet("/cpinfo/Cpinfo")
//写真をやり取りするためのアノテーションを記述している
@MultipartConfig( maxFileSize=100048576)
public class CpinfoAction extends Action {
  public String execute(
		HttpServletRequest request, HttpServletResponse response
	)  throws Exception{
          //企業が送信した企業名を受け取り、cpnameに格納
          String cpname=request.getParameter("cpname");
          //企業が送信した観光地名を受け取る
          String sightname=request.getParameter("sightname");
          //企業情報daoをインスタンス化
          CpinfoDAO dao = new CpinfoDAO();
          /*sightnamesearchメソッドで観光地名の重複がないか検索をかけ、結果をboolean
          型のsearchflagに返す*/
          boolean searchflag = dao.sightnamesearch(sightname);
          //searchflagがfalseなら観光地登録へ進む
          if(!searchflag){
            //ユーザが送信した写真を受け取る
            Part part = request.getPart("file");
            // 写真ををファイル名に変換
            String file = Setfilename.getFileName(part);
            part.write("C:\\work\\tomcat\\webapps\\book\\image\\"+file);
            //横
            int resizeW = 300;
            //縦
            int resizeH = 300;
            //変更前の写真をBufferedImageクラスのoriginal変数に読み込ませる
            BufferedImage original = ImageIO.read(new File("C:\\work\\tomcat\\webapps\\book\\image\\"+file));
            //変更後の写真をBufferedImageクラスのscaleImg変数に読み込ませる
            BufferedImage scaleImg = new BufferedImage(resizeW, resizeH, BufferedImage.TYPE_3BYTE_BGR);
            scaleImg.createGraphics().drawImage(
            original.getScaledInstance(resizeW, resizeH, Image.SCALE_AREA_AVERAGING),
            0, 0, resizeW, resizeH, null);
            //afternameに指定した絶対パスに変更後の写真を上書きする
            ImageIO.write(scaleImg, "",new File("C:\\work\\tomcat\\webapps\\book\\image\\"+file));
            String picture_path = "../image/"+file;
            //企業が送信した市町村のidを受け取り、tmpに一時格納する
            String tmp =request.getParameter("city_id");
            //tmpをint型にキャストしてcity_idに格納
            int city_id =Integer.parseInt(tmp);
            //sessionクラスインスタンス化
            Session session = new Session();
            //int user_idにユーザIDが入っている
            int user_id = session.getUser_id(request,response);
            //企業が送信した住所を受け取る
            String street_address=request.getParameter("address");
            //企業が送信した郵便番号を受け取る
            String postal_code = request.getParameter("postal_code");
            //企業が送信した電話番号を受け取り、tmpへ一時格納する
            tmp =request.getParameter("tel");
            //ハイフン消した後の電話番号を格納する変数
            String phone_number = "";
            //下のfor文で-を消す
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '-' || tmp.charAt(i) == 'ー') {
                    continue;
                }
                  phone_number= phone_number + tmp.charAt(i);
            }
            //企業が送信したジャンルのidを受け取り、tmpへ一時格納する
            tmp =request.getParameter("genre_id");
            //tmpをint型にキャストしてgenre_idに格納
            int genre_id = Integer.parseInt(tmp);
            //企業が送信した営業時間を受け取る
            String business_hour = request.getParameter("business_hour");
            //企業が送信した最寄り駅を受け取る
            String nearest_station=request.getParameter("station");
            //企業が送信した企業ランクを受け取る
            String rank=request.getParameter("rank");
            //企業が送信した予約URLを受け取る
            String bookurl=request.getParameter("bookurl");
            //企業が入力した情報を挿入する
            boolean insertflag = dao.cpinfoinsert(user_id,sightname,city_id,genre_id,picture_path,postal_code,street_address,phone_number,business_hour,nearest_station,rank,bookurl);
                if(insertflag){
                  return "cpexamination.jsp";
                }

          }
          return "cpinfo-error.jsp";
    }
}
