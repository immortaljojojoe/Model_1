package scene;

import java.awt.*;

public class Sky {
    private Color sky_color;
    private boolean darkening = false;
    private boolean brighten = false;
    private int red = 120, green = 200, blue = 200;
    private int counter = 0;

    public Sky() {
        sky_color = new Color(red, green, blue);
    }

    public Color getSky_color() {
        return sky_color;
    }

    public void refreshColor() {
        if(counter==10){
            if (!darkening && !brighten && red < 251) {
                if (red < 200) sky_color = new Color(red++, green, blue);
                if (red >= 200) sky_color = new Color(red++, green--, blue--);
            } else if (red >= 251) {
                darkening = true;
                sky_color = new Color(red--, green--, blue--);
            } else if (darkening && red > 20) {
                if (red > green) {
                    red--;
                    sky_color = new Color(red--, green--, blue--);
                } else {
                    sky_color = new Color(red--, green--, blue--);
                }

            } else if (red <= 20) {
                darkening = false;
                brighten = true;
                sky_color = new Color(red++, green++, blue++);
            } else if (red <= 40) {
                sky_color = new Color(red++, green++, blue++);
            } else {
                if (green >= 200) {
                    brighten = false;
                }
                green++;
                blue++;
                sky_color = new Color(red++, green++, blue++);
            }
            counter=0;
        }else{counter++;}

    }
}
