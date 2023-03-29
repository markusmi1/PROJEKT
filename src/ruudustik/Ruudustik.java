package ruudustik;

import main.Andmed;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class Ruudustik extends JFrame implements Andmed {
    Image[] ruut;
    public Ruudustik() {
        ruut = new Image[10];
        getPilt();
    }
    public void getPilt() {//loetakse pildid Image järjendisse
        try {
            ruut[2] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/maastik/vesi.png")));
            ruut[1] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/maastik/sein.png")));
            ruut[0] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/maastik/muru.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void joonistaMaastik(Graphics2D graafika2D) {//joonistatakse mängu maastik/ruudustik lugedes selle txt failist
        int x = 0;
        int y = 0;
        try {
            Scanner sc = new Scanner(new File("map.txt"));
            while (sc.hasNextLine()){
                String rida = sc.nextLine();
                String[] tükid = rida.split(" ");
                for(String el : tükid){
                    int pildiNr = Integer.parseInt(el);
                    graafika2D.drawImage(ruut[pildiNr], x, y, suurus, suurus, null);
                    x+=suurus;
                }
                x = 0;
                y += suurus;
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();

        }
    }
}
