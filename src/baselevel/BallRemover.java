/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-26\5\2020
 * version-13.0.2
 */
package baselevel;

import decorationgame.Counter;
import interfacegame.HitListener;

/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter counter;

    /**
     * Instantiates a new Ball remover.
     *
     * @param game    the game
     * @param counter the counter
     */
    public BallRemover(GameLevel game, Counter counter) {
        this.game = game;
        this.counter = counter;
    }

    /**
     * hitEvent.remove the ball from the game,and decrease the counter.
     *
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.counter.decrease(1);
    }
}
