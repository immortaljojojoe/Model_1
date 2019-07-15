package utility;

import javax.swing.*;

public class Run {

    public static void main(String[] args) {
        //图像格式
        int width = 1600;
        int height = 830;

        JFrame obj = new JFrame();
        GamePlay gameplay = new GamePlay(width, height);
        obj.setBounds(10, 10, width, height);
        obj.setTitle("World JS");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
    }
}
