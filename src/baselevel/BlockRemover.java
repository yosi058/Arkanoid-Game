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
 * The type Block remover.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param game            the game
     * @param remainingBlocks the remaining blocks
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * hitEvent.remove the block from the game.
     *
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}