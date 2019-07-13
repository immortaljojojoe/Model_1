package utility;

import scene.Sky;
import scene.Sun;
import ui.MapGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gameplay extends JPanel implements ActionListener {

    int width, height;
    private int delay = 100;
    private Timer timer;
    // 天空
    private Sky sky= new Sky();
    //太阳
    private Sun sun= new Sun(50);
    //地图块 MapGenerator[i][j];
    private MapGenerator mapGenerator;


    Gameplay(int width, int height) {
        this.width = width;
        this.height = height;
        mapGenerator = new MapGenerator(width, height);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        g.setColor(sky.getSky_color());
        g.fillRect(0, 0, width - 1, height - 1);
        g.setColor(sun.getColor());
        g.fillOval(sun.x(),sun.y(),sun.getSun_radius()*2,sun.getSun_radius()*2);
        mapGenerator.draw((Graphics2D) g);
        g.dispose();

    }

    public void actionPerformed(ActionEvent e) {
        timer.start();
        sky.refreshColor();
        sun.refreshPlace();
        repaint();
    }
}
