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
        int N = read();
        int K = read();
        int len = 100_001;
        int[] move = new int[]{-1, 1};
        int[] arr = new int[len];
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(arr, 100_001);
        arr[N] = 0;
        queue.add(N);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node]) continue;
            visited[node] = true;

            for (int i : move) {
                int x = node + i;
                if(x < 0 || x >= len) continue;
                if(visited[x]) continue;
                arr[x] = Math.min(arr[x], arr[node] + 1);
                queue.add(x);
            }

            int twice = node;
            if (twice == 0) continue;
            while (twice <= len / 2) {
                twice *= 2;
                if (visited[twice]) continue;
                arr[twice] = Math.min(arr[twice], arr[node]);
                queue.add(twice);
            }
        }

        System.out.println(arr[K]);
        br.close();
    }
}