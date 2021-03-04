package menu;

import biuoop.KeyboardSensor;
import interfacegame.Animation;
import interfacegame.Task;
import rungame.AnimationRunner;
import rungame.KeyPressStoppableAnimation;

public class ShowHiScoresTask implements Task<Void> {
    private AnimationRunner runner;
    private Animation highScoresAnimation;
    private KeyboardSensor keyboardSensor;


    public ShowHiScoresTask(AnimationRunner runner, Animation highScoresAnimation, KeyboardSensor k) {
        this.runner = runner;
        this.highScoresAnimation = highScoresAnimation;
        this.keyboardSensor = k;
    }

    public Void run() {
        this.runner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                KeyboardSensor.SPACE_KEY,
                highScoresAnimation));
        return null;
    }
}
