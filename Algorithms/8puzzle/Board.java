import edu.princeton.cs.algs4.Stack;
import java.util.Arrays;

public class Board {

    private final int n;
    private final int[][] tiles;
    private final int hammingDist;
    private final int manhattanDist;
    private final int blankRow;
    private final int blankCol;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles == null) {
            throw new IllegalArgumentException("Tiles array cannot be null");
        }
        this.n = tiles.length;
        this.tiles = new int[n][n];
        
        int tempHamming = 0;
        int tempManhattan = 0;
        int tempBlankRow = -1;
        int tempBlankCol = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.tiles[i][j] = tiles[i][j];
                int tileValue = this.tiles[i][j];

                if (tileValue == 0) {
                    tempBlankRow = i;
                    tempBlankCol = j;
                    continue; // Blank square doesn't count towards distances
                }

                // Calculate goal position for this tileValue
                int goalRow = (tileValue - 1) / n;
                int goalCol = (tileValue - 1) % n;

                // Check Hamming
                if (i != goalRow || j != goalCol) {
                    tempHamming++;
                }

                // Check Manhattan
                tempManhattan += Math.abs(i - goalRow) + Math.abs(j - goalCol);
            }
        }
        
        this.hammingDist = tempHamming;
        this.manhattanDist = tempManhattan;
        this.blankRow = tempBlankRow;
        this.blankCol = tempBlankCol;
    }

    // string representation of this board
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n + "\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Use String.format for clean, aligned output
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    // board dimension n
    public int dimension() {
        return this.n;
    }

    // number of tiles out of place
    public int hamming() {
        return this.hammingDist;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return this.manhattanDist;
    }

    // is this board the goal board?
    public boolean isGoal() {
        // If hamming is 0, all tiles are in place.
        return this.hammingDist == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        
        Board that = (Board) y;
        // n is implicitly checked by deepEquals
        return Arrays.deepEquals(this.tiles, that.tiles);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> neighbors = new Stack<Board>();
        
        // Possible moves (up, down, left, right)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = blankRow + dr[i];
            int newCol = blankCol + dc[i];

            // Check if the new position is within bounds
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                // Create a new board for the neighbor
                int[][] neighborTiles = copyTiles();
                // Swap the blank with the neighbor tile
                swap(neighborTiles, blankRow, blankCol, newRow, newCol);
                neighbors.push(new Board(neighborTiles));
            }
        }
        return neighbors;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int[][] twinTiles = copyTiles();

        // Find two non-blank tiles to swap
        // We can just pick (0,0) and (0,1)
        // If one is blank, pick (1,0) and (1,1)
        int r1 = 0, c1 = 0, r2 = 0, c2 = 1;

        if (twinTiles[r1][c1] == 0 || twinTiles[r2][c2] == 0) {
            // If first pair doesn't work (e.g., blank is at (0,0) or (0,1)),
            // use a different pair. (1,0) and (1,1) is a safe bet for n >= 2.
            r1 = 1;
            c1 = 0;
            r2 = 1;
            c2 = 1;
        }

        // Swap the two chosen tiles
        swap(twinTiles, r1, c1, r2, c2);
        return new Board(twinTiles);
    }

    // Helper to create a deep copy of the tiles
    private int[][] copyTiles() {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            // .clone() is efficient for 1D arrays
            copy[i] = this.tiles[i].clone();
        }
        return copy;
    }

    // Helper to swap two elements in a 2D array
    private void swap(int[][] a, int r1, int c1, int r2, int c2) {
        int temp = a[r1][c1];
        a[r1][c1] = a[r2][c2];
        a[r2][c2] = temp;
    }


    // unit testing (not graded)
    public static void main(String[] args) {
        // Example from puzzle04.txt
        int[][] arr = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
        Board b = new Board(arr);
        
        System.out.println("Initial Board:");
        System.out.println(b);
        System.out.println("Dimension: " + b.dimension());
        System.out.println("Hamming: " + b.hamming());
        System.out.println("Manhattan: " + b.manhattan());
        System.out.println("Is Goal: " + b.isGoal());

        System.out.println("\nNeighbors:");
        for (Board neighbor : b.neighbors()) {
            System.out.println(neighbor);
        }

        System.out.println("Twin:");
        System.out.println(b.twin());

        // Goal board
        int[][] goalArr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board goal = new Board(goalArr);
        System.out.println("\nGoal Board:");
        System.out.println(goal);
        System.out.println("Goal Hamming: " + goal.hamming());
        System.out.println("Goal Manhattan: " + goal.manhattan());
        System.out.println("Goal Is Goal: " + goal.isGoal());
        
        System.out.println("\nEquals check (self): " + b.equals(b));
        System.out.println("Equals check (goal): " + b.equals(goal));
    }
}
