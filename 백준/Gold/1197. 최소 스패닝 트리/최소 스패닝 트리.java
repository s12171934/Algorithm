import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int[] check;
    public static void main(String[] args) throws Exception {
        int V = read();
        int E = read();

        Trunk[] arr = new Trunk[E];
        for (int i = 0; i < E; i++) arr[i] = new Trunk(read(), read(), read());
        Arrays.sort(arr);

        int res = 0;
        int count = 0;
        int trunkIdx = 0;
        check = new int[V + 1];
        for (int i = 1; i <= V; i++) check[i] = i;

        while (count < V - 1) {
            int n1 = Math.min(arr[trunkIdx].n1,arr[trunkIdx].n2);
            int n2 = Math.max(arr[trunkIdx].n1,arr[trunkIdx].n2);
            int weight = arr[trunkIdx].weight;
            trunkIdx++;
            if (parent(n1) == parent(n2)) continue;
            res += weight;
            count++;
            check[parent(n2)] = check[n1];
        }

        System.out.println(res);
        bufferedReader.close();
    }

    public static int parent(int node) {
        while (node != check[node]) node = check[node];
        return node;
    }

    public static class Trunk implements Comparable<Trunk> {
        int n1, n2, weight;
        public Trunk(int n1, int n2, int weight) {
            this.n1 = n1;
            this.n2 = n2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Trunk o) {
            return this.weight - o.weight;
        }
    }

    public static int read() throws Exception {
        int res = 0;
        int mode = 1;
        while (true) {
            int n = bufferedReader.read();
            if (n == 10 || n == 32) return res;
            if (n == 45) {
                mode = -1;
                continue;
            }
            res = res * 10 + mode * (n - 48);
        }
    }
}