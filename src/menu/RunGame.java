package menu;

import biuoop.KeyboardSensor;
import decorationgame.Counter;
import interfacegame.LevelInformation;
import interfacegame.Task;
import rungame.AnimationRunner;
import rungame.GameFlow;
import rungame.KeyPressStoppableAnimation;

import java.util.List;


public class RunGame implements Task<Void> {
    private List<LevelInformation> levelInf;
    private GameFlow game;
    private AnimationRunner runner;
    private KeyboardSensor keyboardSensor;
    private Counter counter;

    public RunGame(List<LevelInformation> list, GameFlow game, AnimationRunner runner, KeyboardSensor k, Counter counter) {
        this.levelInf = list;
        this.game = game;
        this.runner = runner;
        this.keyboardSensor = k;
        this.counter = counter;
    }

    @Override
    public Void run() {
        counter.setCounter(0);
        this.game.runLevels(this.levelInf);
        this.runner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                KeyboardSensor.SPACE_KEY,
                new HighScoresAnimation(this.counter)));
        return null;
    }
}
