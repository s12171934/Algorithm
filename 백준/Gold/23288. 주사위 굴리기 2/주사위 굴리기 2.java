import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  static int read() throws Exception {
    if (st == null || !st.hasMoreTokens()) st= new StringTokenizer(br.readLine());
    return Integer.parseInt(st.nextToken());
  }

  static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
  static Dice dice = new Dice();
  static int N, M, ans, matrix[][];

  public static void main(String[] args) throws Exception {
    N = read();
    M = read();
    int K = read();
    matrix = new int[N][M];
    for (int i = 0; i < N * M; i++) matrix[i / M][i % M] = read();
    while (K-- > 0) solve();
    System.out.println(ans);
  }

  static void solve() {
    move();
    BFS();
    changeDirection();
  }

  static void move() {
    int x = dice.x + deltas[dice.d][0];
    int y = dice.y + deltas[dice.d][1];
    if (x < 0 || y < 0 || x >= N || y >= M) dice.d = (dice.d + 2) % 4;
    dice.move();
  }

  static void BFS() {
    boolean[][] visited = new boolean[N][M];
    visited[dice.x][dice.y] = true;

    Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{dice.x, dice.y});

    int cnt = 1, target = matrix[dice.x][dice.y];
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int[] d : deltas) {
        int x = cur[0] + d[0];
        int y = cur[1] + d[1];
        if (x < 0 || y < 0 || x >= N || y >= M || matrix[x][y] != target || visited[x][y]) continue;
        visited[x][y] = true;
        cnt++;
        q.add(new int[]{x, y});
      }
    }

    ans += cnt * target;
  }

  static void changeDirection() {
    int diff = dice.dice[6] - matrix[dice.x][dice.y];
    if (diff > 0) {
      dice.d = (dice.d + 1) % 4;
    } else if (diff < 0) {
      dice.d = (dice.d + 3) % 4;
    }
  }

  static class Dice {
    int[] dice;
    int x, y, d;

    Dice() {
      x = 0;
      y = 0;
      d = 1;
      dice = new int[7];
      for (int i = 1; i <= 6; i++) dice[i] = i;
    }

    void move() {
      x += deltas[d][0];
      y += deltas[d][1];
      int temp = dice[6];
      switch (d) {
        case 0:
          dice[6] = dice[2];
          dice[2] = dice[1];
          dice[1] = dice[5];
          dice[5] = temp;
          break;
        case 1:
          dice[6] = dice[3];
          dice[3] = dice[1];
          dice[1] = dice[4];
          dice[4] = temp;
          break;
        case 2:
          dice[6] = dice[5];
          dice[5] = dice[1];
          dice[1] = dice[2];
          dice[2] = temp;
          break;
        case 3:
          dice[6] = dice[4];
          dice[4] = dice[1];
          dice[1] = dice[3];
          dice[3] = temp;
          break;
      }
    }
  }
}
