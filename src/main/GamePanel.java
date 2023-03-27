package main;

import ruudustik.Ruudustik;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{

    //ajutine
    public int suurus = Andmed.suurus;

    // karakteri alguspunkt
    int xKoord = 100;
    int yKoord = 100;
    Thread gameThread;
    KlaviatuurSisend klaviatuurSisend = new KlaviatuurSisend();
    Ruudustik ruudustik = new Ruudustik();
    Peategelane mehike = new Peategelane("/tegelased/tegelane.png");

    public GamePanel() throws IOException {             //paneeli andmed
        this.setPreferredSize(new Dimension(Andmed.ekraaniLaius,Andmed.ekraaniKõrgus));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.addKeyListener(klaviatuurSisend);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
    }

    public void alustaGameThread(){        //alustab lõime, alustab meetodi run ja meetodi paint
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void lõpetaGameThread(){
        gameThread.interrupt();
    }

    public void uuendaPositsiooni(){         //uuendab karakteri positisooni levelil, muudab pilti
        //TODO vaja lisad suuna pildid ja viia muutused siia
        if (KlaviatuurSisend.üles) yKoord -= 3;
        else if (KlaviatuurSisend.alla) yKoord += 3;
        else if (KlaviatuurSisend.vasak) xKoord -= 3;
        else if (KlaviatuurSisend.parem) xKoord += 3;
    }

    @Override
    public void run() {         //PEAMINE MÄNGU TSÜKKEL
        //TODO vaja lisada peamine tsükkel + teha meetod mis konstantselt uuendaks graafikat
        //TODO hetkel on graafika viidud Peategelase klassi ehk äkki siin sõltuvalt keylistnerist muuta karakteri suuna pilt

        double aja_vahemik = 1000000000/60;
        double UusAegEnneJoonistamist = System.nanoTime() + aja_vahemik;

        while (gameThread != null){
            //System.out.println("käib");

            uuendaPositsiooni();
            repaint();

            //System.out.println(Thread.currentThread().getName());
            try {
                double allesjäänudAeg = (UusAegEnneJoonistamist - System.nanoTime())/1000000;
                if (allesjäänudAeg < 0) allesjäänudAeg = 0;
                Thread.sleep((long)allesjäänudAeg);

                UusAegEnneJoonistamist += aja_vahemik;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void paint(Graphics g){    //printimine run käigu ajal(sisse ehitatud funktsioon, kutsutakse vaikselt)

        Graphics2D graafika2D = (Graphics2D) g;  //vajalik teha Graphics2D objektiks et oleks rohkem funktsionaalsust

        ruudustik.maastik(graafika2D);

        //TODO vaja viia kas run meetodisse või siia lisada signatuurile muutuvad koordinaadi parameetrid
        mehike.prindiKarakter(graafika2D,xKoord,yKoord); //prindib mehikese
        graafika2D.dispose();
    }


}
