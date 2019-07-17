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
    //界面长与宽
    int width, height;
    //游戏开始
    //TODO 开始界面的设计
    private boolean play = false;
    //每一帧的速度
    //修改以改变游戏速度
    private int delay = 15;
    //计时器
    private Timer timer;
    // 天空
    private Sky sky= new Sky();
    //太阳
    private Sun sun= new Sun(50);
    //地图块 MapGenerator[i][j];
    private MapGenerator mapGenerator;
    //检测左右键是否被按下
    private boolean rightKeyPressed = false;
    private boolean leftKeyPressed = false;
    //人物
    private Player player;
    //地图图块个数
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
            //测试数据
            //x轴位置（图块）校对版本
            g.setColor(Color.BLACK);
            g.setFont(new Font("cerif", Font.BOLD, 20));
            g.drawString("X.Postion:" + (player.player_col), 1400, 30);
            //y轴位置（图块）校对版本
            g.drawString("Y.Postion:" + (11 - player.player_row), 1400, 50);
            g.drawString("FPS:" + 1000 / delay, 1400, 70);
            //血量展示
            g.setFont(new Font("cerif", Font.BOLD, 15));
            g.drawString("HP:" + player.hitpoint, 5, 20);
            //health bar
            //血条展示
            g.setColor(Color.BLACK);
            g.fillRect(68, 5, 104, 16);
            g.setColor(Color.RED);
            g.fillRect(70, 7, player.hitpoint, 12);
            //人物绘画
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
        //天空变色
        sky.refreshColor();
        //太阳移动
        sun.refreshPlace();
        if (play) {
            //walk Left and Right
            if (rightKeyPressed) {
                player.moveRight();

            } else if (leftKeyPressed) {
                player.moveLeft();

            }
            //margin checking
            player.marginDetection();
            //Jumping UI 2.0
            player.jumping();
            player.groundLevel = mapGenerator.currGround(player.player_col);
            System.out.println(player.groundLevel);

            player.player_col = (player.playerX / (width / col));
            player.player_row = (player.playerY / (height / row));
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightKeyPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftKeyPressed = false;
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
        rightKeyPressed = true;
        leftKeyPressed = false;
        player.moveDir = true;
    }

    private void moveLeft() {
        leftKeyPressed = true;
        rightKeyPressed = false;
        player.moveDir = false;
    }
}
