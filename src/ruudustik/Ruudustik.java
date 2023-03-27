package ruudustik;

import main.Andmed;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Ruudustik implements Andmed {
    //COMMENT: Ma lisasin andmed faili seal on kõik peamised andmed sees, nüüd vist pole enam gp vaja -Robin
    Ruut[] ruut;
    Graphics2D graafika2D;

    public Ruudustik(){
        ruut = new Ruut[10];
        getPilt();
    }

    public void mänguFaas(Graphics2D graafika2D){


        if (Andmed.staatus == Andmed.algStaatus){
            algMenu(graafika2D);
        }
        if (Andmed.staatus == Andmed.peaMäng){
            maastik(graafika2D);

        }
    }

    public void getPilt() {
        try {
            ruut[2] = new Ruut();
            ruut[2].pilt = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/maastik/vesi.png")));
            ruut[1] = new Ruut();
            ruut[1].pilt = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/maastik/sein.png")));
            ruut[0] = new Ruut();
            ruut[0].pilt = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/maastik/muru.png")));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void maastik(Graphics2D graafika2D) {
        File map = new File("map.txt");
        int x = 0;
        int y = 0;
        try {
            Scanner sc = new Scanner(map);
            while (sc.hasNextLine()){
                String rida = sc.nextLine();
                String[] tükid = rida.split(" ");
                for(String el : tükid){
                    int pildiNr = Integer.parseInt(el);
                    graafika2D.drawImage(ruut[pildiNr].pilt, x, y, suurus, suurus, null);
                    x+=suurus;
                }
                x = 0;
                y += suurus;
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void algMenu(Graphics2D graafika2D){
        graafika2D.setColor(Color.BLACK);
        graafika2D.fillRect(0, 0, ekraaniLaius, ekraaniKõrgus);

        graafika2D.setFont(graafika2D.getFont().deriveFont(Font.ITALIC, 96));

        String pealkiri = "Totaalne mäng";
        graafika2D.setColor(Color.WHITE);
        graafika2D.drawString(pealkiri, 50, Andmed.suurus*3);
        graafika2D.setFont(graafika2D.getFont().deriveFont(Font.ITALIC, 36));
        graafika2D.drawString("Uus mäng", 100, Andmed.suurus*5);
        if (Andmed.menuValik == 0) {
            graafika2D.setFont(graafika2D.getFont().deriveFont(Font.ITALIC, 26));
            graafika2D.drawString("--", 80, Andmed.suurus*5-4);
        }

        graafika2D.drawString("Annan alla", 100, Andmed.suurus*6);
    }
}
