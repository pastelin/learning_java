import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> segmentsList = new ArrayList<>();

    /**
     * Finds all line segments containing 4 or more points.
     *
     * @param points the array of points to examine
     * @throws IllegalArgumentException if the argument is null, contains null points,
     * or contains repeated points.
     */
    public FastCollinearPoints(Point[] points) {
        // 1. Check for corner cases
        checkNullsAndDuplicates(points);
        
        // Make a defensive copy and sort it by coordinate
        Point[] localPoints = points.clone();
        Arrays.sort(localPoints);
        
        int n = localPoints.length;
        if (n < 4) {
            return; // Cannot have 4 collinear points
        }

        // 2. Iterate through each point 'p' as the origin
        for (int i = 0; i < n; i++) {
            Point p = localPoints[i];

            // Create a copy of the points to sort by slope relative to p
            Point[] pointsBySlope = localPoints.clone();
            
            // Sort by slope order relative to p
            // p itself will be at pointsBySlope[0] due to NEGATIVE_INFINITY slope
            Arrays.sort(pointsBySlope, p.slopeOrder());

            // 3. Scan the sorted-by-slope array for adjacent points with equal slopes
            int j = 1; // Start at 1 to skip p itself
            while (j < n) {
                double currentSlope = p.slopeTo(pointsBySlope[j]);
                int k = j + 1;

                // Find all adjacent points with the same slope
                while (k < n && p.slopeTo(pointsBySlope[k]) == currentSlope) {
                    k++;
                }

                // We now have a run of equal slopes from j to k-1
                // The number of collinear points (excluding p) is (k - j)
                int numCollinear = (k - j);

                // If 3 or more points share a slope with p, we have a segment
                if (numCollinear >= 3) {
                    // We found a segment of 4 or more points (p + the j..k-1 group)
                    // We only add the segment if p is the "smallest" point
                    // (by compareTo) in the collinear set.
                    // This prevents adding duplicate segments.
                    
                    // Since localPoints was sorted, and p comes from it in order,
                    // any segment we find where p is the min point
                    // (p.compareTo(pointsBySlope[j]) < 0) hasn't been added yet.
                    
                    // A simpler way: The 'pointsBySlope' array includes p (at index 0).
                    // The other points in the segment are from j to k-1.
                    // The "min" point in this segment is p.compareTo(pointsBySlope[j]).
                    // We only add the segment if p is the smallest.
                    
                    Point minPoint = p;
                    Point maxPoint = p;
                    // Find the min and max of this collinear set (p + group)
                    for (int m = j; m < k; m++) {
                        if (pointsBySlope[m].compareTo(maxPoint) > 0) {
                            maxPoint = pointsBySlope[m];
                        }
                        // minPoint is already p. We only care if p is the min.
                    }

                    // Only add the segment if p is the natural-order minimum
                    // This ensures we only add each segment once (when its
                    // "smallest" point is the origin p)
                    if (p.compareTo(pointsBySlope[j]) < 0) {
                         segmentsList.add(new LineSegment(p, maxPoint));
                    }
                }
                
                // Advance j to the start of the next slope group
                j = k;
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
