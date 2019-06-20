package utility;
import ui.MapGenerator;

import javax.swing.*;

public class Gameplay extends JPanel{
    private MapGenerator map;
    Gameplay(int width, int height){
        map = new MapGenerator(width,height);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        //timer = new Timer(delay, this);
        //timer.start();
    }
}
