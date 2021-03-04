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
 * The type Green 3 drew on.
 */
public class Green3DrewOn implements Sprite {
    private Rectangle rectangle;

    /**
     * Instantiates a new Green 3 drew on.
     *
     * @param rec the rec
     */
    public Green3DrewOn(Rectangle rec) {
        this.rectangle = rec;
    }

    @Override
    public void drawOn(DrawSurface d) {
        Point p = this.rectangle.getUpperLeft();
        d.setColor(Color.green);
        d.fillRectangle((int) p.getX(), (int) p.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());

        d.setColor(Color.darkGray);
        d.fillRectangle(80, 400, 120, 200);
        int startX = 90;
        int startY = 415;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.setColor(Color.white);
                d.fillRectangle(startX, startY, 15, 25);
                startX = startX + 22;
            }
            startX = 90;
            startY = startY + 40;
        }
        d.setColor(Color.darkGray);
        d.fillRectangle(120, 340, 40, 60);
        d.fillRectangle(135, 260, 13, 80);
        d.setColor(Color.orange);
        d.fillCircle(142, 251, 10);
        d.setColor(Color.red);
        d.fillCircle(142, 251, 7);
        d.setColor(Color.white);
        d.fillCircle(142, 251, 5);
        d.setColor(Color.darkGray);
        d.fillRectangle(600, 485, 100, 120);
        int startHouseX = 610;
        int startHouseY = 495;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                d.setColor(Color.white);
                d.fillRectangle(startHouseX, startHouseY, 15, 25);
                startHouseX = startHouseX + 22;
            }
            startHouseY = startHouseY + 35;
            startHouseX = 610;
        }
        d.setColor(Color.darkGray);
        d.drawLine(600, 485, 650, 443);
        d.drawLine(650, 442, 700, 485);
    }

    @Override
    public void timePassed() {

    }
}
