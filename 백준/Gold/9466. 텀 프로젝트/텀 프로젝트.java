import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int n;
    static boolean[] visited;
    static boolean[] cycle;
    static Queue<Integer> queue;
    public static void main(String[] args) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        int T = read();
        for (int i = 0; i < T; i++) {
            n = read();
            arr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                arr[j] = read();
            }
            cycle = new boolean[n + 1];
            visited = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                if (visited[j]) continue;
                queue = new LinkedList<>();
                team(j);
            }
            int count = 0;
            for (int j = 1; j <=n; j++) {
                if (cycle[j]) continue;
                count++;
            }
            stringBuilder.append(count).append("\n");
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
    static void team(int node) {
        if (visited[node]) {
            boolean isCycle = false;
            while (!queue.isEmpty()) {
                int q = queue.poll();
                if (q == node) isCycle = true;
                cycle[q] = isCycle;
            }
            return;
        }
        visited[node] = true;
        queue.add(node);
        team(arr[node]);

    }
    public static int read() throws Exception {
        int res = 0;
        while (true) {
            int n = bufferedReader.read();
            if (n == 10 || n == 32) return res;
            res = res * 10 + n - 48;
        }
    }
}