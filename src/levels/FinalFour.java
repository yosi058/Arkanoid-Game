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
 * The type Final four.
 */
public class FinalFour implements LevelInformation {
    private int numOfBlocks = 0;

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        final int angels = 360;
        final int speed = 5;
        List<Velocity> velocities = new ArrayList<>();
        double angle = angels;
        for (int i = 0; i < 3; i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed(angle, speed);
            velocities.add(velocity);
            angle = angle - 60;
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 15;
    }

    @Override
    public int paddleWidth() {
        return 90;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), GameLevel.WIDTH_OF_GUI, GameLevel.HEIGHT_OF_GUI);
        return new FinalFourDrewOn(rectangle);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        final double startBlockX = 30;
        final double startBlockY = 150;
        final double widthBlock = (GameLevel.WIDTH_OF_BLOCK - GameLevel.HEIGHT_OF_BLOCK) / 15;
        final double heightBlock = 20;
        Color[] arrayColor = getColors();
        double px = startBlockX;
        double py = startBlockY;
        double temp = px;
        for (int i = 0; i < 7; i++) {
            Color randomColor = arrayColor[i];
            for (int j = 0; j < 15; j++) {
                Point p = new Point(px, py);
                Block block = new Block(p, widthBlock + 1, heightBlock, randomColor);
                blocks.add(block);
                this.numOfBlocks++;
                px = px + widthBlock;
            }
            px = startBlockX;
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
        Color[] arrayColor = new Color[7];
        arrayColor[0] = Color.GRAY;
        arrayColor[1] = Color.RED;
        arrayColor[2] = Color.YELLOW;
        arrayColor[3] = Color.GREEN;
        arrayColor[4] = Color.blue;
        arrayColor[5] = Color.pink;
        arrayColor[6] = Color.orange;
        return arrayColor;
    }
}
