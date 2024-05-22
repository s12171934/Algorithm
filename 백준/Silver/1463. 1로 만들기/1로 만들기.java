import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            makeOne(i + 1);
        }
        System.out.println(makeOne(N));
        bufferedReader.close();
    }

    static int makeOne(int N) {
        if (N != 1 && dp[N] == 0) {
            if (N % 6 == 0) {
                dp[N] = Math.min(Math.min(makeOne(N / 3), makeOne(N / 2)), makeOne(N - 1)) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(makeOne(N / 3), makeOne(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(makeOne(N / 2), makeOne(N - 1)) + 1;
            } else {
                dp[N] = makeOne(N - 1) + 1;
            }
        }
        return dp[N];
    }
}