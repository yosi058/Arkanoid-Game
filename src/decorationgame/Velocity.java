/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-28\4\2020
 * version-13.0.2
 */
package decorationgame;

import shapes.Point;

/**
 * The type Velocity.Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Instantiates a new Velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */

    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Apply to point point.creating a new point with the extension of the dx and dy.
     *
     * @param p the p point
     * @return the point after the extension.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * Sets dx.
     *
     * @param dx1 the dx that will in the field.
     */
    public void setDx(double dx1) {
        this.dx = dx1;
    }

    /**
     * Sets dy.
     *
     * @param dy1 the dy that will in the field.
     */
    public void setDy(double dy1) {
        this.dy = dy1;
    }


    /**
     * Gex dx double.
     *
     * @return the double of the dx.
     */
    public double gexDx() {
        return this.dx;
    }

    /**
     * Gex dy double.
     *
     * @return the double of the dy.
     */
    public double gexDy() {
        return this.dy;
    }

    /**
     * From angle and speed velocity.the function return new velocity according an angle and speed.
     * the function calculate it with cos and sin and multiplication it with the speed.
     *
     * @param angle the angle
     * @param speed the speed
     * @return the new velocity after we multiplication with the cos and sin of the angle.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleRand = Math.toRadians(angle);
        double dx = speed * Math.sin(angleRand);
        double dy = -speed * Math.cos(angleRand);
        return new Velocity(dx, dy);
    }

    /**
     * From velocity to speed double.the function get a velocity,and return the speed -
     * the length of the vector by Pythagoras.
     *
     * @param v the v velocity.
     * @return the double speed after the calculate the length of the vector.
     */
    public double fromVelocityToSpeed(Velocity v) {
        double velocity = Math.pow(v.gexDx(), 2) + Math.pow(v.gexDy(), 2);
        return Math.sqrt(velocity);
    }
}