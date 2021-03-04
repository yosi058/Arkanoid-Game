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
 * The type Final four drew on.
 */
public class FinalFourDrewOn implements Sprite {
    private Rectangle rectangle;

    /**
     * Instantiates a new Final four drew on.
     *
     * @param rectangle the rectangle
     */
    public FinalFourDrewOn(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void drawOn(DrawSurface d) {
        final int tempX = 30;
        final int tempY = 50;
        final int width = 30;
        final int height = 30;
        int startX = tempX;
        int startY = tempY;
        Point p = this.rectangle.getUpperLeft();
        d.setColor(Color.green);
        d.fillRectangle((int) p.getX(), (int) p.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 30; j++) {
                d.setColor(getColors()[j % 2]);
                d.fillRectangle(startX, startY, width, height);
                d.setColor(Color.BLACK);
                d.drawRectangle(startX, startY, width, height);
                startX = startX + width;
            }
            startX = tempX;
            startY = startY + height;
        }
    }

    @Override
    public void timePassed() {

    }

    /**
     * @return Color[].
     */
    private Color[] getColors() {
        Color[] arrayColor = new Color[2];
        arrayColor[0] = Color.cyan;
        arrayColor[1] = Color.darkGray;
        return arrayColor;
    }
}
