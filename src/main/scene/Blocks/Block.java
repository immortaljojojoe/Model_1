package scene.Blocks;

import java.awt.*;

public class Block {
    private int value;

    public Block() {
        value = 0;
        //System.out.println(value);
    }

    //method that return the value of the block
    public int getValue() {
        return this.value;
    }

    public void setValue(int v) {
        this.value = v;
    }

    public void drawBlock(Graphics2D g, int i, int j, int w, int h, int offset) {
        //i and j are the location in cells
        //w and h are the blocks width and the blocks height
        //g.setColor(new Color(0, 240, 250));
        //g.fillRect(i * w, j * h, w, h);
        g.setStroke(new BasicStroke(1));
        g.setColor(new Color(250, 250, 250));
        g.drawRect(i * w, j * h, w, h);
    }

}
