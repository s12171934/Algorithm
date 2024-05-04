import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int read() throws Exception {
        int res = 0;
        while (true) {
            int n = br.read();
            if (n == 10 || n == 32) {
                return res;
            }
            res = 10 * res + n - 48;
        }

    }
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int INF = 100_000_000;
        int n = read();
        int m = read();
        int[][] graph = new int[n][n];
        for (int[] i : graph) Arrays.fill(i, INF);
        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int a = read() - 1;
            int b = read() - 1;
            int c = read();
            graph[a][b] = Math.min(graph[a][b], c);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[k][j] + graph[i][k]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(graph[i][j] == INF ? 0 : graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}