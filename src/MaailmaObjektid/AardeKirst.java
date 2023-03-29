package MaailmaObjektid;

import main.Andmed;
import main.KokkupõrkeKast;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


//pilt saadud: https://skalding.itch.io/chest-16x16-open-and-closed

public class AardeKirst  implements Andmed {

    Image pilt;
    public int xKoord;
    public int yKoord;
    public boolean kokkpõrge;
    public boolean kasAvatud;
    public int pildiSuurus = (int)(suurus/1.5);
    public KokkupõrkeKast hitBox;

    public AardeKirst() {
        this.pilt = new ImageIcon(getClass().getResource("/asjad/ChestClosed.png")).getImage();
        this.xKoord = (int) (Math.random()*101 + 432);
        this.yKoord = (int) (Math.random()* 101 + 240);
        this.kasAvatud = false;
        this.hitBox = new KokkupõrkeKast(this.xKoord,this.yKoord,pildiSuurus,pildiSuurus,Color.BLUE);   //kirstu hitbox
        //System.out.println(this.xKoord);
        //System.out.println(this.yKoord);
    }

    public void joonistaKirst(Graphics2D g) {
        g.drawImage(pilt, xKoord, yKoord, pildiSuurus, pildiSuurus, null);
    }
}
