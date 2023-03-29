package main;

import MaailmaObjektid.AardeKirst;
import ruudustik.Ruudustik;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class mänguPaneel extends JPanel implements Runnable,Andmed{


    int FPS;
    Thread PeamiseMänguLõim;
    boolean kasTöötab;
    KlaviatuurSisend klaviatuurSisend;
    Ruudustik ruudustik;
    Peategelane mehike;
    AardeKirst kirst;

    //KokkupõrkeKast proov1;    //ajutised
    //KokkupõrkeKast proov2;

    public mänguPaneel() throws IOException { //paneeli andmed ja vajalike objektide tegemine
        this.FPS= 60;
        this.setPreferredSize(new Dimension(Andmed.ekraaniLaius,Andmed.ekraaniKõrgus));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.ruudustik = new Ruudustik();
        this.klaviatuurSisend = new KlaviatuurSisend();
        this.mehike = new Peategelane(100,100);
        this.kirst = new AardeKirst();
        this.addKeyListener(klaviatuurSisend);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        //this.proov1 = new KokkupõrkeKast(mehike.x+12,mehike.y+38,10,10,Color.WHITE);  //kokkupõrke proovimiseks, EI tööta
        //this.proov2 = new KokkupõrkeKast(kirst.xKoord,kirst.yKoord,kirst.pildiSuurus,kirst.pildiSuurus,Color.BLUE);
    } //konstruktor


    public void alusta(){        //alustab mängupaneelil lõime, kutsub meetodi run
        PeamiseMänguLõim = new Thread(this);
        kasTöötab = true;
        PeamiseMänguLõim.start();
    }

    public void uuendaPositsiooni(){         //uuendab karakteri positisooni levelil, muudab pilti
        if (KlaviatuurSisend.üles) {
            mehike.y -= mehike.kiirus;
            mehike.hitBox.y -= mehike.kiirus;
            //proov1.y -= 3;
        }
        else if (KlaviatuurSisend.alla) {
            mehike.y += mehike.kiirus;
            mehike.hitBox.y += mehike.kiirus;
            //proov1.y += 3;
        }
        else if (KlaviatuurSisend.vasak) {
            mehike.x -= mehike.kiirus;
            mehike.hitBox.x -= mehike.kiirus;
            mehike.prinditavVaade = mehike.tegelasepiltVaadeVasakule;
            //proov1.x -= 3;
        }
        else if (KlaviatuurSisend.parem) {
            mehike.x += mehike.kiirus;
            mehike.hitBox.x += mehike.kiirus;
            mehike.prinditavVaade = mehike.tegelasepiltVaadeParemale;
            //proov1.x += 3;
        }
    }

    @Override
    public void run() {         //PEAMINE MÄNGU TSÜKKEL: uuendab alati graafilist pilti ekraanil
        double aja_vahemik = 1000000000/FPS;
        double UusAegEnneJoonistamist = System.nanoTime() + aja_vahemik;

        while (kasTöötab){

            /**if (proov1.intersects(proov2)){                               //eksperimentaalne: algne kokkupõrke loogika
                System.out.println("peategeleasel on kokkupuude kirstuga");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }*/

            uuendaPositsiooni();
            repaint();  //kutsub uuesti esile paint meetodi, uuendab graafikat


            try {                      //Mängu kell, piirab ühe tsükkli aega
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

        ruudustik.joonistaMaastik(graafika2D);
        kirst.joonistaKirst(graafika2D);
        mehike.prindiKarakter(graafika2D,mehike.x,mehike.y);//prindib mehikese


        //mehike.hitBox.joonistaKast(graafika2D);
        //kirst.hitBox.joonistaKast(graafika2D);
        //proov1.joonistaKast(graafika2D);  //ajutine
        //proov2.joonistaKast(graafika2D);

        graafika2D.dispose();
    }
}//klass
