package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class MenuPaneel extends JPanel implements Andmed{
    String nimi = "";
    JFrame f = new JFrame();
    public MenuPaneel() throws IOException { //konstruktor
        f.setPreferredSize(new Dimension(Andmed.ekraaniLaius,Andmed.ekraaniKõrgus));
        f.getContentPane().setBackground(Color.WHITE);
        f.setFocusable(true);
        tekst();
    }
    public void tekst(){//Kuvatakse eraldi frame'is menu sarnane aken kuhu saab nime sisestada
        f.setLayout(null);

        f.getContentPane().setBackground(Color.BLACK);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel kasutajaLabel = new JLabel("Mängija:");
        JTextField kasutaja = new JTextField(25);
        JButton nupp = new JButton("Mängi!");
        JLabel pealkiri = new JLabel("Totaalne mäng");

        pealkiri.setForeground(Color.WHITE);
        kasutajaLabel.setForeground(Color.WHITE);
        pealkiri.setForeground(Color.WHITE);
        pealkiri.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 48));
        pealkiri.setBounds(ekraaniLaius/2-162, 100, 315, 100);
        kasutajaLabel.setBounds(ekraaniLaius/2-120, 250, 60, 30);
        kasutaja.setBounds(ekraaniLaius/2-60, 250, 100, 30);
        nupp.setBounds(ekraaniLaius/2+40, 250, 80,30);

        f.add(pealkiri);
        f.add(kasutajaLabel);
        f.add(kasutaja);
        f.add(nupp);

        f.pack();
        f.setVisible(true);
            nupp.addActionListener(new ActionListener() {//kui nupule vajutatakse siis saab nimi endale väärtuse
                @Override
                public void actionPerformed(ActionEvent e) {
                    nimi = kasutaja.getText();
                }
            });
    }
    public void kontroll(){//ei lõpeta enne tegevust kuni mängija nimi on sisestatud, seejärel prindib nime
        while (Objects.equals(nimi, ""));
        System.out.println("Mängija: '" + nimi + "'");
        f.dispose();
    }
}
