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

/**
 * The type Diret hit drew on.
 */
public class DiretHitDrewOn implements Sprite {
    private Rectangle rectangle;

    /**
     * Instantiates a new Diret hit drew on.
     *
     * @param rectangle the rectangle
     */
    public DiretHitDrewOn(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void drawOn(DrawSurface d) {
        Point p = this.rectangle.getUpperLeft();
        d.setColor(Color.BLACK);
        d.fillRectangle((int) p.getX(), (int) p.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.white);
        d.drawCircle(400, 165, 50);
        d.drawCircle(400, 165, 100);
        d.drawCircle(400, 165, 150);
        d.drawLine(375 - 150, 165, 375, 165);
        d.drawLine(425, 165, 425 + 150, 165);
        d.drawLine(400, 140, 400, 140 - 150);
        d.drawLine(400, 175, 400, 175 + 150);
    }

    @Override
    public void timePassed() {

    }
}
