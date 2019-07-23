package ui;

import scene.Blocks.Block;
import scene.Blocks.Block_001dirt;
import scene.Blocks.Block_002grass;

import java.awt.*;

public class MapGenerator {
    //地图（先是x再是y）
    private Block[][] map;
    private int blockWidth;
    private int blockHeight;
    //TODO offset
    //x轴偏差值
    //
    private int offset;

    public MapGenerator(int row, int col) {
        blockWidth = 50;
        blockHeight = 50;
        offset = -blockWidth * col / 2;
        map = new Block[col][row];
        //System.out.println(numBlockY+""+numBlockX);

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (j > (row / 4 * 3)) {
                    map[i][j] = new Block_001dirt();
                } else if (j == (row / 4 * 3)) {
                    map[i][j] = new Block_002grass();
                } else {
                    map[i][j] = new Block();
                }

            }
        }
        /*
        map[3][12] = new Block_001dirt();
        map[3][11] = new Block_001dirt();
        map[3][10] = new Block_002grass();
        map[7][11] = new Block_002grass();
        map[8][11] = new Block_001dirt();
        map[9][11] = new Block_002grass();
        map[8][10] = new Block_002grass();
        map[7][12] = new Block_001dirt();
        map[8][12] = new Block_001dirt();
        map[9][12] = new Block_001dirt();
        */


    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].getValue() > 0) {
                    map[i][j].drawBlock(g, i, j, blockWidth, blockHeight, offset);
                }
            }
        }
    }

    public void setblockvalue(int value, int row, int col) {
        map[row][col].setValue(value);
    }

    //TODO 重新设置人物位置偏移导致的地图移动
    //Give back The Current GroundLevel based on the player col given
    public int currGround(int player_col) {
        //stub
        return 0;
    }

    public void moveLeft() {
        offset -= 6;
    }

    public void moveRight() {
        offset += 6;
    }

    //边缘检测， 检测是不是撞到墙了
    public void marginDetection() {
        //Right margin detection
        if (offset >= 780) {
            offset = 780;
        }
        //playerLeft margin detection
        if (offset <= -4180) {
            offset = -4180;
        }
    }

    public int getOffset() {
        return offset;
    }

}
