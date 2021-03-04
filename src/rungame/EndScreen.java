/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-9\6\2020
 * version-13.0.2
 */

package rungame;

import baselevel.Ball;
import baselevel.GameLevel;
import biuoop.DrawSurface;
import decorationgame.Counter;
import interfacegame.Animation;

import java.awt.Color;
import java.util.Random;

/**
 * The type End screen.
 */
public class EndScreen implements Animation {
    private boolean win;
    private Counter score;
    private boolean shouldStop;

    /**
     * Instantiates a new End screen.
     *
     * @param win   the win
     * @param score the score
     */
    public EndScreen(boolean win, Counter score) {
        this.win = win;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        final int radius = 4;
        d.setColor(Color.red);
        d.fillRectangle(0, 0, 800, 600);
        Random rand = new Random();
        if (this.win) {
            d.setColor(Color.cyan);
            d.fillRectangle(0, 0, 800, 600);
            for (int i = 0; i < 100; i++) {
                Color randomColor = new Color(rand.nextInt(0xFFFFFF));
                int x1 = rand.nextInt(GameLevel.WIDTH_OF_GUI);
                int y1 = rand.nextInt(GameLevel.HEIGHT_OF_GUI);
                Ball ball = new Ball(x1, y1, radius, randomColor);
                ball.drawOn(d);
            }
            d.setColor(Color.white);
            d.drawText(20, d.getHeight() / 2, "You Win! Your score is " + this.score.getValue(),
                    50);
            d.drawText(20, (d.getHeight() / 2) + 80, "Press space to continue", 50);
        } else {
            d.setColor(Color.BLACK);
            d.drawText(20, d.getHeight() / 2, "Game Over. Your score is " + this.score.getValue(),
                    50);
            d.drawText(20, (d.getHeight() / 2) + 80, "Press space to continue", 50);
        }
    }

    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }

}
