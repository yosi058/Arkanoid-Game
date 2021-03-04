/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-29\4\2020
 * version-13.0.2
 */
package baselevel;

import decorationgame.CollisionInfo;
import interfacegame.Collidable;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Game environment.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * Instantiates a new Game environment.created a new ArrayList of collidables.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * Add collidable.
     * add the given collidable to the environment.
     *
     * @param c the c the Collidable
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Gets collidables.
     *
     * @return the list of the collidables.
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }

    /**
     * Gets closest collision.this function go over all the collidables that has maybe a collision
     * with the ball trajectory,and return the closest to him.
     * if there is non - return null.
     *
     * @param trajectory the trajectory of the ball.
     * @return the closest collision that has a collision with the ball.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<CollisionInfo> a = new ArrayList<>();
        //created a new array list of CollisionInfo and go over the collidables.
        for (Collidable c : collidables) {
            Rectangle r = c.getCollisionRectangle();
            //if there is intersectionWith
            if (r.intersectionWith(trajectory)) {
                Point p = trajectory.closestIntersectionToStartOfLine(r);
                a.add(new CollisionInfo(p, c));
            }
        }
        if (a.size() == 0) {
            return null;
        }
        CollisionInfo min = a.get(0);
        double minDis = min.collisionPoint().distance(trajectory.start());
        for (CollisionInfo c : a) {
            double dis = c.collisionPoint().distance(trajectory.start());
            if (dis < minDis) {
                minDis = dis;
                min = c;
            }
        }
        return min;
    }
}