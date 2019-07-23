package scene.Creatures;

import java.awt.*;
import java.awt.image.BufferedImage;

abstract class Monster {
    int x, y;
    int value = 0;
    int hitPoint;
    int dmg;
    boolean dir;
    BufferedImage left, right;

    Monster() {
        hitPoint = 100;
    }

    abstract void drawMonster(Graphics2D g, int offset);
}
