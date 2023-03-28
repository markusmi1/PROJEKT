package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import main.MenuPaneel;

public class Main extends JPanel {

    public static void main(String[] args) throws IOException {
        MenuPaneel menu = new MenuPaneel();
        menu.kontroll();

        JFrame aken = new JFrame();
        aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aken.setLocationRelativeTo(null);
        aken.setResizable(false);
        aken.setTitle("Totally not pokemon simulator");

        GamePanel level = new GamePanel(); //uus mängu paneel
        aken.add(level);  //lisab mängu paneeli aknasse


        aken.pack();
        aken.setVisible(true);
        level.alusta();


    }
}









