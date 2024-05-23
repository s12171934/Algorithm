import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        int ans = 0;
        int[] x = new int[]{-1, 1, 0, 0};
        int[] y = new int[]{0, 0, -1, 1};
        char[][] grid = new char[N][M];
        for(int i = 0; i < N; i++) grid[i] = br.readLine().toCharArray();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(grid[cur.x][cur.y] == '0') continue;
            grid[cur.x][cur.y] = '0';
            if(cur.x == N - 1 && cur.y == M - 1) ans = cur.count;

            for(int i = 0; i < 4; i++) {
                int newX = cur.x + x[i];
                int newY = cur.y + y[i];
                if(newX < 0 || newX >= N || newY < 0 || newY >= M) continue;
                if(grid[newX][newY] == '0') continue;
                queue.add(new Node(newX, newY, cur.count + 1));
            }
        }

        System.out.println(ans);
        br.close();
    }

    static class Node {
        int x, y, count;
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int read() throws IOException {
        int res = 0;
        while (true) {
            int n = br.read();
            if(n == 10 || n == 32) return res;
            res = 10 * res + n - 48;
        }
    }
}
