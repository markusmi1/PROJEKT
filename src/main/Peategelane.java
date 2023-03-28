package main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Peategelane implements Andmed {
    //TODO lisa sisse kõik pildid karakteri suunast, muuda konstruktoris nii et esimene pilt on alati eestvaade
    Image tegelasepiltVaadeParemale;
    Image tegelasepiltVaadeVasakule;
    Image prinditavVaade = tegelasepiltVaadeParemale;


    int x;
    int y;
    public KokkupõrkeKast hitBox;


    public Peategelane(int xKoord, int yKoord) throws IOException {

        this.tegelasepiltVaadeParemale = new ImageIcon(getClass().getResource("/tegelased/omaMehike.png")).getImage();
        this.tegelasepiltVaadeVasakule = new ImageIcon(getClass().getResource("/tegelased/omaMehikeVasak.png")).getImage();
        this.prinditavVaade = this.tegelasepiltVaadeParemale;
        //this.tegelasePilt = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(pildiTee)));     //annab karkaterile pildi, alamklassiks on ImageIcon, vajadusel saab moondada
        this.x = xKoord;
        this.y = yKoord;
        this.hitBox = new KokkupõrkeKast(x+10,y+38,10,10,Color.WHITE);   //annab hitBoxi karakterile
    }


    public void muudaPilti(Image uusSuunaPilt){
        //TODO kõndimise ajal muudab suunda: muudab karakteri pildi ära
    }

    public void prindiKarakter(Graphics2D graafika, int xKoord,int yKoord){

        graafika.drawImage(prinditavVaade,xKoord,yKoord,suurus,suurus,null);
    }

}
