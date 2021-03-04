/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-9\6\2020
 * version-13.0.2
 */

package rungame;

import biuoop.DrawSurface;
import interfacegame.Animation;

/**
 * The type Pause screen.
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * Instantiates a new Pause screen.
     */
    public PauseScreen() {
    }

    /**
     * @param d the d
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * @return boolean stop
     */
    public boolean shouldStop() {
        return this.stop;
    }

}
