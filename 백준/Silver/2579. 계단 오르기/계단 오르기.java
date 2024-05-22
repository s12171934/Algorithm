import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] stairs = new int[n];
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++) stairs[i] = read();
        dp[0][0] = stairs[0];
        if(n > 1) {
            dp[1][0] = stairs[1];
            dp[1][1] = stairs[0] + stairs[1];
        }
        if(n > 2) {
            for(int i = 2; i < n; i++) {
                dp[i][0] = stairs[i] + Math.max(dp[i - 2][0], dp[i - 2][1]);
                dp[i][1] = stairs[i] + dp[i - 1][0];
            }
        }

        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
        br.close();
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