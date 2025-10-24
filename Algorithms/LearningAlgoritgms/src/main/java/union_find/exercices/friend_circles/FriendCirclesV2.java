package union_find.exercices.friend_circles;

public class FriendCirclesV2 {

    public static int findCircleNum(int n, int[][] friendships) {
        if (n == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(n);

        for (int[] friendship : friendships) {
            int p1 = friendship[0];
            int p2 = friendship[1];
            uf.union(p1, p2);
        }

        return uf.getCount();
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] friendships = {
                {0, 1},
                {1, 2},
                {3, 4}
        };

        int numberOfCircles = findCircleNum(n, friendships);
        System.out.println("Número de círculos de amigos: " + numberOfCircles); // Salida: 2

        // Otro ejemplo
        int n2 = 6;
        int[][] friendships2 = {
                {0, 1}, {0, 2}, {3, 4}, {4, 5}
        };

        System.out.println("Número de círculos de amigos: " + findCircleNum(n2, friendships2)); // Salida: 2
    }
}