package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    int orgiginaalRuuduSuurus = 16;
    int suhe = 3;
    int ruuduSuurus = orgiginaalRuuduSuurus * suhe;
    int maxLaiusRuute = 12;
    int maxKõrgusRuute = 8;
    int aknaLaius = maxLaiusRuute * ruuduSuurus;
    int aknaKõrgus = maxKõrgusRuute * ruuduSuurus;

    public GamePanel(){
        this.setPreferredSize(new Dimension( aknaLaius, aknaKõrgus));
        this.setBackground(Color.green);
        this.setDoubleBuffered(true);
    }
}
