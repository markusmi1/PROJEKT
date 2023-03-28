package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Peategelane implements Andmed {
    //TODO lisa sisse kõik pildid karakteri suunast, muuda konstruktoris nii et esimene pilt on alati eestvaade
    Image tegelasePilt;
    String pildiTee;

    int x;
    int y;
    public KokkupõrkeKast hitBox;


    public Peategelane(String pildiTee,int xKoord, int yKoord) throws IOException {
        this.pildiTee = pildiTee;      //täielik tee peab olema igaks juhuks hetkel, otse kasutast otsimisel ei leidnud algul
        this.tegelasePilt = new ImageIcon(getClass().getResource(pildiTee)).getImage();
        //this.tegelasePilt = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(pildiTee)));     //annab karkaterile pildi, alamklassiks on ImageIcon, vajadusel saab moondada
        this.x = xKoord;
        this.y = yKoord;
        this.hitBox = new KokkupõrkeKast(x+10,y+38,10,10,Color.WHITE);
    }


    public void muudaPilti(Image uusSuunaPilt){
        //TODO kõndimise ajal muudab suunda: muudab karakteri pildi ära
    }

    public void prindiKarakter(Graphics2D graafika, int xKoord,int yKoord){

        graafika.drawImage(tegelasePilt,xKoord,yKoord,suurus,suurus,null);
    }

    public void setPeategelanePilt(String failpath){
        this.tegelasePilt.flush();
        this.tegelasePilt = new ImageIcon(failpath).getImage();
    }   //seab uue pildi karakterile
}
