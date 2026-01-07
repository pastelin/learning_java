import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of points in the unit square using a 2d-tree.
 * This implementation supports efficient range search and nearest-neighbor search.
 *
 * A 2d-tree is a generalization of a BST to two-dimensional keys.
 * The idea is to build a BST with points in the nodes, using the x- and y-coordinates
 * of the points as keys in strictly alternating sequence, starting with the x-coordinate.
 */
public class KdTree {

    private static final boolean VERTICAL = true;
    private static final boolean HORIZONTAL = false;

    private Node root;
    private int size;

    /**
     * Helper nested class for 2d-tree nodes.
     */
    private static class Node {
        private final Point2D p;      // the point
        private final RectHV rect;    // the axis-aligned rectangle corresponding to this node
        private Node left;      // the left/bottom subtree
        private Node right;     // the right/top subtree

        public Node(Point2D p, RectHV rect) {
            this.p = p;
            this.rect = rect;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Construct an empty set of points.
     */
    public KdTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Is the set empty?
     * @return true if this set contains no points, false otherwise.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Number of points in the set.
     * @return the number of points in this set.
     */
    public int size() {
        return this.size;
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
        // Start recursion from the root, splitting vertically, with the full unit square
        root = insert(root, p, VERTICAL, 0.0, 0.0, 1.0, 1.0);
    }

    /**
     * Recursive helper for insert.
     * @param node The current node in the recursion
     * @param p The point to insert
     * @param isVertical True if this level splits on X-coord, false for Y-coord
     * @param xmin The min x-coord of this node's rectangle
     * @param ymin The min y-coord of this node's rectangle
     * @param xmax The max x-coord of this node's rectangle
     * @param ymax The max y-coord of this node's rectangle
     * @return The node (either existing or new)
     */
    private Node insert(Node node, Point2D p, boolean isVertical,
                        double xmin, double ymin, double xmax, double ymax) {
        
        // Base case: Found an empty spot. Create a new node.
        if (node == null) {
            this.size++;
            RectHV rect = new RectHV(xmin, ymin, xmax, ymax);
            return new Node(p, rect);
        }

        // Check for duplicates. If found, just return the node.
        if (node.p.equals(p)) {
            return node;
        }

        if (isVertical) {
            // Compare x-coordinates
            double cmp = p.x() - node.p.x();
            if (cmp < 0) {
                // Go left. The right boundary of the new rect is the node's x-coord.
                node.left = insert(node.left, p, !isVertical, xmin, ymin, node.p.x(), ymax);
            } else {
                // Go right. The left boundary of the new rect is the node's x-coord.
                node.right = insert(node.right, p, !isVertical, node.p.x(), ymin, xmax, ymax);
            }
        } else {
            // Compare y-coordinates
            double cmp = p.y() - node.p.y();
            if (cmp < 0) {
                // Go bottom. The top boundary of the new rect is the node's y-coord.
                node.left = insert(node.left, p, !isVertical, xmin, ymin, xmax, node.p.y());
            } else {
                // Go top. The bottom boundary of the new rect is the node's y-coord.
                node.right = insert(node.right, p, !isVertical, xmin, node.p.y(), xmax, ymax);
            }
        }

        return node;
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
        return contains(root, p, VERTICAL);
    }

    /**
     * Recursive helper for contains.
     * @param node The current node
     * @param p The point to search for
     * @param isVertical The orientation of the current node's split
     * @return True if found in this subtree, false otherwise
     */
    private boolean contains(Node node, Point2D p, boolean isVertical) {
        // Base case: Reached a null link, point not found.
        if (node == null) {
            return false;
        }

        // Base case: Found the point.
        if (node.p.equals(p)) {
            return true;
        }

        double cmp;
        if (isVertical) {
            // Compare x-coordinates
            cmp = p.x() - node.p.x();
        } else {
            // Compare y-coordinates
            cmp = p.y() - node.p.y();
        }

        if (cmp < 0) {
            // Go left/bottom
            return contains(node.left, p, !isVertical);
        } else {
            // Go right/top
            return contains(node.right, p, !isVertical);
        }
    }

    /**
     * Draw all points to standard draw.
     * Draws points in black and the subdivisions in red (vertical) and blue (horizontal).
     */
    public void draw() {
        draw(root, VERTICAL);
    }

    /**
     * Recursive helper for draw.
     * @param node The current node to draw
     * @param isVertical The orientation of this node's split
     */
    private void draw(Node node, boolean isVertical) {
        if (node == null) {
            return;
        }

        // 1. Draw the point
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        node.p.draw();

        // 2. Draw the splitting line
        StdDraw.setPenRadius(); // reset to default
        if (isVertical) {
            // Red vertical line
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(node.p.x(), node.rect.ymin(), node.p.x(), node.rect.ymax());
        } else {
            // Blue horizontal line
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(node.rect.xmin(), node.p.y(), node.rect.xmax(), node.p.y());
        }

        // 3. Recurse
        draw(node.left, !isVertical);
        draw(node.right, !isVertical);
    }

    /**
     * All points that are inside the rectangle (or on the boundary).
     * @param rect the query rectangle
     * @return an iterable collection of all points in the set that are contained in the rectangle.
     * @throws IllegalArgumentException if the rectangle is null.
     */
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException("Argument to range() cannot be null.");
        }
        List<Point2D> pointsInRect = new ArrayList<Point2D>();
        range(root, rect, pointsInRect);
        return pointsInRect;
    }

