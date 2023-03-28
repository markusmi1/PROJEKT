package main;

import javax.swing.*;
import java.io.IOException;

public class Main extends JPanel {

    public static void main(String[] args) throws IOException {
        MenuPaneel menu = new MenuPaneel();
        menu.kontroll();

        JFrame aken = new JFrame();
        aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aken.setResizable(false);
        aken.setTitle("Totally not pokemon simulator");

        GamePanel level = new GamePanel(); //uus mängu paneel
        aken.add(level);  //lisab mängu paneeli aknasse

        aken.pack();
        aken.setVisible(true);
        level.alusta();
    }
}









