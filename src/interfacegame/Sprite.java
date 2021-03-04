/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-29\4\2020
 * version-13.0.2
 */
package interfacegame;

import biuoop.DrawSurface;

/**
 * The interface Sprite..interface that will be implements with the ball,paddle and blocks in the game.
 * and each one of them implements the function different from the other.
 */
public interface Sprite {
    /**
     * Draw on.draw the all sprite to the screen.
     *
     * @param d the d
     */

    void drawOn(DrawSurface d);

    /**
     * Time passed. notify the sprite that time has passed,according to there implements.
     */
    void timePassed();
}