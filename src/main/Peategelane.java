package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Peategelane implements Andmed {

    Image tegelasePilt;
    String pildiTee;


    public Peategelane(String pildiTee) throws IOException {
        this.pildiTee = pildiTee;      //täielik tee peab olema igaks juhuks hetkel, otse kasutast otsimisel ei leidnud algul
        this.tegelasePilt = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(pildiTee)));     //annab karkaterile pildi, alamklassiks on ImageIcon, vajadusel saab moondada
    }


    public void muudaPilti(Image uusSuunaPilt){
        //TODO kõndimise ajal muudab suunda: muudab karakteri pildi ära
    }

    public void prindiKarakter(Graphics2D graafika, int xKoord,int yKoord){

        graafika.drawImage(tegelasePilt,xKoord,yKoord,48,48,null);
    }

    public void setPeategelanePilt(String failpath){
        this.tegelasePilt.flush();
        this.tegelasePilt = new ImageIcon(failpath).getImage();
    }   //seab uue pildi karakterile
}
