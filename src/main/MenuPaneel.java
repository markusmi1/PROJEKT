package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

import main.Main;

public class MenuPaneel extends JPanel implements Andmed{
    String nimi = "";
    JFrame f = new JFrame();

    public MenuPaneel() throws IOException {             //paneeli andmed
        f.setPreferredSize(new Dimension(Andmed.ekraaniLaius,Andmed.ekraaniKõrgus));
        f.getContentPane().setBackground(Color.WHITE);
        f.setFocusable(true);
        tekst();

    }
    public void tekst(){
        f.setLayout(new FlowLayout());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel kasutajaLabel = new JLabel("Mängija:");
        JTextField kasutaja = new JTextField(25);
        JButton nupp = new JButton("Mängi!");

        f.add(kasutajaLabel);
        f.add(kasutaja);
        f.add(nupp);



        f.pack();
        f.setVisible(true);
            nupp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    nimi = kasutaja.getText();
                }
            });
    }
    public void kontroll(){
        while (Objects.equals(nimi, ""));
        System.out.println("Mängija: '" + nimi + "'");
        f.dispose();
    }
}
