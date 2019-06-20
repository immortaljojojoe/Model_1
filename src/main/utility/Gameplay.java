package utility;

import ui.MapGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gameplay extends JPanel implements ActionListener {
    private MapGenerator map;
    int width, height;
    private int delay = 50;
    private Timer timer;
    // 天空颜色
    private int red = 120, green = 200, blue = 200;
    private Color background = new Color(red, green, blue);
    private boolean darkening = false;
    private boolean brighten = false;

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
        g.setColor(background);
        g.fillRect(0, 0, height - 1, width - 1);
        if (!darkening && !brighten && red < 251) {
            if (red < 200) background = new Color(red++, green, blue);
            if (red >= 200) background = new Color(red++, green--, blue--);
        } else if (red >= 251) {
            darkening = true;
            background = new Color(red--, green--, blue--);
        } else if (darkening && red > 20) {
            if (red > green) {
                red--;
                background = new Color(red--, green--, blue--);
            } else {
                background = new Color(red--, green--, blue--);
            }

        } else if (red <= 20) {
            darkening = false;
            brighten = true;
            background = new Color(red++, green++, blue++);
        }else if(red<=40){
            background = new Color(red++, green++, blue++);
        }else{
            if(green>=200){
                brighten=false;
            }
            green++;
            blue++;
            background = new Color(red++, green++, blue++);
        }

    }

    public void actionPerformed(ActionEvent e) {
        timer.start();
        repaint();
    }
}
