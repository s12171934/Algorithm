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
        int[][] arr = new int[N + 1][2];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            arr[i][0] = read();
            arr[i][1] = read();
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[j][i] = dp[j - 1][i];
                if(arr[j][0] > i) continue;
                dp[j][i] = Math.max(dp[j][i], dp[j - 1][i - arr[j][0]] + arr[j][1]);
            }
        }

        System.out.println(dp[N][K]);
        br.close();
    }
}