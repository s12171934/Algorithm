import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] dp;
    private static int[] start;
    private static int[] end;
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
        dp = new int[N][N];
        start = new int[N];
        end = new int[N];

        for (int i = 0; i < N; i++) {
            start[i] = read();
            end[i] = read();
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j ++) {
                matrix(i,j);
            }
        }

        System.out.println(matrix(0, N - 1));

        br.close();
    }

    public static int matrix(int sIdx, int eIdx) {
        if (sIdx == eIdx || dp[sIdx][eIdx] != 0) {
            return dp[sIdx][eIdx];
        }

        int res = Integer.MAX_VALUE;

        for (int i = sIdx; i <= eIdx - 1; i++) {
            int cal = matrix(sIdx, i) + matrix(i + 1, eIdx) + start[sIdx] * end[i] * end[eIdx];
            res = Math.min(res, cal);
        }
        dp[sIdx][eIdx] = res;
        return dp[sIdx][eIdx];

    }
}