/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-9\6\2020
 * version-13.0.2
 */

package rungame;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfacegame.Animation;

/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param keyboardSensor the keyboard sensor
     * @param key            the key
     * @param animation      the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor keyboardSensor, String key, Animation animation) {
        this.keyboardSensor = keyboardSensor;
        this.animation = animation;
        this.key = key;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (!this.keyboardSensor.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
        this.animation.doOneFrame(d);
        if (this.keyboardSensor.isPressed(this.key)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
            }
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}
