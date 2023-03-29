package main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Peategelane implements Andmed {
    Image tegelasepiltVaadeParemale;
    Image tegelasepiltVaadeVasakule;
    Image prinditavVaade = tegelasepiltVaadeParemale;
    int x;  // tegelase x koordinaat
    int y; // tegelase y koordinaat
    int kiirus;
    public KokkupõrkeKast hitBox;


    public Peategelane(int xKoord, int yKoord) throws IOException {
        this.kiirus = 3;
        this.tegelasepiltVaadeParemale = new ImageIcon(getClass().getResource("/tegelased/omaMehike.png")).getImage();
        this.tegelasepiltVaadeVasakule = new ImageIcon(getClass().getResource("/tegelased/omaMehikeVasak.png")).getImage();
        this.prinditavVaade = this.tegelasepiltVaadeParemale;  //muutmine toimub mänguPaneel.uuendaPositsiooni
        //this.tegelasePilt = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tegelased/omaMehike.png")));     //vajadusel saab kasutada, on kindlam,
        this.x = xKoord;
        this.y = yKoord;
        this.hitBox = new KokkupõrkeKast(x+10,y+38,10,10,Color.WHITE);   //annab hitBoxi karakterile
    }


    public void prindiKarakter(Graphics2D graafika, int xKoord,int yKoord){

        graafika.drawImage(prinditavVaade,xKoord,yKoord,suurus,suurus,null);
    }

}
