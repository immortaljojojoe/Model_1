package ui;

import scene.Blocks.Block;
import scene.Blocks.Block_001dirt;
import scene.Blocks.Block_002grass;

import java.awt.*;

public class MapGenerator {
    private Block[][] map;
    private int blockWidth;
    private int blockHeight;

    public MapGenerator(int width, int height){
        blockWidth = 50;
        blockHeight = 50;
        int numBlockY = height / blockHeight;
        int numBlockX = width / blockWidth;
        map = new Block[numBlockX][numBlockY];
        //System.out.println(numBlockY+""+numBlockX);
        for (int i = 0; i < numBlockX; i++) {
            for (int j = 0; j < numBlockY; j++) {
                if (j > (numBlockY / 4 * 3)) {
                    map[i][j] = new Block_001dirt();
                } else if (j == (numBlockY / 4 * 3)) {
                    map[i][j] = new Block_002grass();
                } else {
                    map[i][j] = new Block();
                }

            }
        }

    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].getValue() > 0) {
                    map[i][j].drawBlock(g, i, j, blockWidth, blockHeight);
                }
            }
        }
    }

    public void setblockvalue(int value, int row, int col) {
        map[row][col].setValue(value);
    }
}
