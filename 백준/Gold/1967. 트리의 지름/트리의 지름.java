import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static List<Node>[] matrix;
    static int result, n;
    public static void main(String[] args) throws Exception {
        n = read();
        matrix = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            matrix[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int n1 = read();
            int n2 = read();
            int weight = read();
            matrix[n1].add(new Node(n2,weight));
            matrix[n2].add(new Node(n1,weight));
        }

        int startNode = findFarthestNode(1);
        findFarthestNode(startNode);
        System.out.println(result);

        bufferedReader.close();
    }

    static int findFarthestNode(int start) {
        result = 0;
        int farthestNode = 0;
        int[] dist = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            check[num] = true;
            for(Node node : matrix[num]) {
                if (check[node.node]) continue;
                dist[node.node] = dist[num] + node.weight;
                queue.add(node.node);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (result < dist[i]) {
                result = dist[i];
                farthestNode = i;
            }
        }

        return farthestNode;
    }

    static class Node {
        int node, weight;

        Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
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
}