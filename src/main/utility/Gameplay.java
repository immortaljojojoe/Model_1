package utility;

import scene.Sky;
import ui.MapGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gameplay extends JPanel implements ActionListener {
    private MapGenerator map;
    int width, height;
    private int delay = 10;
    private Timer timer;
    // 天空
    private Sky sky= new Sky();


    Gameplay(int width, int height) {
        this.width = width;
        this.height = height;
        map = new MapGenerator(width, height);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        g.setColor(sky.getSky_color());
        g.fillRect(0, 0, width - 1, height - 1);

    }

    public void actionPerformed(ActionEvent e) {
        timer.start();
        sky.refreshColor();
        repaint();
    }
}
