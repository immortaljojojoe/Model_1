package scene.SpecialEffect;

import java.awt.*;

public class Bullet_DesertEagle extends Bullet {
    //子弹飞行速度
    private int speed = 20;

    //dir代表的是子弹的飞行方向（左false右true）
    Bullet_DesertEagle(int x, int y, boolean dir) {
        super(x, y, dir);
    }

    void drawBullet(Graphics2D g) {
        g.setColor(new Color(250, 250, 0));
        g.fillRect(CoordX, CoordY, 5, 3);
        g.setColor(new Color(0, 0, 20));
        g.setStroke(new BasicStroke(1));
        g.drawOval(CoordX, CoordY, 5, 3);

    }

    public boolean activated() {
        return activation;
    }

    void renew() {
        if (dir) {
            CoordX += speed;
        } else {
            CoordX -= speed;
        }

    }
}
