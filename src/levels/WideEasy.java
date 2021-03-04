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
 * The type Wide easy.
 */
public class WideEasy implements LevelInformation {
    private int numOfBlocks = 0;


    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        double angle = 360;
        for (int i = 1; i <= this.numberOfBalls(); i++) {
            if (i <= this.numberOfBalls() / 2) {
                Velocity velocity = Velocity.fromAngleAndSpeed((angle / 6) - (10 * i), 8);
                velocities.add(velocity);
            } else {
                Velocity velocity = Velocity.fromAngleAndSpeed(angle - 10, 8);
                velocities.add(velocity);
                angle = angle - 10;
            }
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), GameLevel.WIDTH_OF_GUI, GameLevel.HEIGHT_OF_GUI);
        return new WideEasyDrewOn(rectangle);
    }

    @Override
    public List<Block> blocks() {
        Point p = new Point(30, 250);
        double width = (GameLevel.WIDTH_OF_BLOCK - GameLevel.HEIGHT_OF_BLOCK) / 15;
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Block block = new Block(new Rectangle(p, width + 1, 25), getColors()[i]);
            blocks.add(block);
            p = new Point(p.getX() + width, p.getY());
            this.numOfBlocks++;
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numOfBlocks;
    }

    /**
     * this function create a array of colors and return it.
     *
     * @return Color [] with number of colors.
     */
    private Color[] getColors() {
        Color[] arrayColor = new Color[15];
        arrayColor[0] = Color.RED;
        arrayColor[1] = Color.RED;
        arrayColor[2] = Color.orange;
        arrayColor[3] = Color.orange;
        arrayColor[4] = Color.yellow;
        arrayColor[5] = Color.yellow;
        arrayColor[6] = Color.GREEN;
        arrayColor[7] = Color.GREEN;
        arrayColor[8] = Color.GREEN;
        arrayColor[9] = Color.blue;
        arrayColor[10] = Color.blue;
        arrayColor[11] = Color.pink;
        arrayColor[12] = Color.PINK;
        arrayColor[13] = Color.cyan;
        arrayColor[14] = Color.cyan;
        return arrayColor;
    }
}
