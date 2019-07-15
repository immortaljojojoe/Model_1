package scene.Blocks;

import java.awt.*;

public class Block_002grass extends Block {
    private int value;

    public Block_002grass() {
        value = 2;
    }

    //method that return the value of the block
    public int getValue() {
        return this.value;
    }

    //method that set the value of the block
    public void setValue(int v) {
        this.value = v;
    }

    public void drawBlock(Graphics2D g, int i, int j, int w, int h) {
        //i and j are the location in cells
        //w and h are the blocks width and the blocks height
        g.setColor(new Color(120, 50, 20));
        g.fillRect(i * w, j * h, w, h);
        g.setColor(new Color(140, 200, 50));
        g.fillRect(i * w, j * h, w, h / 5);
        g.setColor(new Color(100, 160, 30));
        g.fillRect(i * w, j * h, w, h / 10);
        g.setStroke(new BasicStroke(1));
        g.setColor(new Color(100, 50, 40));
        g.drawRect(i * w, j * h, w, h);
    }
}
