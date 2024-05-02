import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        int V = read();
        int E = read();
        int K = read();
        int[] dist = new int[V + 1];
        boolean[] complete = new boolean[V + 1];
        List<Node>[] matrix = new ArrayList[V + 1];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(K,0));


        Arrays.fill(dist, 100000000);
        for (int i = 1; i <= V; i++) {
            matrix[i] = new ArrayList<>();
        }
        dist[K] = 0;

        for (int i = 0; i < E; i++) {
            int u = read();
            int v = read();
            int w = read();
            matrix[u].add(new Node(v,w));
        }

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if(complete[node.node]) continue;
            complete[node.node] = true;

            for (Node n : matrix[node.node]) {
                int d = dist[node.node] + n.dist;
                if (dist[n.node] > d) {
                    dist[n.node] = d;
                    priorityQueue.add(new Node(n.node, dist[n.node]));
                }
            }
        }

        for (int i = 1; i <= V; i ++) {
            if (dist[i] == 100000000) {
                stringBuilder.append("INF\n");
                continue;
            }
            stringBuilder.append(dist[i]).append("\n");
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    static int read() throws Exception {
        int res = 0;
        while (true) {
            int pointer = bufferedReader.read();
            if (pointer == 32 || pointer == 10) {
                return res;
            }
            res = 10 * res + pointer - 48;
        }
    }

    public static class Node implements Comparable<Node> {
        private int node;
        private int dist;
        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist - o.dist;
        }
    }
}