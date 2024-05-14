import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        ArrayList<int[]> programs = new ArrayList<>();

        for (int i = 0; i < N; i++) {programs.add(new int[]{read(), -1});}
        int c = 0;
        for (int i = 0; i < N; i++) {
            int k = read();
            if(k == 0){
                M -= programs.get(c)[0];
                programs.remove(c);
                continue;
            }
            programs.get(c)[1] = k;
            c++;
        }
        N = programs.size();
        dp = new int[N][N * 100 + 1];
        int res = N * 100 + 1;

        for (int i = 0; i < N; i++) {
            int[] program = programs.get(i);

            for (int j = 100 * N; j >= 0; j--) {

                if (i == 0) {
                    if (j < program[1]) continue;
                    dp[i][j] = program[0];
                }
                else {
                    if (j < program[1]) dp[i][j] = dp[i -1][j];
                    else dp[i][j] = Math.max(dp[i -1][j - program[1]] + program[0], dp[i - 1][j]);
                }

                if (dp[i][j] >= M) res = Math.min(res, j);
            }
        }

        System.out.println(res == N * 100 + 1 ? 0 : res);

        bufferedReader.close();
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