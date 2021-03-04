/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-28\4\2020
 * version-13.0.2
 */
package decorationgame;

import interfacegame.Collidable;
import shapes.Point;

/**
 * The type Collision info.
 */
public class CollisionInfo {
    private Point point;
    private Collidable collidable;

    /**
     * Instantiates a new Collision info.
     *
     * @param point      the point of the Collision.
     * @param collidable the collidable that has a Collision with.
     */
    public CollisionInfo(Point point, Collidable collidable) {
        this.point = point;
        this.collidable = collidable;
    }

    /**
     * Collision point point.
     *
     * @return the point of the Collision.
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * Collision object collidable.
     *
     * @return the collidable  object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidable;
    }
}