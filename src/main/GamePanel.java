package main;

import MaailmaObjektid.AardeKirst;
import ruudustik.Ruudustik;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable,Andmed{



    // karakteri alguspunkt
    int xKoord = 0;
    int yKoord = 0;

    int FPS;
    Thread PeamiseMänguLõim;
    KlaviatuurSisend klaviatuurSisend;
    Ruudustik ruudustik;
    Peategelane mehike;
    AardeKirst kirst;

    public GamePanel() throws IOException { //paneeli andmed ja vajalike objektide tegemine
        this.FPS= 60;
        this.setPreferredSize(new Dimension(Andmed.ekraaniLaius,Andmed.ekraaniKõrgus));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.ruudustik = new Ruudustik();
        this.klaviatuurSisend = new KlaviatuurSisend();
        this.mehike = new Peategelane("/tegelased/tegelane.png");
        this.kirst = new AardeKirst();
        this.addKeyListener(klaviatuurSisend);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
    }

    public void alustaGameThread(){        //alustab lõime,määrab lõimele kus tegutseda, alustab meetodi run
        PeamiseMänguLõim = new Thread(this);
        PeamiseMänguLõim.start();
    }

    public void lõpetaGameThread(){
        PeamiseMänguLõim.interrupt();
    }

    public void uuendaPositsiooni(){         //uuendab karakteri positisooni levelil, muudab pilti
        //TODO vaja lisad suuna pildid ja viia muutused siia
        if (KlaviatuurSisend.üles) yKoord -= 3;
        else if (KlaviatuurSisend.alla) yKoord += 3;
        else if (KlaviatuurSisend.vasak) xKoord -= 3;
        else if (KlaviatuurSisend.parem) xKoord += 3;
    }

    @Override
    public void run() {         //PEAMINE MÄNGU TSÜKKEL: uuendab alati graafilist pilti ekraanil
        //TODO hetkel on graafika viidud Peategelase klassi ehk äkki siin sõltuvalt keylistnerist muuta karakteri suuna pilt

        double aja_vahemik = 1000000000/FPS;
        double UusAegEnneJoonistamist = System.nanoTime() + aja_vahemik;

        while (PeamiseMänguLõim != null){
            //System.out.println("käib");

            uuendaPositsiooni();
            repaint();  //kutsub uuesti esile paint meetodi, uuendab graafikat

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
        //Shape ruut = new Rectangle(0,0,suurus,suurus);
        mehike.prindiKarakter(graafika2D,xKoord,yKoord);//prindib mehikese
        graafika2D.drawRect(xKoord,yKoord,suurus,suurus);
        graafika2D.dispose();
        kirst.joonistaKirst(graafika2D);

    }


}
