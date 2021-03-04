/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-2\4\2020
 * version-13.0.2
 */
package baselevel;

import biuoop.DrawSurface;
import decorationgame.Velocity;
import interfacegame.Collidable;
import interfacegame.HitListener;
import interfacegame.HitNotifier;
import interfacegame.Sprite;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners = new ArrayList<>();
    private Rectangle rectangle;
    private Color color;

    /**
     * Instantiates a new Block.
     *
     * @param rectangle the rectangle
     * @param color     the color
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
    }

    /**
     * Instantiates a new Block.
     *
     * @param point  the point
     * @param width  the width
     * @param height the height
     * @param color  the color
     */
    public Block(Point point, double width, double height, Color color) {
        this.rectangle = new Rectangle(point, width, height);
        this.color = color;
    }

    /**
     * @return the rectangle of the block.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * hit.get a collisionPoint and a currentVelocity,
     * and check where was the collision and respectively changing the Velocity.
     * and return the new Velocity.
     *
     * @param collisionPoint  the collision point with the line.
     * @param currentVelocity the current velocity of the ball.
     * @param hitter          the hitter
     * @return a new velocity after the change.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double x = collisionPoint.getX();
        double y = collisionPoint.getY();
        Line[] l = this.rectangle.getLines();
        //go over all the lines in the rectangle.
        for (int i = 0; i < 4; i++) {
            double x1 = l[i].start().getX();
            double x2 = l[i].end().getX();
            double y1 = l[i].start().getY();
            double y2 = l[i].end().getY();
            /*
            we put the lines in the array that the walls(the x aix) will be in places  1 and 3.
            and the "floor" and the "ceiling" of the rectangle will be in 0 and 2 in the array.
            if the collisionPoint is in line 1 or 3 that mean the collisionPoint
            was in the walls of the rectangle,so we need to chang the dx,else the line is 0 or 2
            so we need to chang the dy.
             */
            if (i % 2 == 0) {
                if ((l[i].inRange(x, x1, x2)) && (l[i].inRange(y, y1, y2))) {
                    currentVelocity.setDy(-currentVelocity.gexDy());
                }
            } else {
                if ((l[i].inRange(x, x1, x2)) && (l[i].inRange(y, y1, y2))) {
                    currentVelocity.setDx(-currentVelocity.gexDx());
                }
            }
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * drawOn the block  with a color in the screen.
     *
     * @param d the d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        Point p = this.rectangle.getUpperLeft();
        d.setColor(this.color);
        d.fillRectangle((int) p.getX(), (int) p.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) p.getX(), (int) p.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    @Override
    public void timePassed() {
    }

    /**
     * Add to game.evey block should add to the game every time.
     *
     * @param game the game
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

    /**
     * @param hl the hl
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);

    }

    /**
     * @param hl the hl
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);

    }

    /**
     * @param hitter the hitter
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * removeFromGame.remove the block from the sprite list and the collidable list.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }
}
