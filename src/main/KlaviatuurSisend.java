package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KlaviatuurSisend implements KeyListener {
     static public boolean üles, alla, vasak, parem;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int kood = e.getKeyCode();
        if (kood == KeyEvent.VK_W) üles = true;
        if (kood == KeyEvent.VK_S) alla = true;
        if (kood == KeyEvent.VK_A) vasak = true;
        if (kood == KeyEvent.VK_D) parem = true;
        System.out.println("nuppu vajutati");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int kood = e.getKeyCode();
        if (kood == KeyEvent.VK_W) üles = false;
        if (kood == KeyEvent.VK_S) alla = false;
        if (kood == KeyEvent.VK_A) vasak = false;
        if (kood == KeyEvent.VK_D) parem = false;
    }
}
