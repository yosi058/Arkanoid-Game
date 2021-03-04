/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-4\4\2020
 * version-13.0.2
 */
package shapes;

/**
 * The type Line.created a segment in the axis according to the start and end point.
 */
public class Line {

    /**
     * The Epsilon.a small distance.
     */
    public static final double EPSILON = Math.pow(10, -6);

    private Point start;
    private Point end;

    /**
     * Instantiates a new Line.
     *
     * @param start the start point of the line.
     * @param end   the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Instantiates a new Line.
     *
     * @param x1 the x1 of the start point.
     * @param y1 the y1 of the start point.
     * @param x2 the x2 of the end point.
     * @param y2 the y2 of the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Length double.
     * The function calculate the length of the line,
     * according to the function distance.
     *
     * @return the double of the length.
     */
    public double length() {
        return (this.start.distance(end));
    }

    /**
     * Middle point.
     *
     * @return the new middle point in the line.
     */
    public Point middle() {
        return new Point(((start.getX() + end.getX()) / 2), ((start.getY() + end.getY()) / 2));
    }

    /**
     * Start point.
     *
     * @return the start point in the line.
     */
    public Point start() {
        return start;
    }

    /**
     * End point.
     *
     * @return the end point in the line.
     */
    public Point end() {
        return end;
    }

    /**
     * Intersection with line.
     * The function checl if there is a intersectionWith other line.
     * if there is - she return the new point of the intersection.
     * otherwise she return null.
     *
     * @param other the other line.
     * @return the new point if there is intersection. and null if it's not.
     */
    public Point intersectionWith(Line other) {
        //created a variable for the start and end point.
        double x1 = this.start.getX();
        double x2 = this.end.getX();
        double x3 = other.start.getX();
        double x4 = other.end.getX();
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        double y3 = other.start.getY();
        double y4 = other.end.getY();
        // check if one of the lines are vertical and the other d'ont.
        if ((x1 == x2) && (x3 != x4)) {
            //we created the equation of the other line,with the x of the this line.
            double b = getB(other.slant(), other.start);
            double y = getY(other.slant(), b, x1);
            /*
            check if the the y is inrange of the the vertical line,
            and if the x of the vertical in the range of the other line.
             */
            if (inRange(y, y1, y2) && (inRange(x1, x3, x4))) {
                return new Point(x1, y);
            }
            return null;
        }
        //now we check the the opposite,if the other is vertical and this is't.
        if ((x1 != x2) && (x3 == x4)) {
            double b = getB(this.slant(), this.start);
            double y = getY(this.slant(), b, x3);
             /*
            check if the the y is inrange of the the vertical line,
            and if the x of the vertical in the range of the this line.
             */
            if (inRange(y, y3, y4) && inRange(x3, x1, x2)) {
                return new Point(x3, y);
            }
            return null;
        }
        //if there are both verticals.
        if ((x1 == x2) && (x3 == x4)) {
            // 2 options - there are the same line,of the are parallels and will never meet.
            if (x1 == x3) {
                if (Math.min(y3, y4) == Math.max(y1, y2)) {
                    return new Point(x1, Math.min(y3, y4));
                }
                if (Math.max(y3, y4) == Math.min(y1, y2)) {
                    return new Point(x1, Math.min(y1, y2));
                }
            }
            return null;
        }
        // if there slant are the same.we also check if this is the same equation.
        if (this.slant() == other.slant()) {
            double b = getB(this.slant(), this.start);
            double c = getB(other.slant(), other.start);
            /*
            if it is the same equation,and also the slant is 0.we check if the min x of one line,
            is the max x of the other.or opposite.we return the point of the intersction.
             */
            if ((b == c) && (this.slant() == 0)) {
                if (Math.min(x3, x4) == Math.max(x1, x2)) {
                    return new Point(Math.min(x3, x4), y1);
                }
                if (Math.max(x3, x4) == Math.min(x1, x2)) {
                    return new Point(Math.min(x1, x2), y1);
                }
            }
            /*
             if it is the same equation and the slant if not 0,we check if the min y of one line,
               is the max y of the other.or opposite.we return the point of the intersction.
               */
            double x = (Math.min(y3, y4) - b) / this.slant();
            if ((b == c) && (this.slant() != 0)) {
                if (Math.min(y3, y4) == Math.max(y1, y2)) {
                    return new Point(x, Math.min(y3, y4));
                }
                if (Math.max(y3, y4) == Math.min(y1, y2)) {
                    return new Point(x, Math.min(y1, y2));
                }
            }
            return null;
        }
        /*
         now we check the classic lines with a slant and point.
         we created a equation,and check if the x of the intersecting is inrange in the both of the lines.
         */
        double slant1 = this.slant();
        double slant2 = other.slant();
        double b = getB(slant1, this.start);
        double c = getB(slant2, other.start);
        double x = (b - c) / (slant2 - slant1);
        double y = getY(x, b, slant1);
        //if the x is in range of the lines return the point of the intersecting.
        if ((inRange(x, x1, x2)) && (inRange(x, x3, x4))) {
            return new Point(x, y);
        }
        return null;
    }

    /**
     * Is intersecting boolean.the function check if there is any intersecting with the other line.
     *
     * @param other the other line.
     * @return the boolean true if there is a point of intersecting,fale otherwisw.
     */
    public boolean isIntersecting(Line other) {
        return other.intersectionWith(this) != null;
    }

    /**
     * Equals boolean.the function check if tow lines are the same.
     * if there have the same start and end point.
     *
     * @param other the other line.
     * @return the boolean true if there are the same,false otherwise.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start()) && (this.end.equals(other.end())));
    }

    /**
     * Slant double. the function calculate the slant of the line.
     *
     * @return the double slant.
     */
    public double slant() {
        return (start.getY() - end.getY()) / (start.getX() - end.getX());
    }

    /**
     * Gets b.the function calculate the b in the equation.
     *
     * @param slant the slant line.
     * @param first the start point line.
     * @return the b of the equation.
     */
    private double getB(double slant, Point first) {
        return first.getY() - (slant * first.getX());
    }

    /**
     * Gets y.the function calculate the y of the equation.
     *
     * @param x     the x of the equation
     * @param b     the b of the equation
     * @param slant the slant of the line.
     * @return the y of the equation.
     */
    private double getY(double x, double b, double slant) {
        return ((slant * x) + b);
    }

    /**
     * In range boolean.
     *
     * @param x  the x
     * @param x1 the x1
     * @param x2 the x2
     * @return the boolean true if the x is bigger than the min'and smaller the the max. false otherwise.
     */
    public boolean inRange(double x, double x1, double x2) {
        //EPSILON is the small deviation.
        return (x >= (Math.min(x1, x2) - EPSILON)) && (x <= (Math.max(x1, x2) + EPSILON));
    }

    /**
     * Closest intersection to start of line point.
     * this function get a rectangle anf return the closest point to Intersection to the start line.
     * and return null if there is no point.
     *
     * @param rect the rect
     * @return the point closest.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        if (rect.intersectionPoints(this).isEmpty()) {
            return null;
        }
        Point p = rect.intersectionPoints(this).get(0);
        double minD = p.distance(this.start());
        Point point = rect.intersectionPoints(this).get(0);
        //go over the list of point that has a Intersection with.
        for (Point c : rect.intersectionPoints(this)) {
            //if the distance is small so make a swap.
            double dis = c.distance(this.start());
            if (dis < minD) {
                minD = dis;
                point = c;
            }
        }
        return point;
    }
}