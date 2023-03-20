package ruudustik;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Ruudustik {
    GamePanel gp;
    Ruut[] ruut;

    public Ruudustik(GamePanel gp){
        this.gp = gp;
        ruut = new Ruut[10];
        getPilt();
    }
    public void getPilt() {
        try {
            ruut[0] = new Ruut();
            ruut[0].pilt = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/maastik/pxArt.png"));
            ruut[1].pilt = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/maastik/sein.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void maastik(Graphics2D g){
        g.drawImage(ruut[0].pilt, 0, 0, gp.blokiSuurus, gp.blokiSuurus, null);
    }
}
