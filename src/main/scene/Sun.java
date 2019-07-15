package scene;

import java.awt.*;

public class Sun {
    private int sun_radius;
    private int x,y;
    private Color sun_color= new Color(240,150,50);
    public Sun(int size){
        sun_radius =size;
        x=-size/2;
        y = 30;
    }
    public int getSun_radius(){
        return sun_radius;
    }
    public int x(){
        return x;
    }
    public int y(){
        return y;
    }
    public Color getColor(){
        return sun_color;
    }
    public void refreshPlace(){
        if(x>3700){x=-280;}
        x++;
    }

}
