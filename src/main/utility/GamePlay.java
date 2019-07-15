package utility;

import data.Player;
import scene.Sky;
import scene.Sun;
import ui.MapGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    int width, height;
    private int delay = 15;
    private Timer timer;
    // 天空
    private Sky sky= new Sky();
    //太阳
    private Sun sun= new Sun(50);
    //地图块 MapGenerator[i][j];
    private MapGenerator mapGenerator;

    private boolean rightkeypressed = false;
    private boolean leftkeypressed = false;
    private Player player;

    private int row = 16, col = 32;


    GamePlay(int width, int height) {
        this.width = width;
        this.height = height;
        //开始游戏
        play = true;
        mapGenerator = new MapGenerator(width, height);
        player = new Player();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        if (player.alive()) {
            //天空
            g.setColor(sky.getSky_color());
            g.fillRect(0, 0, width - 1, height - 1);
            //太阳
            g.setColor(sun.getColor());
            g.fillOval(sun.x(), sun.y(), sun.getSun_radius() * 2, sun.getSun_radius() * 2);
            //地图
            Graphics2D g2D = (Graphics2D) g;
            mapGenerator.draw(g2D);
            //g2D.fillOval(200,200,sun.getSun_radius()*2,sun.getSun_radius()*2);

            //data set
            g.setColor(Color.BLACK);
            g.setFont(new Font("cerif", Font.BOLD, 20));
            g.drawString("X.Postion:" + (player.player_col), 1400, 30);
            g.drawString("Y.Postion:" + (11 - player.player_row), 1400, 50);
            g.drawString("FPS:" + 1000 / delay, 1400, 70);
            g.setFont(new Font("cerif", Font.BOLD, 15));
            g.drawString("HP:" + player.hitpoint, 5, 20);
            //health bar
            g.setColor(Color.BLACK);
            g.fillRect(68, 5, 104, 16);
            g.setColor(Color.RED);
            g.fillRect(70, 7, player.hitpoint, 12);

            player.drawPlayer(g);
            g.dispose();
        } else {
            g.setColor(Color.BLACK);
            g.setFont(new Font("cerif", Font.BOLD, 20));
            g.drawString("Game Over", width / 2, height / 2);
        }


    }

    public void actionPerformed(ActionEvent e) {
        timer.start();
        sky.refreshColor();
        sun.refreshPlace();
        if (play) {
            //walk Left and Right
            if (rightkeypressed) {
                player.moveRight();
                player.groundLevel = mapGenerator.currGround(player.player_col);
            } else if (leftkeypressed) {
                player.moveLeft();
                player.groundLevel = mapGenerator.currGround(player.player_col);
            }
            //margin checking
            player.marginDetection();
            //Jumping UI 2.0
            player.jumping();

            player.player_col = (player.playerX / (width / col));
            player.player_row = (player.playerY / (height / row));
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightkeypressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftkeypressed = false;
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.onTheGround();

        }
    }

    private void moveRight() {
        rightkeypressed = true;
        leftkeypressed = false;
        player.moveDir = true;
    }

    private void moveLeft() {
        leftkeypressed = true;
        rightkeypressed = false;
        player.moveDir = false;
    }
}
