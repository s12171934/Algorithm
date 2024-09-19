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
    int N = read(), K = read();
    for (int i = 0; i < K; i++) {
      if (N % 3 == 2 || N == 1) N -= 1;
      else N = N / 3 * 2 + N % 3;
      if (N == 0) break;
    }
    System.out.println(N == 0 ? "minigimbob" : "water");
  }
}