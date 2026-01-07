import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Represents a set of points in the unit square using a Red-Black BST.
 * This implementation provides a brute-force approach for range and nearest-neighbor search.
 *
 * The implementation uses java.util.TreeSet to store the points.
 * - insert() and contains() are O(log N)
 * - range() and nearest() are O(N)
 */
public class PointSET {
    private final TreeSet<Point2D> set;

    /**
     * Construct an empty set of points.
     */
    public PointSET() {
        set = new TreeSet<Point2D>();
    }

    /**
     * Is the set empty?
     * @return true if this set contains no points, false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Number of points in the set.
     * @return the number of points in this set.
     */
    public int size() {
        return set.size();
    }

    /**
     * Add the point to the set (if it is not already in the set).
     * @param p the point to add
     * @throws IllegalArgumentException if the point is null.
     */
    public void insert(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument to insert() cannot be null.");
        }
        set.add(p);
    }

    /**
     * Does the set contain point p?
     * @param p the point to check
     * @return true if this set contains the point p, false otherwise.
     * @throws IllegalArgumentException if the point is null.
     */
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument to contains() cannot be null.");
        }
        return set.contains(p);
    }

    /**
     * Draw all points to standard draw.
     */
    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        for (Point2D p : set) {
            p.draw();
        }
    }

    /**
     * All points that are inside the rectangle (or on the boundary).
     * This is a brute-force O(N) operation.
     *
     * @param rect the query rectangle
     * @return an iterable collection of all points in the set that are contained in the rectangle.
     * @throws IllegalArgumentException if the rectangle is null.
     */
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException("Argument to range() cannot be null.");
        }
        List<Point2D> pointsInRect = new ArrayList<Point2D>();
        for (Point2D p : set) {
            if (rect.contains(p)) {
                pointsInRect.add(p);
            }
        }
        return pointsInRect;
    }

    /**
     * A nearest neighbor in the set to point p; null if the set is empty.
     * This is a brute-force O(N) operation.
     *
     * @param p the query point
     * @return a nearest neighbor point in the set to point p; null if the set is empty.
     * @throws IllegalArgumentException if the point is null.
     */
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument to nearest() cannot be null.");
        }
        if (isEmpty()) {
            return null;
        }

        Point2D nearest = null;
        double minDistanceSq = Double.POSITIVE_INFINITY;

        for (Point2D pointInSet : set) {
            double distSq = p.distanceSquaredTo(pointInSet);
            if (distSq < minDistanceSq) {
                minDistanceSq = distSq;
                nearest = pointInSet;
            }
        }
        return nearest;
    }

    /**
     * Unit testing of the methods.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        PointSET pointSet = new PointSET();
        System.out.println("Is empty: " + pointSet.isEmpty()); // true

        pointSet.insert(new Point2D(0.1, 0.1));
        pointSet.insert(new Point2D(0.2, 0.2));
        pointSet.insert(new Point2D(0.1, 0.1)); // duplicate
        pointSet.insert(new Point2D(0.6, 0.6));

        System.out.println("Size: " + pointSet.size()); // 3
        System.out.println("Is empty: " + pointSet.isEmpty()); // false
        System.out.println("Contains (0.2, 0.2): " + pointSet.contains(new Point2D(0.2, 0.2))); // true
        System.out.println("Contains (0.5, 0.5): " + pointSet.contains(new Point2D(0.5, 0.5))); // false

        RectHV rect = new RectHV(0.0, 0.0, 0.5, 0.5);
        System.out.println("Points in rect [0,0]x[0.5,0.5]:");
        for (Point2D p : pointSet.range(rect)) {
            System.out.println(p); // (0.1, 0.1), (0.2, 0.2)
        }

        Point2D queryPoint = new Point2D(0.5, 0.5);
        System.out.println("Nearest to (0.5, 0.5): " + pointSet.nearest(queryPoint)); // (0.6, 0.6)
    }
}
