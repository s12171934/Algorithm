import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
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
    static class Node {
        int node, weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        int TC = read();
        for (int i = 0; i < TC; i++) {
            int N = read();
            int M = read();
            int W = read();
            negativeCycle(N,M,W);
        }

        System.out.println(sb);
        br.close();
    }

    public static void negativeCycle(int N, int M, int W) throws Exception {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 987654321);
        dist[1] = 0;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int n1 = read();
            int n2 = read();
            int weight = read();

            graph.get(n1).add(new Node(n2, weight));
            graph.get(n2).add(new Node(n1, weight));
        }

        for (int i = 0; i < W; i++) {
            int start = read();
            int end = read();
            int weight = -1 * read();

            graph.get(start).add(new Node(end, weight));
        }

        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j <= N; j++) {
                for (Node node : graph.get(j)) {
                    if (dist[node.node] > dist[j] + node.weight) {
                        dist[node.node] = dist[j] + node.weight;
                        update = true;
                    }
                }
            }

            if (!update) break;
        }

        if (update) {
            for (int j = 1; j <= N; j++) {
                for (Node node : graph.get(j)) {
                    if (dist[node.node] > dist[j] + node.weight) {
                        sb.append("YES\n");
                        return;
                    }
                }
            }
        }

        sb.append("NO\n");
    }
}