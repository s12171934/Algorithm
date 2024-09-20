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
    int N = read();
    boolean[] switches = new boolean[N];
    for (int i = 0; i < N; i++) switches[i] = read() == 1;
    int M = read();
    for (int i = 0; i < M; i++) {
      int gender = read(), start = read(), cnt = 0;
      if (gender == 1) {
        while(start * ++cnt <= N) switches[start * cnt - 1] = !switches[start * cnt - 1];
      } else {
        start -= 1;
        switches[start] = !switches[start];
        while(start + ++cnt < N && start - cnt >= 0 && switches[start + cnt] == switches[start - cnt]) {
          switches[start - cnt] = !switches[start - cnt];
          switches[start + cnt] = !switches[start + cnt];
        }
      }
    }
    int cnt = 0;
    for (boolean b : switches) {
      cnt ++;
      res.append(b ? 1 : 0).append(cnt == 20 ? "\n" : " ");
      cnt %= 20;
    }
    System.out.println(res.toString());
  }
}