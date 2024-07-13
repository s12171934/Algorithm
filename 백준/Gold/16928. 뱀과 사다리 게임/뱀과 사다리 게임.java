import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[] nums = new int[101];
        int[] visited = new int[101];
        for (int i = 0; i <= 100; i++) {
            nums[i] = i;
        }
        for (int i = 0; i < n + m; i++) {
            nums[read()] = read();
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int node = q.poll();

            if (node == 100) {
                System.out.println(visited[node]);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                if (node + i > 100) continue;
                if (nums[node + i] == 1 || visited[nums[node + i]] != 0) continue;
                visited[nums[node + i]] = visited[node] + 1;
                q.add(nums[node + i]);
            }
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