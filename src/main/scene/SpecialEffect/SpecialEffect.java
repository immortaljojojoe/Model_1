package scene.SpecialEffect;

import java.awt.*;
import java.util.ArrayList;

public class SpecialEffect {
    //特效的左上角
    private int CoordX, CoordY;
    private ArrayList<Bullet> bullets = new ArrayList<>(30);
    private int bulletNum = 0;
    private int reloadTime = 200;
    private boolean reloading = false;

    public SpecialEffect() {
    }

    public void addBullet(int x, int y, boolean dir) {
        if (bulletNum < 30) {
            bullets.add(new Bullet(x, y, dir));
            bulletNum++;
        } else {
            if (reloadTime <= 0) {
                bullets = new ArrayList<>(30);
                bullets.add(new Bullet(x, y, dir));
                bulletNum = 1;
                reloadTime = 200;
            } else {
                reloading = true;
            }

        }

    }

    public void drawEffect(Graphics2D g) {
        for (Bullet b : bullets) {
            if (b.activated()) {
                b.drawBullet(g);
            }
        }
    }

    public void renewEffect() {
        for (Bullet b : bullets) {
            if (b.activated()) {
                b.renew();
            }
        }
        if (reloading) {
            reloadTime--;
        }
        if (reloadTime == 0) {
            reloading = false;
        }

    }

    public int ammoLeft() {
        return 30 - bulletNum;
    }

    public boolean reloading() {
        return reloading;
    }

    public int getReloadTime() {
        return reloadTime;
    }
}
