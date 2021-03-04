/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-10\6\2020
 * version-13.0.2
 */

package levels;

import biuoop.DrawSurface;
import interfacegame.Sprite;
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;
import java.util.Random;

/**
 * The type Wide easy drew on.
 */
public class WideEasyDrewOn implements Sprite {
    private Rectangle rectangle;

    /**
     * Instantiates a new Wide easy drew on.
     *
     * @param rec the rec
     */
    public WideEasyDrewOn(Rectangle rec) {
        this.rectangle = rec;
    }

    @Override
    public void drawOn(DrawSurface d) {
        int wight = 800 / 2;
        int hight = 600 / 2;
        Point p = this.rectangle.getUpperLeft();
        d.setColor(Color.white);
        d.fillRectangle((int) p.getX(), (int) p.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        Random rand = new Random();
        int radius = 25;
        for (int i = 1; i < 20; i++) {
            Color randomColor = new Color(rand.nextInt(0xFFFFFF));
            d.setColor(randomColor);
            d.drawOval(wight - (radius * i), hight - (radius * i), ((2 * i) * radius), ((2 * i) * radius));
        }
    }

    @Override
    public void timePassed() {

    }
}
