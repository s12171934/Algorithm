import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  static int read() throws Exception {
    if (st == null || !st.hasMoreTokens()) st= new StringTokenizer(br.readLine());
    return Integer.parseInt(st.nextToken());
  }

  public static void main(String[] args) throws Exception {
    int N = read(), M = read(), ans = Integer.MAX_VALUE, max = 0;
    int[] idx = new int[N];
    int[][] matrix = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) matrix[i][j] = read();
      Arrays.sort(matrix[i]);
    }

    Queue<Integer> list = new PriorityQueue<>(Comparator.comparingInt(n -> matrix[n][idx[n]]));
    for (int i = 0; i < N; i++) {
      list.add(i);
      max = Math.max(max, matrix[i][idx[i]]);
    }

    while (true) {
      int min = list.poll();
      ans = Math.min(ans, max - matrix[min][idx[min]]);
      if(++idx[min] == M) break;
      max = Math.max(max, matrix[min][idx[min]]);
      list.add(min);
    }

    System.out.println(ans);
  }
}
