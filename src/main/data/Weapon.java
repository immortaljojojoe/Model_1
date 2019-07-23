package data;

import java.awt.*;
import java.awt.image.BufferedImage;

abstract class Weapon {
    private String name = "weapon default";
    private BufferedImage left, right;

    Weapon() {
    }

    Weapon(String name) {
        /*
        try{
            left= ImageIO.read(getClass().getResourceAsStream("/"+name+"_left.png"));
            right= ImageIO.read(getClass().getResourceAsStream("/"+name+"_right.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        */

    }

    abstract void drawWeapon(Graphics2D g, int y, boolean dir);

    abstract String getName();
}
