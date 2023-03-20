package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{


    int blokiSuurus = 16;
    int kordaja = 3;
    final int lõplikSuurus = blokiSuurus * kordaja;
    int ekraaniKõrgus = lõplikSuurus * 10;
    int ekraaniLaius = lõplikSuurus * 15;
    Thread gameThread;

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
            //System.out.println("käib");
        }

    }
}
