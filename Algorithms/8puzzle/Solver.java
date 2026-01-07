import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {

    private final boolean solvable;
    private final int totalMoves;
    private final Stack<Board> solutionPath;

    // Private inner class for search nodes
    private class SearchNode implements Comparable<SearchNode> {
        private final Board board;
        private final int moves;
        private final SearchNode previous;
        private final int priority; // Manhattan + moves

        public SearchNode(Board board, int moves, SearchNode previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
            // Cache the priority (Manhattan + moves)
            this.priority = board.manhattan() + this.moves;
        }

        @Override
        public int compareTo(SearchNode that) {
            // Compare based on priority
            return Integer.compare(this.priority, that.priority);
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException("Initial board cannot be null");
        }

        // Priority queue for the main puzzle
        MinPQ<SearchNode> mainPQ = new MinPQ<>();
        // Priority queue for the twin puzzle (to detect unsolvability)
        MinPQ<SearchNode> twinPQ = new MinPQ<>();

        // Insert initial nodes
        mainPQ.insert(new SearchNode(initial, 0, null));
        twinPQ.insert(new SearchNode(initial.twin(), 0, null));

        SearchNode mainGoalNode = null;
        SearchNode twinGoalNode = null;

        // Run A* in lockstep on both main and twin puzzles
        while (mainGoalNode == null && twinGoalNode == null) {
            
            // --- Process Main Puzzle ---
            SearchNode currentMain = mainPQ.delMin();
            if (currentMain.board.isGoal()) {
                mainGoalNode = currentMain;
            } else {
                for (Board neighbor : currentMain.board.neighbors()) {
                    // Critical optimization: don't enqueue the previous board
                    if (currentMain.previous == null || !neighbor.equals(currentMain.previous.board)) {
                        mainPQ.insert(new SearchNode(neighbor, currentMain.moves + 1, currentMain));
                    }
                }
            }

            // --- Process Twin Puzzle ---
            SearchNode currentTwin = twinPQ.delMin();
            if (currentTwin.board.isGoal()) {
                twinGoalNode = currentTwin;
            } else {
                for (Board neighbor : currentTwin.board.neighbors()) {
                    // Critical optimization
                    if (currentTwin.previous == null || !neighbor.equals(currentTwin.previous.board)) {
                        twinPQ.insert(new SearchNode(neighbor, currentTwin.moves + 1, currentTwin));
                    }
                }
            }
        }

        // Check which puzzle was solved
        if (mainGoalNode != null) {
            this.solvable = true;
            this.totalMoves = mainGoalNode.moves;
            this.solutionPath = new Stack<Board>();
            // Reconstruct path
            SearchNode node = mainGoalNode;
            while (node != null) {
                solutionPath.push(node.board);
                node = node.previous;
            }
        } else {
            // If twin solved, original is unsolvable
            this.solvable = false;
            this.totalMoves = -1;
            this.solutionPath = null;
        }
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return this.solvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return this.totalMoves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return this.solutionPath;
    }

    // test client (from prompt)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
