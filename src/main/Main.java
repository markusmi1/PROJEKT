package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame aken = new JFrame();
        aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aken.setLocationRelativeTo(null);
        aken.setResizable(false);
        aken.setTitle("Totally not pokemon simulator");

        GamePanel level = new GamePanel(); //uus mängu paneel
        aken.add(level);  //lisab mängu paneeli aknasse
        aken.pack();

        aken.setVisible(true);
    }

}
