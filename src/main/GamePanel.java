package main;

import ruudustik.Ruudustik;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{


    int blokiSuurus = 16;
    int kordaja = 3;
    public final int lõplikSuurus = blokiSuurus * kordaja;
    int ekraaniKõrgus = lõplikSuurus * 10;
    int ekraaniLaius = lõplikSuurus * 15;
    Thread gameThread;
    Ruudustik ruudustik = new Ruudustik(this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(ekraaniLaius,ekraaniKõrgus));
        this.setBackground(Color.BLACK);
        //this.setDoubleBuffered(true);
    }

    public void alustaGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while (gameThread != null){
            System.out.println("käib");
        }

    }

    @Override
    public void paintComponent(Graphics graafika) {
        super.paintComponent(graafika);

        Graphics2D graafika2D = (Graphics2D) graafika;
        ruudustik.maastik(graafika2D);

        graafika2D.dispose();
    }
}
