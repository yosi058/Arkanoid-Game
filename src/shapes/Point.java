/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-4\4\2020
 * version-13.0.2
 */
package shapes;

/**
 * The type Point.created a point in the X and Y axis.according to there coordinates.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Instantiates a new Point.
     *
     * @param x the x
     * @param y the y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance double.
     * The function return the distance between 2 points.
     *
     * @param other the other
     * @return the double distance.
     */
    public double distance(Point other) {
        double dis = Math.pow((x - other.x), 2) + Math.pow((y - other.y), 2);
        return Math.sqrt(dis);
    }

    /**
     * Equals boolean.
     * The function check if tow points are equals-
     * there start and end are the same.
     *
     * @param other the other
     * @return the boolean true if it's the same.
     * false otherwise.
     */
    public boolean equals(Point other) {
        return (this.x == other.x) && (this.y == other.y);
    }

    /**
     * Gets x.
     *
     * @return the x of the field of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets y.
     *
     * @return the y of the point in the field.
     */
    public double getY() {
        return this.y;
    }
}
