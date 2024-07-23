import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        int N = read();
        int M = read();
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = str[j] - 48;
            }
        }

        int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};


        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j] != 0 || visited[i][j]) continue;

                Queue<Node> q = new LinkedList<>();
                Set<Node> set = new HashSet<>();

                visited[i][j] = true;
                q.add(new Node(i, j));
                int count = 1;
                while(!q.isEmpty()) {
                    Node node = q.poll();

                    for (int[] d : deltas) {
                        int x = node.x + d[0];
                        int y = node.y + d[1];

                        if (x < 0 || x >= N || y < 0 || y >= M) continue;

                        if (matrix[x][y] == 0) {
                            if (visited[x][y]) continue;
                            visited[x][y] = true;
                            count++;
                            q.add(new Node(x, y));
                        }
                        else {
                            set.add(new Node(x, y));
                        }

                    }
                }
                for (Node node : set) {
                    matrix[node.x][node.y] += count;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(matrix[i][j] % 10);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 10000 * x + y;
        }

        @Override
        public boolean equals(Object o) {
            return this.x == ((Node)o).x && this.y == ((Node)o).y;
        }
    }


    public static int read() throws IOException {
        int res = 0;
        while (true) {
            int r = br.read();
            if (r == 10 || r == 32) return res;
            if (r == 13) continue;
            res = 10 * res + (r - 48);
        }
    }
}