package main;

import ruudustik.Ruudustik;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{


    int blokiSuurus = 16;
    int kordaja = 3;
    public final int suurus = blokiSuurus * kordaja;   //ekrranil oleva bloki lõplik suurus
    int ekraaniKõrgus = suurus * 10;
    int ekraaniLaius = suurus * 15;      //TODO muuta muudes failides ära andmete võtmine siis ei ole siia enam andmeid vaja:


    Thread gameThread;
    Ruudustik ruudustik = new Ruudustik(this);//"C:\\Users\\murkr\\Desktop\\Tartu Ülikool\\java OOP\\OOP\\PROJEKT\\pildid\\tegeleased\\tegelane.png"
    Peategelane mehike = new Peategelane("/tegelased/tegelane.png");

    public GamePanel() throws IOException {             //paneeli andmed
        this.setPreferredSize(new Dimension(Andmed.ekraaniLaius,Andmed.ekraaniKõrgus));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.setDoubleBuffered(true);
    }

    public void alustaGameThread(){        //alustab lõime, alustab meetodi run ja meetodi paint
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {         //PEAMINE MÄNGU TSÜKKEL
        //TODO vaja lisada peamine tsükkel + teha meetod mis konstantselt uuendaks graafikat
        //TODO hetkel on graafika viidud Peategelase klassi ehk äkki siin sõltuvalt keylistnerist muuta karakteri suuna pilt
        while (gameThread != null){
            //System.out.println("käib");

        }

    }

    /**@Override
    public void paintComponent(Graphics graafika) {
        super.paintComponent(graafika);

        Graphics2D graafika2D = (Graphics2D) graafika;
        ruudustik.maastik(graafika2D);


        //AJUTINE mehikese joonistamine

        graafika2D.drawImage(new ImageIcon("/pildid/tegeleased/tegelane/tegelane.png").getImage(),0,0,null);
        graafika2D.dispose();
    }*/    //Test ei ole enam oluline

    public void paint(Graphics g){    //printimine run käigu ajal(sisse ehitatud funktsioon, kutsutakse vaikselt)

        Graphics2D graafika2D = (Graphics2D) g;  //vajalik teha Graphics2D objektiks et oleks rohkem funktsionaalsust
        ruudustik.maastik(graafika2D);

        //TODO vaja viia kas run meetodisse või siia lisada signatuurile muutuvad koordinaadi parameetrid
        mehike.prindiKarakter(graafika2D,100,100); //prindib mehikese
        graafika2D.dispose();
    }


}
