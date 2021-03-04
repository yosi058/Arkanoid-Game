/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-26\5\2020
 * version-13.0.2
 */
package decorationgame;

import baselevel.GameLevel;
import biuoop.DrawSurface;
import interfacegame.Sprite;
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private Counter counter;
    private String string;

    /**
     * Instantiates a new Score indicator.
     *
     * @param counter the counter
     * @param string  the string
     */
    public ScoreIndicator(Counter counter, String string) {
        this.counter = counter;
        this.string = "Level Game: " + string;
    }

    /**
     * @param d the d DrawSurface
     */
    @Override
    public void drawOn(DrawSurface d) {
        Point p = new Point(0, 0);
        Rectangle rectangle = new Rectangle(p, GameLevel.WIDTH_OF_GUI, 20);
        d.setColor(Color.WHITE);
        d.fillRectangle((int) p.getX(), (int) p.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.BLACK);
        d.drawText(360, 17, "Score:" + counter.getValue(), 17);
        d.drawText(590, 17, this.string, 17);
    }

    @Override
    public void timePassed() {
    }
}
