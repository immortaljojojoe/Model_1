package scene.SpecialEffect;

import java.awt.*;

class Bullet {
    //子弹飞行速度
    private boolean activation = false;
    private int speed = 30;
    private int CoordX, CoordY;
    private boolean dir;

    //dir代表的是子弹的飞行方向（左false右true）
    Bullet(int x, int y, boolean dir) {
        activation = true;
        CoordX = x;
        CoordY = y;
        this.dir = dir;
    }

    void drawBullet(Graphics2D g) {
        g.setColor(new Color(150, 150, 150));
        g.fillOval(CoordX, CoordY, 5, 5);
        g.setColor(new Color(70, 70, 70));
        g.setStroke(new BasicStroke(1));
        g.drawOval(CoordX, CoordY, 5, 5);

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
