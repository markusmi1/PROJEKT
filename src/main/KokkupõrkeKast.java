package main;

import javax.swing.*;
import java.awt.*;

public class KokkupõrkeKast extends Rectangle {
//todo tuleb kast mis on alati karakteri kohal või objekti kohal, mõeldud kokkupõrgete registreerimiseks
    //todo vaja välja mõelda kuidas saada levelile efektiivselt samamoodi peale, äkki leveli koostamise ajal (ruudustik.java)

    int x;
    int y;
    int laius;
    int kõrgus;
    //ajutine värv kontrolliks
    Color värv;


    public KokkupõrkeKast(int x, int y, int laius, int kõrgus,Color värv) {
        this.x = x;
        this.y = y;
        this.laius = laius;
        this.kõrgus = kõrgus;
        this.värv = värv;
    }


    public void joonistaKast(Graphics2D g){
        g.setColor(this.värv);
        g.fillRect(this.x,this.y,this.laius,this.kõrgus);
    }



}
