import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private final ArrayList<LineSegment> segmentsList;

    /**
     * Finds all line segments containing 4 points.
     *
     * @param points the array of points to examine
     * @throws IllegalArgumentException if the argument is null, contains null points,
     * or contains repeated points.
     */
    public BruteCollinearPoints(Point[] points) {
        // 1. Check for corner cases
        checkNullsAndDuplicates(points);

        // Make a defensive copy
        Point[] localPoints = points.clone();
        
        // Sort the copy to easily find min/max points for segments
        // This ensures we only add (p -> s) and not (s -> p)
        Arrays.sort(localPoints);

        segmentsList = new ArrayList<>();
        int n = localPoints.length;

        // 2. Iterate through all combinations of 4 points
        for (int i = 0; i < n; i++) {
            Point p = localPoints[i];
            for (int j = i + 1; j < n; j++) {
                Point q = localPoints[j];
                double slopePQ = p.slopeTo(q);
                for (int k = j + 1; k < n; k++) {
                    Point r = localPoints[k];
                    double slopePR = p.slopeTo(r);

                    // Check if p, q, r are collinear
                    if (slopePQ == slopePR) {
                        for (int l = k + 1; l < n; l++) {
                            Point s = localPoints[l];
                            double slopePS = p.slopeTo(s);
                            
                            // Check if p, q, r, s are collinear
                            if (slopePQ == slopePS) {
                                // Since the array is sorted, p is the min point
                                // and s is the max point.
                                segmentsList.add(new LineSegment(p, s));
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Helper method to check for nulls and duplicate points.
     *
     * @param points the array to check
     */
    private void checkNullsAndDuplicates(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("Points array cannot be null");
        }

        // Check for null points
        for (Point p : points) {
            if (p == null) {
                throw new IllegalArgumentException("Point in array cannot be null");
            }
        }

        // Make a copy to sort and check for duplicates without modifying original
        Point[] copy = points.clone();
        Arrays.sort(copy);
        
        // Check for duplicate points
        for (int i = 0; i < copy.length - 1; i++) {
            if (copy[i].compareTo(copy[i + 1]) == 0) {
                throw new IllegalArgumentException("Array contains duplicate points");
            }
        }
    }

    /**
     * The number of line segments.
     *
     * @return the number of line segments
     */
    public int numberOfSegments() {
        return segmentsList.size();
    }

    /**
     * The line segments.
     *
     * @return an array of the line segments
     */
    public LineSegment[] segments() {
        // Convert ArrayList to array
        return segmentsList.toArray(new LineSegment[0]);
    }
}
