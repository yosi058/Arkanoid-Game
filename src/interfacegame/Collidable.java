/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-2\4\2020
 * version-13.0.2
 */
package interfacegame;

import baselevel.Ball;
import decorationgame.Velocity;
import shapes.Point;
import shapes.Rectangle;

/**
 * The interface Collidable.interface that will be implements with the blocks and the paddle in the game.
 * if a rectangle that the ball may collision with him.
 */
public interface Collidable {
    /**
     * Gets collision rectangle.
     * each one of the object that will implements the interface will return there rectangle.
     *
     * @return the collision rectangle.
     */
    Rectangle getCollisionRectangle();

    /**
     * Hit velocity.notify the object that we collided with it at collisionPoint with
     * a given velocity.and the function will return a new velocity for the object.
     *
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @param hitter          the hitter
     * @return the velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}