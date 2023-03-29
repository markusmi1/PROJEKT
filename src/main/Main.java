package main;

import javax.swing.*;
import java.io.IOException;

public class Main extends JPanel {

    public static void main(String[] args) throws IOException {
        MenuPaneel menu = new MenuPaneel();  //genereerib ja avab menüü paneeli
        menu.kontroll(); //ootab et nimi oleks sisestatud

        JFrame aken = new JFrame();//peamine aken
        aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aken.setResizable(false);
        aken.setTitle("OOP mänguprojekt");

        mänguPaneel level = new mänguPaneel(); //uus mängu paneel
        aken.add(level);  //lisab mängu paneeli aknasse

        aken.pack();
        aken.setVisible(true);
        level.alusta();
    }
}









