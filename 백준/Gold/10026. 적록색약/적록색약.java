import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] graph;
    static int[] x = new int[]{1, -1, 0, 0};
    static int[] y = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        int n = read();
        int rgb = 0;
        int rb = 0;
        graph = new char[n][n];
        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 'O' || graph[i][j] == 'X') continue;
                if (graph[i][j] == 'B') rb++;
                rgb++;
                BFS(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 'X') continue;
                rb++;
                BFS(i, j);
            }
        }

        System.out.println(rgb + " " + rb);
        br.close();
    }

    static void BFS(int i, int j) {
        char c = graph[i][j];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));
        if (graph[i][j] == 'R' || graph[i][j] == 'G') graph[i][j] = 'O';
        else graph[i][j] = 'X';

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + x[k];
                int ny = cur.y + y[k];
                if (nx < 0 || ny < 0 || nx >= graph.length || ny >= graph.length) continue;
                if (graph[nx][ny] != c) continue;
                q.add(new Node(nx, ny));
                if (graph[nx][ny] == 'R' || graph[nx][ny] == 'G') graph[nx][ny] = 'O';
                else graph[nx][ny] = 'X';
            }
        }
    }
    
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
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
