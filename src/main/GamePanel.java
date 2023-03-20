package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {


    int blokiSuurus = 16;
    int kordaja = 3;
    final int lõplikSuurus = blokiSuurus * kordaja;
    int ekraaniKõrgus = lõplikSuurus * 10;
    int ekraaniLaius = lõplikSuurus * 15;

    public GamePanel(){
        this.setPreferredSize(new Dimension(ekraaniLaius,ekraaniKõrgus));
        this.setBackground(Color.BLACK);
        //this.setDoubleBuffered(true);
    }




}
