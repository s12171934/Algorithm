import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static StringBuilder res =  new StringBuilder();

  static int read() throws Exception {
    if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    return Integer.parseInt(st.nextToken());
  }

  public static void main(String[] args) throws Exception {
    int TC = read();
    while (TC-- > 0) solve();
    System.out.println(res.toString());

  }

  static void solve() throws Exception {
    int N = read();
    int[][] list = new int[N + 2][];
    for (int i = 0; i < N + 2; i++) list[i] = new int[]{read(), read()};

    Queue<Integer> q = new ArrayDeque<>();
    q.add(0);

    boolean[] visited = new boolean[N + 2];
    visited[0] = true;

    while (!q.isEmpty()) {
      int cur = q.poll();
      if (cur == N + 1) {
        res.append("happy\n");
        return;
      }

      for (int i = 0; i < N + 2; i++) {
        if (visited[i] || Math.abs(list[cur][0] - list[i][0]) + Math.abs(list[cur][1] - list[i][1]) > 1000) continue;
        visited[i] = true;
        q.add(i);
      }
    }

    res.append("sad\n");
  }
}
