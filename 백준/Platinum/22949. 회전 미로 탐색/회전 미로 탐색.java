import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int k = Integer.parseInt(br.readLine());
        Queue<Node> q = new LinkedList<>();
        int[][] deltas = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][][] visited = new boolean[4 * k][4 * k][4];

        char[][] matrix = new char[4 * k][4 * k];
        for (int i = 0; i < 4 * k; i++){
            matrix[i] = br.readLine().toCharArray();
        }
        Node end = null;
        for (int i = 0; i < 4 * k; i++){
            for (int j = 0; j < 4 * k; j++){
                if (matrix[i][j] == 'S') {
                    q.add(new Node(i, j, 0,0));
                    visited[i][j][0] = true;
                }
                if (matrix[i][j] == 'E') end = new Node(i, j, 0, 0);
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (end.x == cur.x && end.y == cur.y) {
                System.out.println(cur.t);
                return;
            }

            int sectionX = cur.x / 4;
            int sectionY = cur.y / 4;

            for (int[] d : deltas) {
                int x = cur.x + d[0];
                int y = cur.y + d[1];
                int r = (cur.r + 1) % 4;

                if (x < 0 || y < 0 || x / 4 != sectionX || y / 4 != sectionY) {
                    int[] newXY = convert(cur.x,cur.y,cur.r,d);
                    x = newXY[0];
                    y = newXY[1];
                    r = 1;
                }

                if (x < 0 || y < 0 || x >= 4 * k || y >= 4 * k) continue;
                if (matrix[x][y] == '#') continue;
                if (visited[x][y][r]) continue;
                visited[x][y][r] = true;
                q.add(new Node(x,y,r,cur.t + 1));
            }
        }

        System.out.println(-1);
    }

    public static int[] convert(int x, int y, int r, int[] d) {
        int innerX = x % 4;
        int innerY = y % 4;

        switch (r) {
            case 0:
                return new int[]{x + d[0], y + d[1]};
            case 1:
                return new int[]{x - innerX + innerY + d[1], y - innerY + 3 - innerX - d[0]};
            case 2:
                return new int[]{x - innerX + 3 - innerX - d[0], y - innerY + 3 - innerY - d[1]};
            case 3:
                return new int[]{x - innerX + 3- innerY - d[1], y - innerY + innerX + d[0]};
        }
        return null;
    }

    public static class Node {
        int x, y, r, t;

        public Node(int x, int y, int r, int t) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.t = t;
        }
    }
}