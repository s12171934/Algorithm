import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        int[] minWeights = new int[N + 1];
        Arrays.fill(minWeights, 1_000_000_000);
        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            graph[read()].add(new Node(read(), read()));
        }
        int start = read();
        int end = read();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        minWeights[start] = 0;
        pq.add(new Node(start, minWeights[start]));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if(node.weight > minWeights[node.node]) continue;
            for(Node n : graph[node.node]) {
                if(minWeights[n.node] <= minWeights[node.node] + n.weight) continue;
                minWeights[n.node] = minWeights[node.node] + n.weight;
                pq.add(new Node(n.node, minWeights[n.node]));
            }
        }

        System.out.println(minWeights[end]);
        br.close();
    }

    static class Node implements Comparable<Node> {
        int node, weight;
        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
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
