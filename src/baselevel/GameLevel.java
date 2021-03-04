/*
 * @ Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-1\5\2020
 * version-13.0.2
 */
package baselevel;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import decorationgame.Counter;
import decorationgame.ScoreIndicator;
import decorationgame.ScoreTrackingListener;
import decorationgame.SpriteCollection;
import interfacegame.Animation;
import interfacegame.Collidable;
import interfacegame.LevelInformation;
import interfacegame.Sprite;
import rungame.AnimationRunner;
import rungame.CountdownAnimation;
import rungame.KeyPressStoppableAnimation;
import rungame.PauseScreen;
import shapes.Point;

import java.awt.Color;


/**
 * The type Game.creating a new game and initialize the ball,blocks and gameEnvironment.
 */
public class GameLevel implements Animation {
    /**
     * The constant START_BALL_X.
     */
    public static final int START_BALL_X = 400;
    /**
     * The constant START_BALL_Y.
     */
    public static final int START_BALL_Y = 550;

    /**
     * The constant WIN_POINTS.
     */
    public static final int WIN_POINTS = 100;
    /**
     * The constant WIDTH.the width of the board.
     */
    public static final int WIDTH_OF_GUI = 800;
    /**
     * The constant HEIGHT.the height of the board.
     */
    public static final int HEIGHT_OF_GUI = 600;
    /**
     * The constant WIDTH_OF_BLOCK.the width block of the boarder.
     */
    public static final double WIDTH_OF_BLOCK = 770;
    /**
     * The constant HEIGHT_OF_BLOCK.the height of the block border.
     */
    public static final double HEIGHT_OF_BLOCK = 30;

    private SpriteCollection sprites;
    private GameEnvironment gameEnvironment;
    private Counter counterBlocks = new Counter(0);
    private Counter counterBalls = new Counter(0);
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;


    /**
     * Instantiates a new Game.created a new instance of SpriteCollection and GameEnvironment.
     *
     * @param levelInformation the level information
     * @param animationRunner  the animation runner
     * @param keyboardSensor   the keyboard sensor
     * @param score            the score
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner animationRunner
            , KeyboardSensor keyboardSensor, Counter score) {
        this.sprites = new SpriteCollection();
        this.gameEnvironment = new GameEnvironment();
        this.levelInformation = levelInformation;
        this.keyboard = keyboardSensor;
        this.runner = animationRunner;
        this.score = score;
    }

    /**
     * Gets game environment.
     *
     * @return the game environment
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * Add collidable.get a Collidable and add him to the game.
     *
     * @param c the c Collidable.
     */
    public void addCollidable(Collidable c) {
        this.gameEnvironment.addCollidable(c);
    }

    /**
     * Add sprite.get a sprite and add him to the game.
     *
     * @param s the s Sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }


    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        this.sprites.addSprite(this.levelInformation.getBackground());
        Paddle paddle = new Paddle(this.keyboard, this.levelInformation.paddleSpeed(),
                this.levelInformation.paddleWidth());
        paddle.addToGame(this);
        //create the limit of the board and the blocks in the screen,and add the, to the game.
        createBoards();
        createBlocks();
        crateBalls();
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score, this.levelInformation.levelName());
        this.addSprite(scoreIndicator);
    }

    /**
     * Run.Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * Remove collidable, form the game.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        this.gameEnvironment.getCollidables().remove(c);
    }

    /**
     * Remove sprite from the game.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSprites().remove(s);
    }

    /**
     * Create boards.create the limit of the board by blocks.
     */
    public void createBoards() {
        BallRemover ballRemover = new BallRemover(this, this.counterBalls);
        Point p1 = new Point(0, 20);
        Block upBorder = new Block(p1, WIDTH_OF_GUI, HEIGHT_OF_BLOCK, Color.GRAY);
        upBorder.addToGame(this);
        Point p2 = new Point(0, 50);
        Block leftBorder = new Block(p2, HEIGHT_OF_BLOCK, WIDTH_OF_BLOCK, Color.GRAY);
        leftBorder.addToGame(this);
        Point p3 = new Point(770, 50);
        Block rightBorder = new Block(p3, HEIGHT_OF_BLOCK, WIDTH_OF_BLOCK, Color.GRAY);
        rightBorder.addToGame(this);
        Point p4 = new Point(30, 590);
        Block downBorder = new Block(p4, (WIDTH_OF_BLOCK - HEIGHT_OF_BLOCK), HEIGHT_OF_BLOCK, Color.BLUE);
        downBorder.addToGame(this);
        removeSprite(downBorder);
        downBorder.addHitListener(ballRemover);
    }

    /**
     * Create blocks.create the block inside the game and add them to the game,
     * also add the block remover to the list of listeners of evey block.
     */
    public void createBlocks() {
        BlockRemover blockRemover = new BlockRemover(this, this.counterBlocks);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        for (Block block : this.levelInformation.blocks()) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            this.counterBlocks.increase(1);
        }

    }


    /**
     * Crate balls.created tow balls and add them to the game.
     */
    public void crateBalls() {
        final int radius = 5;
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(START_BALL_X, START_BALL_Y, radius, Color.BLUE);
            ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
            ball.addToGame(this);
            this.counterBalls.increase(1);
        }
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.levelInformation.getBackground().drawOn(d);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen()));
        }
        if (this.counterBlocks.getValue() == 0) {
            this.score.increase(WIN_POINTS);
        }
        if ((this.counterBalls.getValue() == 0) || (this.counterBlocks.getValue() == 0)) {
            this.running = false;
        }

    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Gets counter balls.
     *
     * @return the counter balls
     */
    public Counter getCounterBalls() {
        return counterBalls;
    }

    /**
     * Gets counter blocks.
     *
     * @return the counter blocks
     */
    public Counter getCounterBlocks() {
        return counterBlocks;
    }
}