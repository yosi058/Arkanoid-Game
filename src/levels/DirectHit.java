/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-10\6\2020
 * version-13.0.2
 */

package levels;

import baselevel.Block;
import baselevel.GameLevel;
import decorationgame.Velocity;
import interfacegame.LevelInformation;
import interfacegame.Sprite;
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Direct hit.
 */
public class DirectHit implements LevelInformation {
    private int numOfBlocks = 0;


    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        Velocity velocity = Velocity.fromAngleAndSpeed(360, 5);
        v.add(velocity);
        return v;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), GameLevel.WIDTH_OF_GUI, GameLevel.HEIGHT_OF_GUI);
        return new DiretHitDrewOn(rectangle);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Block block = new Block(new Rectangle(385, 150, 30, 30), Color.RED);
        blocks.add(block);
        this.numOfBlocks++;
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numOfBlocks;
    }
}
