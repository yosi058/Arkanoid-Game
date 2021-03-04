/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-26\5\2020
 * version-13.0.2
 */
package interfacegame;


import baselevel.Ball;
import baselevel.Block;

/**
 * The interface Hit listener.
 */
public interface HitListener {
    /**
     * Hit event.This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    void hitEvent(Block beingHit, Ball hitter);
}
