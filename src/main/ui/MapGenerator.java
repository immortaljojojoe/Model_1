package ui;

import scene.BlocksAndMap.Block;

import java.awt.*;

public class MapGenerator {
    private Block[][] map;
    private int blockWidth;
    private int blockHeight;

    public MapGenerator(int width, int height){
        map = new Block[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = new Block();
            }
        }
        blockWidth = width / 20;
        blockHeight = height / 20;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].getValue() > 0) {
                    map[i][j].drawBlock(g, j, i, blockWidth, blockHeight);
                }
            }
        }
    }

    public void setblockvalue(int value, int row, int col) {
        map[row][col].setValue(value);
    }
}
