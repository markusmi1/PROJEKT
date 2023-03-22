package main;

import javax.swing.*;
import java.awt.*;

public class Peategelane implements Andmed {

    Image tegelasePilt;
    String pildiTee;


    public Peategelane(String pildiTee) {
        this.pildiTee = pildiTee;      //täielik tee peab olema igaks juhuks hetkel, otse kasutast otsimisel ei leidnud algul
        this.tegelasePilt = new ImageIcon(pildiTee).getImage();     //annab karkaterile pildi, alamklassiks on ImageIcon, vajadusel saab moondada
    }


    public void muudaPilti(Image uusSuunaPilt){
        //TODO kõndimise ajal muudab suunda: muudab karakteri pildi ära
    }

    public void prindiKarakter(Graphics2D graafika, int xKoord,int yKoord){

        graafika.drawImage(this.tegelasePilt,xKoord,yKoord,40,40,null);
    }

    public void setPeategelanePilt(String failpath){
        this.tegelasePilt.flush();
        this.tegelasePilt = new ImageIcon(failpath).getImage();
    }   //seab uue pildi karakterile
}
