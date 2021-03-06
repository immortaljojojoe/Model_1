package data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

class Weapon_DesertEagle extends Weapon {
    //图片宽度为22 高度为13
    private String name = "desertEagle";
    private int dmg = 10;
    private BufferedImage left, right;

    Weapon_DesertEagle() {
        try {
            left = ImageIO.read(getClass().getResourceAsStream("/desertEagle_left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/desertEagle_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void drawWeapon(Graphics2D g, int y, boolean dir) {
        if (dir) {
            g.drawImage(right, 811, y - 53, null);
        } else {
            g.drawImage(left, 766, y - 53, null);
        }

    }

    @Override
    String getName() {
        return name;
    }
}
