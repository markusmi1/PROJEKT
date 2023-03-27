package main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame aken = new JFrame();
        aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aken.setLocationRelativeTo(null);
        aken.setResizable(false);
        aken.setTitle("Totally not pokemon simulator");

        GamePanel level = new GamePanel(); //uus mängu paneel
        aken.add(level);  //lisab mängu paneeli aknasse
        //aken.add(
        aken.pack();
        aken.setVisible(true);

        level.alustaGameThread();

    }
}
