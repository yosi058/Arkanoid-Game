/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-26\5\2020
 * version-13.0.2
 */
package decorationgame;

import baselevel.Ball;
import baselevel.Block;
import interfacegame.HitListener;


/**
 * The type Score tracking listener.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * hitEvent.update the point score on the screen.
     *
     * @param beingHit the block.
     * @param hitter   the ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
        beingHit.removeHitListener(this);
    }
}
