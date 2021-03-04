/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-29\4\2020
 * version-13.0.2
 */
package baselevel;

import biuoop.DrawSurface;
import decorationgame.CollisionInfo;
import decorationgame.Velocity;
import interfacegame.Sprite;
import shapes.Line;
import shapes.Point;

/**
 * The type Ball.created a ball with velocity that he can move.
 */
public class Ball implements Sprite {
    /**
     * The constant SMALL.
     */
    public static final double SMALL = 0.65;

    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * Instantiates a new Ball.
     *
     * @param center the center point
     * @param r      the r radios
     * @param color  the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * Instantiates a new Ball.
     * second constructor.
     *
     * @param x     the x of the point
     * @param y     the y of the point
     * @param r     the r the radios
     * @param color the color
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    /**
     * Instantiates a new Ball.
     *
     * @param x               the x
     * @param y               the y
     * @param r               the r
     * @param color           the color
     * @param gameEnvironment the game environment
     */
    public Ball(int x, int y, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Gets x.
     *
     * @return the x of the  center point.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Gets y.
     *
     * @return the y of the center point.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets size.
     *
     * @return the size of the radios
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Gets color.
     *
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draw on.the function get a color of the ball and fillCircle the center point with the radios.
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Gets game environment.
     *
     * @return the game environment
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * Sets velocity.
     *
     * @param v the velosity.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets velocity.the function created a new velosity with dx,dy.
     *
     * @param dx the velosity of the x axes
     * @param dy the velosity of the y axes
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Gets velocity.
     *
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Move one step.This function have ton know if the ball has a collision,
     * and if he has - move them to the closest point of the collision,
     * and turn his velocity respectively by dx and dy.
     */
    public void moveOneStep() {
        double x = this.center.getX();
        double y = this.center.getY();
        Velocity v = getVelocity();
        double dx = v.gexDx();
        double dy = v.gexDy();
        //created the trajectory of the ball opn the screen.
        Line trajectory = new Line(x, y, x + velocity.gexDx(), y + velocity.gexDy());
        //we need to move the center almost to the collision point.
        double smallR = SMALL * r;
        //if there is a collision with a block.if not - promote him by his velocity.
        if (this.gameEnvironment.getClosestCollision(trajectory) != null) {
            CollisionInfo c = this.gameEnvironment.getClosestCollision(trajectory);
            //changing the direction of the ball where he hit.
            this.velocity = c.collisionObject().hit(this, c.collisionPoint(), this.getVelocity());
            double collX = c.collisionPoint().getX();
            double collY = c.collisionPoint().getY();
            double centerX = collX;
            double centerY = collY;
            //if the hit function change the dx,so it's happened in the walls of the block.
            if (dx != velocity.gexDx()) {
                //check from which direction the ball came,and change the x to be closest to the collision.
                if (dx < 0) {
                    centerX = collX + smallR;
                } else {
                    centerX = collX - smallR;
                }
            }
            //if the hit function change the dy,so it's happened in the floor and ceiling of the block.
            if ((dy != velocity.gexDy())) {
                if (dy < 0) {
                    centerY = collY + smallR;
                } else {
                    centerY = collY - smallR;
                }
            }
            //move the ball to be the new point.
            this.center = new Point(centerX, centerY);
        } else {
            this.center = this.getVelocity().applyToPoint(center);
        }
    }

    /**
     * Move one step.the function check that the ball not get out of the board.
     * if the ball going to get out we trun the dirction of the ball.
     *
     * @param limitR the limit r the right board
     * @param limitD the limit d the left board.
     */
    public void moveOneStep(int limitR, int limitD) {
        /*
        tow flags of x and y that should tall us if one of them make a step,
        only the second will make now the move.for Example,if we gwt over the limit
        the position of the x cordinated has change so now only the y will move.
         */
        int ix = 0;
        int jy = 0;
        Velocity v = new Velocity(this.getVelocity().gexDx(), this.getVelocity().gexDy());
        // if the x of the point get out of the board.
        if ((center.getX() + r + v.gexDx() > limitR)) {
            //update the point to be the limit of the right side.
            this.center = new Point(limitR - r, center.getY());
            //check the direction of the x.
            this.getVelocity().setDx(-v.gexDx());
            ix++;
        }
        // if the y of the point get out of the board.
        if ((center.getY() + r + v.gexDy() > limitR)) {
            //update the point to be the limit of the right side.
            this.center = new Point(center.getX(), limitR - r);
            this.getVelocity().setDy(-v.gexDy());
            jy++;
        }
        // if the x of the point get out of the board,less the min.
        if ((center.getX() - r + v.gexDx() < limitD)) {
            //update the point to be the limit of the left side.
            this.center = new Point(limitD + r, center.getY());
            this.getVelocity().setDx(-v.gexDx());
            ix++;
        }
        // if the y of the point get out of the board.
        if ((center.getY() - r + v.gexDy() < limitD)) {
            //update the point to be the limit of the left side.
            this.center = new Point(center.getX(), limitD + r);
            this.getVelocity().setDy(-v.gexDy());
            jy++;
        }
        //if we update the center of y but not the x,we need to add the velocity to x center.
        if ((ix == 0) && (jy != 0)) {
            this.center = new Point(center.getX() + v.gexDx(), center.getY());
        }
        //if we update the center of x but not the y,we need to add the velocity to y center.
        if ((ix != 0) && (jy == 0)) {
            this.center = new Point(center.getX(), center.getY() + v.gexDy());
        } else if ((ix == 0) && (jy == 0)) {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }

    /**
     * Add to game.add the ball to the GameLevel- there gameEnvironment will be the same.
     *
     * @param gameLevel the game
     */
    public void addToGame(GameLevel gameLevel) {
        this.gameEnvironment = gameLevel.getGameEnvironment();
        gameLevel.addSprite(this);
    }

    /**
     * Remove from game.
     *
     * @param g the g
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

}