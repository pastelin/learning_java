import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;

/**
 * Represents a point in the plane.
 * Immutable data type.
 */
public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate
    private final int y;     // y-coordinate

    /**
     * Initializes a new point.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns a string representation of this point.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     * point (x0 = x1 and y0 = y1);
     * a negative integer if this point is less than the argument
     * point; and a positive integer if this point is greater than the
     * argument point
     */
    public int compareTo(Point that) {
        // Compare by y-coordinate
        if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        // If y-coordinates are equal, compare by x-coordinate
        if (this.x < that.x) return -1;
        if (this.x > that.x) return +1;
        // Points are equal
        return 0;
    }

    /**
     * Returns the slope between this point (x0, y0) and the argument point (x1, y1).
     * The slope is (y1 - y0) / (x1 - x0).
     * Treats the slope of a horizontal line segment as positive zero.
     * Treats the slope of a vertical line segment as positive infinity.
     * Treats the slope of a degenerate line segment (between a point and itself)
     * as negative infinity.
     *
     * @param that the other point
     * @return the slope between this point and the argument point
     */
    public double slopeTo(Point that) {
        // Degenerate case (point to itself)
        if (this.x == that.x && this.y == that.y) {
            return Double.NEGATIVE_INFINITY;
        }
        
        // Vertical line
        if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        }

        // Horizontal line
        if (this.y == that.y) {
            return +0.0; // Positive zero
        }

        // General case
        return (double) (that.y - this.y) / (that.x - this.x);
    }

    /**
     * Returns a comparator that compares two points by the slope they make
     * with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return a comparator that compares two points by the slope they make
     * with this point
     */
    public Comparator<Point> slopeOrder() {
        // Return an anonymous inner class that implements the Comparator interface
        return new Comparator<Point>() {
            @Override
            public int compare(Point q1, Point q2) {
                // Use Point.this to refer to the outer Point instance (the origin)
                double slope1 = Point.this.slopeTo(q1);
                double slope2 = Point.this.slopeTo(q2);
                
                // Use Double.compare to handle -0.0, +0.0, and infinities correctly
                return Double.compare(slope1, slope2);
            }
        };
    }
}
