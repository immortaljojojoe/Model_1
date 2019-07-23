package data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player {
    //player图片高度为73 宽度为28 中心轴为19
    public int player_col = 50;
    // HP :血量
    public int hitpoint = 100;

    //the lower coordinate of the player
    //玩家站立海拔，以玩家脚踩高度（最低y值）
    //TODO 用currGround（GamePlay）改变初始值
    public int playerY = 600;
    //玩家所在行与列
    public int player_row = (playerY / 50);

    //the direction of moving
    //玩家面向方向
    public boolean moveDir = true;
    //初始地面高度，按照玩家站立位置决定
    //TODO 按照玩家站立列数来改变初始值
    public int groundLevel = 600;
    //玩家专属class
    private Item item;
    //private int player_width=20;
    //弹跳力剩余
    private int energy_up = 0;
    //向下冲击力计算
    private int energy_down = 0;
    //起跳高度 以（n+1）n/2为准//
    //修改以改变玩家起跳力度（默认基值 14）《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《
    private int jumpEnergy = 14;//height jump
    //人物奔跑速度
    //修改以改变人物奔跑速度（默认基值 4）《《《《《《《《《《《《《《《《《《《《《《
    int speed = 4;//the moving speed
    //人物图片
    private BufferedImage playerLeft, playerRight;
    //地图方格个数 row为行数 col为列数（包括空气方块）、
    //不建议修改《《《《《《《《《《《《《《《《《《《《《《《《
    private int row = 16, col = 100;
    public Player() {
        item = new Item();
        item.addWeapon("desertEagle");
        item.addWeapon("ak47");

        try {
            //图片读取 图片根目录 Pics
            playerLeft = ImageIO.read(getClass().getResourceAsStream("/playerLeft.png"));
            playerRight = ImageIO.read(getClass().getResourceAsStream("/playerRight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //将玩家画出来
    public void drawPlayer(Graphics g) {
        if (moveDir) {
            g.drawImage(playerRight, 791, playerY - 72, null);
        } else {
            g.drawImage(playerLeft, 782, playerY - 72, null);
        }
        item.getCurrWeapon().drawWeapon((Graphics2D) g, playerY, moveDir);
    }

    //返回玩家面冲方向
    public boolean getdir() {
        return moveDir;
    }
    /*

    //向右移动，默认右键已经按下
    public void moveRight() {
        if (groundLevel >= playerY) {
            playerX += speed;
        }
    }

    //向左移动，默认左键已经按下
    public void moveLeft() {
        if (groundLevel >= playerY) {
            playerX -= speed;
        }
    }

    //边缘检测， 检测是不是撞到墙了
    public void marginDetection() {
        //Right margin detection
        if (playerX >= 2480) {
            playerX = 2480;
        }
        //playerLeft margin detection
        if (playerX <= -2465) {
            playerX = -2465;
        }
    }
    */

    //跳跃时计算向上和向下冲击力
    public void jumping() {
        if (energy_up != 0) {
            playerY -= energy_up;
            energy_up--;
        } else if (playerY < groundLevel) {
            energy_down++;
            playerY += energy_down;
        } else {
            if (playerY - 30 <= groundLevel) {
                playerY = groundLevel;
            }

            //向下冲击展示
            //System.out.println(energy_down+""+jumpEnergy);
            if (energy_down > 20) {
                hitpoint -= (energy_down - 20);
                energy_down = 0;
            }
        }
    }

    //检测玩家是否在地面上，用于判断跳跃可否开始
    public void onTheGround() {
        if (playerY > groundLevel) {
            playerY = groundLevel;
            energy_up = 0;
        } else if (playerY == groundLevel) {
            jump();
        }
    }

    //跳跃开始
    private void jump() {
        if (energy_up == 0) {
            energy_up = jumpEnergy;
            energy_down = 0;
        }
    }

    //检测血量是否低于0
    public boolean alive() {
        return (hitpoint > 0);
    }

    public void gunChange() {
        item.gunChange();
    }

    public Item getItem() {
        return item;
    }
}
