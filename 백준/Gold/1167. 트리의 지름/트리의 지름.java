import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int V;
    static List<Node>[] graph;
    static int result;
    public static void main(String[] args) throws Exception {
        V = read();
        graph = new List[V + 1];
        for (int i = 0; i < V; i++) {
            int n1 = read();
            graph[n1] = new ArrayList<>();
            while (true) {
                int n2 = read();
                if (n2 == -1) break;
                graph[n1].add(new Node(n2, read()));
            }
        }

        int start = findFarthestNode(1);
        findFarthestNode(start);

        System.out.println(result);
        bufferedReader.close();
    }

    static int findFarthestNode(int start) {
        int farthestNode = 0;
        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.node] = true;
            for(Node neighbor : graph[node.node]) {
                if (visited[neighbor.node]) continue;
                dist[neighbor.node] = dist[node.node] + neighbor.weight;
                queue.add(new Node(neighbor.node, dist[neighbor.node]));
            }
        }

        for (int i = 1; i <= V; i++) {
            if (result >= dist[i]) continue;
            result = dist[i];
            farthestNode = i;
        }

        return farthestNode;
    }

    static class Node {
        int node, weight;
        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int read() throws Exception {
        int result = 0;
        int sign = 1;
        while (true) {
            int n = bufferedReader.read();
            if (n == 32 || n == 10) break;
            if (n == 45) {
                sign = -1;
                continue;
            }
            result = 10 * result + sign * (n - 48);
        }
        return result;
    }
}