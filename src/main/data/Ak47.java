package data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

class Ak47 extends Weapon {
    private String name = "ak47";
    private int dmg = 30;
    private BufferedImage left, right;

    Ak47() {
        try {
            left = ImageIO.read(getClass().getResourceAsStream("/ak47_left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/ak47_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void drawWeapon(Graphics2D g, int y, boolean dir) {
        if (dir) {
            g.drawImage(right, 790, y - 56, null);
        } else {
            g.drawImage(left, 744, y - 56, null);
        }

    }

    @Override
    String getName() {
        return name;
    }

}
