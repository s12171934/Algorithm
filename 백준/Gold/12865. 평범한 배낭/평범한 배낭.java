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
    int N = read(), K = read(), matrix[][] = new int[N + 1][K + 1];
    for (int i = 1; i <= N; i++) {
      int V = read(), C = read();
      for (int j = 1; j <= K; j++) {
        if (j < V) matrix[i][j] = matrix[i - 1][j];
        else {
          matrix[i][j] = Math.max(matrix[i - 1][j - V] + C, matrix[i - 1][j]);
        }
      }
    }
    System.out.println(matrix[N][K]);
  }
}
