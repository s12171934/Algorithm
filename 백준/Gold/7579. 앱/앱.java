import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  static int read() throws Exception {
    if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    return Integer.parseInt(st.nextToken());
  }

  public static void main(String[] args) throws Exception {
    int N = read(), M = read();
    ArrayList<int[]> programs = new ArrayList<>();

    for (int i = 0; i < N; i++) {programs.add(new int[]{read(), -1});}
    for (int i = 0, c = 0; i < N; i++) {
      int k = read();
      if(k == 0){
        M -= programs.get(c)[0];
        programs.remove(c);
        continue;
      }
      programs.get(c++)[1] = k;
    }
    N = programs.size();
    int[][] dp = new int[N + 1][N * 100 + 1];
    int res = N * 100 + 1;

    for (int i = 1; i <= N; i++) {
      int[] program = programs.get(i - 1);
      for (int j = 100 * N; j >= 0; j--) {
        if (j < program[1]) dp[i][j] = dp[i -1][j];
        else dp[i][j] = Math.max(dp[i -1][j - program[1]] + program[0], dp[i - 1][j]);
        if (dp[i][j] >= M) res = Math.min(res, j);
      }
    }

    System.out.println(res == N * 100 + 1 ? 0 : res);
  }
}