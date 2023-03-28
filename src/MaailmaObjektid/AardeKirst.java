package MaailmaObjektid;

import main.Andmed;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


//pilt saadud: https://skalding.itch.io/chest-16x16-open-and-closed

public class AardeKirst {

    Image pilt;
    int xKoord;
    int yKoord;
    boolean kokkpõrge;
    boolean kasAvatud;

    public AardeKirst() {
        this.pilt = new ImageIcon(getClass().getResource("/pildid/asjad/ChestClosed.png")).getImage();
        this.xKoord = (int) Math.random()*101 + 432;
        this.yKoord = (int) Math.random()* 101 + 240;
        this.kasAvatud = false;
    }

    public void joonistaKirst(Graphics2D g) {
        if (!kasAvatud) g.drawImage(pilt, xKoord, yKoord, Andmed.suurus, Andmed.suurus, null);
        //else if (kasAvatud) g.drawImage(pilt,xKoord,yKoord, Andmed.suurus,Andmed.suurus,null);  //selleks ajaks pilt muudetud, kasAvatud muutub siis kui avatakse kirst
    }
}
