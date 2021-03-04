/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-27\4\2020
 * version-13.0.2
 */
package shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Rectangle.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Instantiates a new Rectangle.created a Rectangle in the space.
     * with a point and width and height.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Instantiates a new Rectangle..created a Rectangle in the space.
     * with a x,y and width and height.
     *
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     */
    public Rectangle(double x, double y, double width, double height) {
        this.upperLeft = new Point(x, y);
        this.width = width;
        this.height = height;
    }


    /**
     * Intersection points java . util . list.
     * the function get a line and check all the lines if there is intersection with the line,
     * and return all the point that has a intersection with the line.
     * if there is non-return null.
     *
     * @param line the line intersection.
     * @return the java . util . list of all the point that intersection with the line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> p = new ArrayList<>();
        //get all the lines of the rectangle.
        Line[] l = getLines();
        for (Line c : l) {
            if (c.isIntersecting(line)) {
                p.add(c.intersectionWith(line));
            }
        }
        return p;
    }

    /**
     * Intersection with boolean.check if there is any intersection with the line-
     * the arry is not empty and return true,false otherwise.
     *
     * @param line the line intersection
     * @return the boolean true if there is intersection point,false otherwise.
     */
    public boolean intersectionWith(Line line) {
        return this.intersectionPoints(line).size() != 0;
    }

    /**
     * Gets width.return the width of the rectangle.
     *
     * @return the width
     */

    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.return the height of the rectangle.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets upper left.return the upper left of the rectangle.
     *
     * @return the upper left
     */

    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Sets upper left.put a new value of the upper left of the rectangle.
     *
     * @param upperLeftRectangle the upper left the new upper left point.
     */
    public void setUpperLeft(Point upperLeftRectangle) {
        this.upperLeft = upperLeftRectangle;
    }

    /**
     * Get lines line [ ].the function created a 4 lines of the rectangle,
     * and return them.
     *
     * @return the line [ ] of all the 4 lines in the rectangle.
     */
    public Line[] getLines() {
        Line[] line = new Line[4];
        Point upperL = this.upperLeft;
        Point upperR = new Point(upperL.getX() + this.width, upperL.getY());
        Point downL = new Point(upperL.getX(), upperL.getY() + this.height);
        Point downR = new Point(upperR.getX(), downL.getY());
        line[0] = new Line(upperL, upperR);
        line[1] = new Line(upperL, downL);
        line[2] = new Line(downL, downR);
        line[3] = new Line(upperR, downR);
        return line;
    }
}