    /**
     * Recursive helper for range search.
     * @param node The current node
     * @param queryRect The query rectangle
     * @param pointsInRect A list to accumulate points found
     */
    private void range(Node node, RectHV queryRect, List<Point2D> pointsInRect) {
        if (node == null) {
            return;
        }

        // Pruning rule: If the query rectangle does not intersect the node's
        // rectangle, there's no need to search this node or its subtrees.
        if (!queryRect.intersects(node.rect)) {
            return;
        }

        // Check if this node's point is in the query rectangle
        if (queryRect.contains(node.p)) {
            pointsInRect.add(node.p);
        }

        // Recurse on both subtrees
        range(node.left, queryRect, pointsInRect);
        range(node.right, queryRect, pointsInRect);
    }

    /**
     * A nearest neighbor in the set to point p; null if the set is empty.
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
        // Start the search with the root's point as the initial "champion"
        return nearest(root, p, root.p, VERTICAL);
    }

    /**
     * Recursive helper for nearest-neighbor search.
     * @param node The current node
     * @param queryPoint The point we are searching near
     * @param champion The closest point found so far
     * @param isVertical The orientation of this node's split
     * @return The champion point found in this subtree
     */
    private Point2D nearest(Node node, Point2D queryPoint, Point2D champion, boolean isVertical) {
        if (node == null) {
            return champion;
        }

        Point2D closest = champion;
        double champDistSq = closest.distanceSquaredTo(queryPoint);
        double nodeRectDistSq = node.rect.distanceSquaredTo(queryPoint);

        // Pruning rule: If the distance from the query point to this node's
        // rectangle is greater than the best distance found so far, we
        // don't need to search this node or its subtrees.
        if (nodeRectDistSq > champDistSq) {
            return closest;
        }

        // Check if this node's point is closer than the current champion
        double nodePointDistSq = node.p.distanceSquaredTo(queryPoint);
        if (nodePointDistSq < champDistSq) {
            closest = node.p;
        }

        // Determine which subtree is "closer" to the query point
        Node firstSubtree, secondSubtree;
        boolean queryIsLeftOrBottom;

        if (isVertical) {
            queryIsLeftOrBottom = queryPoint.x() < node.p.x();
        } else {
            queryIsLeftOrBottom = queryPoint.y() < node.p.y();
        }

        if (queryIsLeftOrBottom) {
            firstSubtree = node.left;
            secondSubtree = node.right;
        } else {
            firstSubtree = node.right;
            secondSubtree = node.left;
        }

        // Recurse on the "good" side first (the one the query point is in)
        // Pass the updated 'closest' point as the new champion
        closest = nearest(firstSubtree, queryPoint, closest, !isVertical);
        
        // Recurse on the "bad" side, using the *potentially updated* champion
        // from the first recursive call. This allows for pruning of the second subtree.
        closest = nearest(secondSubtree, queryPoint, closest, !isVertical);

        return closest;
    }


    /**
     * Unit testing of the methods.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        KdTree kdtree = new KdTree();
        
        // Example from the assignment description
        kdtree.insert(new Point2D(0.7, 0.2));
        kdtree.insert(new Point2D(0.5, 0.4));
        kdtree.insert(new Point2D(0.2, 0.3));
        kdtree.insert(new Point2D(0.4, 0.7));
        kdtree.insert(new Point2D(0.9, 0.6));
        
        System.out.println("Size: " + kdtree.size()); // 5

        // Test duplicate insertion
        kdtree.insert(new Point2D(0.4, 0.7));
        System.out.println("Size after duplicate insert: " + kdtree.size()); // 5

        // Test contains
        System.out.println("Contains (0.5, 0.4): " + kdtree.contains(new Point2D(0.5, 0.4))); // true
        System.out.println("Contains (0.5, 0.5): " + kdtree.contains(new Point2D(0.5, 0.5))); // false
        System.out.println("Contains (0.9, 0.6): " + kdtree.contains(new Point2D(0.9, 0.6))); // true

        // Test range search
        RectHV rect = new RectHV(0.0, 0.0, 0.5, 0.5);
        System.out.println("Points in rect [0,0]x[0.5,0.5]:");
        for (Point2D p : kdtree.range(rect)) {
            System.out.println(p); // (0.5, 0.4), (0.2, 0.3)
        }

        // Test nearest neighbor
        Point2D query1 = new Point2D(0.8, 0.7);
        System.out.println("Nearest to (0.8, 0.7): " + kdtree.nearest(query1)); // (0.9, 0.6)

        Point2D query2 = new Point2D(0.3, 0.6);
        System.out.println("Nearest to (0.3, 0.6): " + kdtree.nearest(query2)); // (0.4, 0.7)
    }
}
