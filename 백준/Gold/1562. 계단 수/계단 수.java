import java.io.*;


public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int[][][] dp;
    static int N;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        dp = new int[N + 1][10][1 << 10];
        for(int i = 0; i < 10; i++) dp[1][i][1 << i] = 1;
        for(int n = 2; n <= N; n++) {
            for(int i = 0; i < 10; i++) {
                for(int k = 0; k < 1024; k++) {
                    if(i > 0) dp[n][i][k | 1 << i] += dp[n - 1][i - 1][k];
                    if(i < 9) dp[n][i][k | 1 << i] += dp[n - 1][i + 1][k];
                    dp[n][i][k | 1 << i] %= 1_000_000_000;
                }
            }
        }

        int ans = 0;
        for(int i = 1; i < 10; i++) {
            ans += dp[N][i][(1 << 10) - 1];
            ans %= 1_000_000_000;
        }

        System.out.println(ans);
        bufferedReader.close();
    }
}