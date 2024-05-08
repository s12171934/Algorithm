import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;
    static int[] times;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        int T = read();
        for (int i = 0; i < T; i++) {
            int N = read();
            int K = read();
            times = new int[N + 1];
            dp = new int[N + 1];
            Arrays.fill(dp, -1);
            graph = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
                times[j] = read();
            }
            for (int j = 0; j < K; j++) {
                int before = read();
                int after = read();
                graph[after].add(before);
            }
            for (int j = 1; j <= N; j++) {
                if(graph[j].isEmpty()) dp[j] = times[j];
            }
            stringBuilder.append(minTime(read())).append("\n");
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
    public static int minTime (int node) {
        if (dp[node] != -1) return dp[node];
        int res = 0;
        for(int n : graph[node]) {
            res = Math.max(res, minTime(n) + times[node]);
        }
        dp[node] = res;
        return res;
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