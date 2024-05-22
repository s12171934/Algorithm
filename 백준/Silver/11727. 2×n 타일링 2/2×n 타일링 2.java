import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;
    public static void main(String[] args) throws Exception {
        int n = read();
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) tile(i);
        System.out.println(tile(n));
        br.close();
    }

    public static int tile(int n) {
        if(dp[n] != 0) return dp[n];
        dp[n] = tile(n - 1) + tile(n - 2) * 2;
        dp[n] %= 10007;
        return dp[n];
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