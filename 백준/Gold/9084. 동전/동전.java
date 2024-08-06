import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int TC, N, M, i, j, t;
  static int[] dp, list;

  public static void main(String[] args) throws IOException {
    TC = Integer.parseInt(br.readLine());
    for (t = 0; t < TC; t++) {
      N = Integer.parseInt(br.readLine());

      list = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());

      M = Integer.parseInt(br.readLine());
      dp = new int[M + 1];
      dp[0] = 1;

      for (i = 0; i < N; i++) {
        if (M < list[i]) break;
        for (j = list[i]; j <= M; j++) dp[j] += dp[j - list[i]];
      }

      System.out.println(dp[M]);
    }
  }
}
