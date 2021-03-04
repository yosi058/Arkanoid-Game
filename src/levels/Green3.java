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
 * The type Green 3.
 */
public class Green3 implements LevelInformation {
    private int numOfBlocks = 0;


    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        Velocity velocity1 = Velocity.fromAngleAndSpeed(330, 5);
        velocities.add(velocity1);
        Velocity velocity2 = Velocity.fromAngleAndSpeed(30, 5);
        velocities.add(velocity2);
        return velocities;
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), GameLevel.WIDTH_OF_GUI, GameLevel.HEIGHT_OF_GUI);
        return new Green3DrewOn(rectangle);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        final double startBlockX = 320;
        final double startBlockY = 190;
        final double widthBlock = 45;
        final double heightBlock = 20;
        Color[] arrayColor = getColors();
        double px = startBlockX;
        double py = startBlockY;
        double temp = px;
        for (int i = 0; i < 5; i++) {
            Color randomColor = arrayColor[i];
            for (int j = 0; j < 10 - i; j++) {
                Point p = new Point(px, py);
                Block block = new Block(p, widthBlock, heightBlock, randomColor);
                blocks.add(block);
                this.numOfBlocks++;
                px = px + widthBlock;
            }
            px = temp + widthBlock;
            temp = temp + widthBlock;
            py = py + heightBlock;
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numOfBlocks;
    }

    /**
     * @return Color[].
     */
    private Color[] getColors() {
        Color[] arrayColor = new Color[5];
        arrayColor[0] = Color.GRAY;
        arrayColor[1] = Color.RED;
        arrayColor[2] = Color.YELLOW;
        arrayColor[3] = Color.BLUE;
        arrayColor[4] = Color.WHITE;
        return arrayColor;
    }
}
