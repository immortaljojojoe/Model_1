package scene.Creatures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

class Monster_001Lion extends Monster {
    Monster_001Lion() {
        //图片高度为74 宽度为119
        //TODO 中心轴确认
        super();
        value = 1;
        dir = false;
        x = 3500;
        y = 526;
        try {
            left = ImageIO.read(getClass().getResourceAsStream("/lion_left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/lion_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void drawMonster(Graphics2D g, int offset) {
        if (dir) {
            g.drawImage(right, x + offset, y, null);
        } else {
            g.drawImage(left, x + offset, y, null);
        }

    }
}
