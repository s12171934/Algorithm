import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Node>> graph;
    static int n;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        n = read();
        int e = read();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < e; i++) {
            int n1 = read();
            int n2 = read();
            int weight = read();
            graph.get(n1).add(new Node(n1,n2,weight));
            graph.get(n2).add(new Node(n2,n1,weight));
        }

        int[] nodes = {1, read(), read(), n};
        int sm1 = route(nodes[0],nodes[1]);
        int sm2 = route(nodes[0],nodes[2]);
        int mm = route(nodes[1],nodes[2]);
        int me1 = route(nodes[1],nodes[3]);
        int me2 = route(nodes[2], nodes[3]);

        int ans = Math.min(sm1 + mm + me2, sm2 + mm + me1);
        System.out.println(ans >= 3_000_000 ? -1 : ans);



        System.out.println(sb);
    }

    public static int route(int node1, int node2) {
        int[] len = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(node1,0,0));
        int res = 3_000_000;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            len[node.n1] = node.w;
            visited[node.n1] = true;

            if(node.n1 == node2) {
                res = node.w;
                break;
            }

            for (Node node3 : graph.get(node.n1)) {
                if (visited[node3.n2]) continue;
                pq.add(new Node(node3.n2, 0, len[node.n1] + node3.w));
            }
        }

        return res;
    }

    public static class Node implements Comparable<Node> {
        int n1,n2,w;

        public Node(int n1, int n2, int w) {
            this.n1 = n1;
            this.n2 = n2;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    public static int read() throws Exception {
        int res = 0;
        while (true) {
            int r = br.read();
            if(r == 10 || r == 32) return res;
            res = 10 * res + r - 48;
        }
    }
}