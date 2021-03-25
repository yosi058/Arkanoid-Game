/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-9\6\2020
 * version-13.0.2
 */

package rungame;


import baselevel.GameLevel;
import biuoop.KeyboardSensor;
import decorationgame.Counter;
import interfacegame.LevelInformation;

import java.util.List;


/**
 * The type Game flow.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter counter;
    private boolean win = true;


    /**
     * Instantiates a new Game flow.
     *
     * @param ar      the ar
     * @param ks      the ks
     * @param counter the counter
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, Counter counter) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.counter = counter;
    }


    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.animationRunner, this.keyboardSensor, this.counter);
            level.initialize();
            while ((level.getCounterBalls().getValue() != 0) && (level.getCounterBlocks().getValue() != 0)) {
                level.run();
            }
            //
            if (level.getCounterBalls().getValue() == 0) {
                this.win = false;
                break;
            }
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                KeyboardSensor.SPACE_KEY,
                new EndScreen(this.win, this.counter)));
    }
}

