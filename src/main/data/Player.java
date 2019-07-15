package data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player {
    public int hitpoint = 100;
    //the coordinate of the center of the player
    public int playerX = 210;
    //the lower coordinate of the player
    public int playerY = 600;

    public boolean moveDir = true;//the direction of moving
    //private int player_width=20;
    int energy_up = 0;
    int energy_down = 0;
    int jumpEnergy = 14;//height jump
    int speed = 4;//the moving speed
    private BufferedImage left, right;
    private int row = 16, col = 32;
    public int player_row = (playerY / (800 / row));
    public int player_col = (playerX / (1600 / col));
    public int groundLevel = 600;
    public Player() {
        try {
            left = ImageIO.read(getClass().getResourceAsStream("/left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawPlayer(Graphics g) {
        if (moveDir) {
            g.drawImage(right, playerX - 14, playerY - 72, null);
        } else {
            g.drawImage(left, playerX - 14, playerY - 72, null);
        }
    }

    public boolean getdir() {
        return moveDir;
    }

    public void moveRight() {
        playerX += speed;
    }

    public void moveLeft() {
        playerX -= speed;
    }

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

    public void jumping() {
        if (energy_up != 0) {
            playerY -= energy_up;
            energy_up--;
        } else if (playerY < groundLevel) {
            energy_down++;
            playerY += energy_down;
        } else {
            playerY = groundLevel;
            //向下冲击展示
            //System.out.println(energy_down+""+jumpEnergy);
            if (energy_down > 14) {
                hitpoint -= (energy_down - 13);
                energy_down = 0;
            }
        }
    }

    public void onTheGround() {
        if (playerY > groundLevel) {
            playerY = groundLevel;
            energy_up = 0;
        } else if (playerY == groundLevel) {
            jump();
        }
    }

    private void jump() {
        if (energy_up == 0) {
            energy_up = jumpEnergy;
            energy_down = 0;
        }
    }

    public boolean alive() {
        return (hitpoint > 0);
    }
}
