package ruudustik;

import main.Andmed;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import main.GamePanel;
import main.Main;
import main.MenuPaneel;

public class Ruudustik extends JFrame implements Andmed {
    Image[] ruut;


    public Ruudustik() {
        ruut = new Image[10];
        getPilt();

    }
    public void getPilt() {

        try {
            ruut[2] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/maastik/vesi.png")));
            ruut[1] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/maastik/sein.png")));
            ruut[0] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/maastik/muru.png")));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void mänguFaas(Graphics2D graafika2D) {


        /*if (MenuPaneel.staatus == Andmed.algStaatus){
            //menu.setVisible(true);
        }
        if (MenuPaneel.staatus == Andmed.peaMäng){
            maastik(graafika2D);

        }*/
    }
    public void maastik(Graphics2D graafika2D) {
        //File map = new File("map.txt");
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
    /*public void algMenu(Graphics2D graafika2D){


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
        setLayout(new FlowLayout());

        JLabel kasutajaLabel = new JLabel("Kasutaja:");
        add(kasutajaLabel);

        JTextField kasutaja = new JTextField(25);
        JButton nupp = new JButton("NUPP");
        //nupp.setBounds(100,100, 20,20);
        add(kasutaja);
        add(nupp);

        nupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staatus = 1;
                nimi = kasutaja.getText();
                System.out.println("Mängija: '" + nimi + "'");
                System.out.println(staatus);
            }
        });
    }*/

}
