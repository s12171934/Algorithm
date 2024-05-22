import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;
    public static void main(String[] args) throws Exception {
        int n = read();
        dp = new int[n + 1];
        for(int i = 1; i <= Math.sqrt(n); i++) dp[i * i] = 1;
        System.out.println(fourSquare(n));
        br.close();
    }

    public static int fourSquare(int n) {
        if(dp[n] != 0) return dp[n];
        int res = n;
        for(int i = (int)Math.sqrt(n); i > 0; i--) {
            res = Math.min(res, fourSquare(n - i * i) + 1);
        }
        dp[n] = res;
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