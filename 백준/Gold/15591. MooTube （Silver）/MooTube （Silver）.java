import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static StringBuilder res =  new StringBuilder();
  static ArrayList<Node>[] graph;
  static int N;

  static int read() throws Exception {
    if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    return Integer.parseInt(st.nextToken());
  }

  static class Node {
    int n, usado;
    Node (int n, int usado) {
      this.n = n;
      this.usado = usado;
    }
  }

  static void BFS(int K, int start) {
    Queue<Integer> q = new ArrayDeque<>();
    int cnt = 0;
    boolean[] visited = new boolean[N + 1];
    visited[start] = true;
    q.add(start);

    while (!q.isEmpty()) {
      int cur = q.poll();
      for (Node next : graph[cur]) {
        if (next.usado < K || visited[next.n]) continue;
        visited[next.n] = true;
        cnt++;
        q.add(next.n);
      }
    }

    res.append(cnt).append("\n");
  }

  public static void main(String[] args) throws Exception {
    N = read();
    int Q = read();
    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
    for (int i = 0; i < N - 1; i++) {
      int n1 = read(), n2 = read(), usado = read();
      graph[n1].add(new Node(n2, usado));
      graph[n2].add(new Node(n1, usado));
    }
    for (int i = 0; i < Q; i++) BFS(read(), read());
    System.out.println(res);
  }
}