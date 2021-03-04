/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-1\5\2020
 * version-13.0.2
 */
package baselevel;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import decorationgame.Velocity;
import interfacegame.Collidable;
import interfacegame.Sprite;
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;

/**
 * The type Paddle.
 */
public class Paddle implements Sprite, Collidable {
    /**
     * The constant START_PADDLE_Y.
     */
    public static final int START_PADDLE_Y = 555;
    /**
     * The constant HEIGHT_PADDLE.
     */
    public static final int HEIGHT_PADDLE = 15;

    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private Color color;
    private int move;
    private double width;


    /**
     * Instantiates a new Paddle.
     *
     * @param keyboard  the keyboard
     * @param rectangle the rectangle
     * @param color     the color
     */
    public Paddle(KeyboardSensor keyboard, Rectangle rectangle, Color color) {
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.color = color;
    }

    /**
     * Instantiates a new Paddle.
     *
     * @param keyboard the keyboard
     * @param move     the move steps
     * @param width    of the paddle.
     */
    public Paddle(KeyboardSensor keyboard, int move, double width) {
        this.keyboard = keyboard;
        this.width = width;
        this.rectangle = new Rectangle((GameLevel.WIDTH_OF_GUI - this.width) / 2,
                START_PADDLE_Y, width, HEIGHT_PADDLE);
        this.move = move;
        this.color = Color.ORANGE;
    }

    /**
     * Move left.make the paddle move 10 steps left.
     * and also make sure he is not going out of the screen
     */
    public void moveLeft() {
        Point p = this.rectangle.getUpperLeft();
        p = new Point(p.getX() - this.move, p.getY());
        if (p.getX() < GameLevel.HEIGHT_OF_BLOCK) {
            p = new Point(GameLevel.HEIGHT_OF_BLOCK, p.getY());
        }
        this.rectangle.setUpperLeft(p);
    }

    /**
     * Move right.make the paddle move 10 steps right.
     * and also make sure he is not going out of the screen.
     */
    public void moveRight() {
        Point p = this.rectangle.getUpperLeft();
        p = new Point(p.getX() + this.move, p.getY());
        if (p.getX() + rectangle.getWidth() > GameLevel.WIDTH_OF_BLOCK) {
            p = new Point(GameLevel.WIDTH_OF_BLOCK - rectangle.getWidth(), p.getY());
        }
        this.rectangle.setUpperLeft(p);
    }

    /**
     * draw on the Rectangle and fill is edge with black.
     *
     * @param d the  DrawSurface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        Rectangle r = this.getCollisionRectangle();
        Point p = r.getUpperLeft();
        d.fillRectangle((int) p.getX(), (int) p.getY(), (int) r.getWidth(), (int) r.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) p.getX(), (int) p.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * timePassed.checking which Key has pressed,and call his function respectively.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * @return this Rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * hit.checking where the ball hit the paddle and changing his velocity.
     *
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @param hitter          the hitter
     * @return a new Velocity after the chang.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v = currentVelocity;
        v = partRectangle(collisionPoint, v);
        //if he hit the paddle on the sides.
        if (v == currentVelocity) {
            v.setDx(-v.gexDx());
        }
        return v;
    }

    /**
     * Add to game.add the paddle to the game.
     * paddle is both- collaidable and sprite.
     *
     * @param g the g game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * Part rectangle velocity. get a point and a velocity anf chang it
     * according to where the ball hit in the rectangle.
     *
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the velocity after the chane.
     */
    public Velocity partRectangle(Point collisionPoint, Velocity currentVelocity) {
        Velocity v = currentVelocity;
        double speed = v.fromVelocityToSpeed(v);
        double partW = this.rectangle.getWidth() / 5;
        double leftPoint = this.rectangle.getUpperLeft().getX();
        double x = collisionPoint.getX();
        if (inRange(x, leftPoint, leftPoint + partW)) {
            v = Velocity.fromAngleAndSpeed(300, speed);
        } else if (inRange(x, leftPoint + partW, leftPoint + (2 * partW))) {
            v = Velocity.fromAngleAndSpeed(330, speed);
        } else if (inRange(x, leftPoint + (2 * partW), leftPoint + (3 * partW))) {
            v.setDy(-v.gexDy());
        } else if (inRange(x, leftPoint + (3 * partW), leftPoint + (4 * partW))) {
            v = Velocity.fromAngleAndSpeed(30, speed);
        } else if (inRange(x, leftPoint + (4 * partW), leftPoint + (5 * partW))) {
            v = Velocity.fromAngleAndSpeed(60, speed);
        }
        return v;
    }

    /**
     * In range boolean.checking if the x is between the min of the tow parts,
     * and also if he smaller than the Max of them.
     *
     * @param x     the x
     * @param part1 the part 1
     * @param part2 the part 2
     * @return the boolean if the x is in range,false otherwise.
     */
    public boolean inRange(double x, double part1, double part2) {
        return (x >= part1) && ((x <= part2));
    }
}