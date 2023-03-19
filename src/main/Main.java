package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame aken = new JFrame();
        aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aken.setResizable(false);
        aken.setTitle("2D mäng");

        GamePanel gamePanel = new GamePanel();
        aken.add(gamePanel);
        aken.pack();

        aken.setLocationRelativeTo(null);
        aken.setVisible(true);
    }

}
