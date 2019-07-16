package data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player {//玩家专属class
    // HP :血量
    public int hitpoint = 100;

    //the coordinate of the center of the player
    //玩家x轴中心坐标
    //修改以改变初始站立x坐标（默认基值 210）《《《《《《《《《《《《《《《《《《《《《《《《《《《《《
    public int playerX = 210;

    //the lower coordinate of the player
    //玩家站立海拔，以玩家脚踩高度（最低y值）
    //TODO 用currGround（GamePlay）改变初始值
    public int playerY = 600;

    //the direction of moving
    //玩家面向方向
    public boolean moveDir = true;
    //初始地面高度，按照玩家站立位置决定
    //TODO 按照玩家站立列数来改变初始值
    public int groundLevel = 600;
    public int player_col = (playerX / (1600 / col));
    //private int player_width=20;
    //弹跳力剩余
    int energy_up = 0;
    //向下冲击力计算
    int energy_down = 0;
    //起跳高度 以（n+1）n/2为准//
    //修改以改变玩家起跳力度（默认基值 14）《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《
    int jumpEnergy = 14;//height jump
    //人物奔跑速度
    //修改以改变人物奔跑速度（默认基值 4）《《《《《《《《《《《《《《《《《《《《《《
    int speed = 4;//the moving speed
    //人物图片
    private BufferedImage left, right;
    //地图方格个数 row为行数 col为列数（包括空气方块）、
    //不建议修改《《《《《《《《《《《《《《《《《《《《《《《《
    private int row = 16, col = 32;
    //玩家所在行与列
    public int player_row = (playerY / (800 / row));
    public Player() {
        try {
            //图片读取 图片根目录 Pics
            left = ImageIO.read(getClass().getResourceAsStream("/left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //将玩家画出来
    public void drawPlayer(Graphics g) {
        if (moveDir) {
            g.drawImage(right, playerX - 14, playerY - 72, null);
        } else {
            g.drawImage(left, playerX - 14, playerY - 72, null);
        }
    }

    //返回玩家面冲方向
    public boolean getdir() {
        return moveDir;
    }

    //向右移动，默认右键已经按下
    public void moveRight() {
        if (groundLevel >= playerY) {
            playerX += speed;
        } else {
            playerX -= speed + 3;
        }
    }

    //向左移动，默认左键已经按下
    public void moveLeft() {
        if (groundLevel >= playerY) {
            playerX -= speed;
        } else {
            playerX += speed + 3;
        }
    }

    //边缘检测， 检测是不是撞到墙了
    public void marginDetection() {
        //Right margin detection
        if (playerX >= 1580) {
            playerX = 1580;
        }
        //left margin detection
        if (playerX <= 15) {
            playerX = 15;
        }
    }

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
}
