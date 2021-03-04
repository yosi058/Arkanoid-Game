/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-9\6\2020
 * version-13.0.2
 */

package rungame;


import baselevel.GameLevel;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import decorationgame.SpriteCollection;
import interfacegame.Animation;

import java.awt.Color;

/**
 * The type Countdown animation.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private int countDown;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.stop = false;
        this.countDown = countFrom;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        double millisecondsPerFrame = 667 * (numOfSeconds / countFrom);
        long startTime = System.currentTimeMillis();
        Sleeper sleeper = new Sleeper();
        d.fillRectangle(0, 0, GameLevel.WIDTH_OF_GUI, GameLevel.HEIGHT_OF_GUI);
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.RED);
        if (countDown > 0) {
            d.drawText(350, d.getHeight() / 2, (countDown) + " ", 150);
            countDown--;
        } else {
            this.stop = true;
        }
        if (countDown == 2) {
            return;
        }
        double usedTime = System.currentTimeMillis() - startTime;
        long milliSecondLeftToSleep = (long) (millisecondsPerFrame - usedTime);
        if (milliSecondLeftToSleep > 0) {
            sleeper.sleepFor(milliSecondLeftToSleep);
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
