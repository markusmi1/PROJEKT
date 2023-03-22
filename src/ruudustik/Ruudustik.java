package ruudustik;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Ruudustik {
    GamePanel gp;     //COMMENT: Ma lisasin andmed faili seal on kõik peamised andmed sees, nüüd vist pole enam gp vaja -Robin
    Ruut[] ruut;

    public Ruudustik(GamePanel gp){
        this.gp = gp;
        ruut = new Ruut[10];
        getPilt();
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
                    graafika2D.drawImage(ruut[pildiNr].pilt, x, y, gp.suurus, gp.suurus, null);
                    x+=gp.suurus;
                }
                x = 0;
                y += gp.suurus;
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();

        }



    }
}
