import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  static Node[][] matrix;
  static int N, H, D;

  public static void main(String[] args) throws IOException {
    N = read();
    H = read();
    D = read();
    matrix = new Node[N][N];

    Queue<Node> q = new ArrayDeque<>();

    // INIT
    for (int i = 0; i < N; i++) {
      char[] arr = br.readLine().toCharArray();
      for (int j = 0; j < N; j++) {
        Node node = new Node(i, j, 0, 0, arr[j]);
        matrix[i][j] = node;
        if (node.c == 'S') {
          node.hp = H;
          node.visited = true;
          q.add(node);
        }
      }
    }

    // BFS
    while (!q.isEmpty()) {
      Node cur = q.poll();

      // BFS탐색이므로 최초 E 도달 시 최소시간
      if (cur.c == 'E') {
        System.out.println(cur.t);
        return;
      }

      // 체력이 0인 경우 탐색 중지
      if (cur.hp == 0)
        continue;

      for (int[] d : deltas) {
        int x = cur.x + d[0];
        int y = cur.y + d[1];
        if (x < 0 || y < 0 || x >= N || y >= N) continue;
        Node next = matrix[x][y];
        // 이미 방문한 경우에도 우산을 씀으로서 방문했던 시점보다 더 체력이 높으면 다시 방문이 필요함
        if (next.visited) {
          if (cur.hp + cur.u - 1 <= next.hp + next.u) continue;
        }
        next.visited = true;
        next.hp = cur.hp;
        next.u = cur.u;
        if (next.c == 'U') {
          next.u = D;
          next.c = '.';
        }
        if (next.u == 0) {
          next.hp--;
        } else {
          next.u--;
        }
        next.t = cur.t + 1;
        q.add(next);
      }
    }

    System.out.println(-1);
  }

  static class Node {
    int x, y, hp, u, t, c;
    boolean visited;

    Node(int x, int y, int hp, int t, int c) {
      this.x = x;
      this.y = y;
      this.hp = hp;
      this.t = t;
      this.c = c;
    }
  }

  static int read() throws IOException {
    int res = 0;
    while (true) {
      int r = br.read();
      if (r == 10 || r == 32)
        return res;
      if (r == 13)
        continue;
      res = 10 * res + r - 48;
    }
  }
}