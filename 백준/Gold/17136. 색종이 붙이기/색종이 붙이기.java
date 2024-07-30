import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    //list의 잦은 복사를 위해서 2차원 배열보다는 1차원 배열로 사용
    int[] list = new int[100];

    //색종이 한도를 저장
    int[] papers = new int[5];
    Arrays.fill(papers, 5);

    //최대로 색종이를 사용하는 경우가 25 (사실 아님)
    int min = 26;

    for (int i = 0; i < 100; i++) {
      list[i] = read();
    }

    Queue<Node> q = new ArrayDeque<>();
    q.add(new Node(0, list, papers));

    //BFS
    while (!q.isEmpty()) {
      Node cur = q.poll();

      //색종이를 붙힐 수 있을 때까지 이동
      while (cur.x < 100) {
        if (cur.list[cur.x] == 0) {
          cur.x++;
          continue;
        }
        break;
      }

      //배열 마지막에 도달은 1인 구간을 전부 0으로 변경했다는 의미이므로 최솟값 갱신
      if (cur.x == 100) {
        int sum = 25;
        for (int paper : cur.papers) {
          sum -= paper;
        }
        System.out.println(sum);
        return;
      }

      for (int k = 0; k < 5; k++) {
        if (cur.papers[k] == 0)
          continue;
        int[] newPapers = cur.papers.clone();
        int[] newList = cur.list.clone();

        boolean check = true;
        label: for (int i = 0; i <= k; i++) {
          for (int j = 0; j <= k; j++) {
            boolean isTen = (cur.x % 10) + j >= 10;
            int idx = cur.x + (10 * i) + j;
            if (idx >= 100 || newList[idx] == 0 || isTen) {
              check = false;
              break label;
            }
          }
        }

        if (check) {
          newPapers[k]--;
          for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= k; j++) {
              newList[cur.x + (10 * i) + j] = 0;
            }
          }
          q.add(new Node(cur.x, newList, newPapers));
        }
      }
    }

    System.out.println(-1);
  }

  static class Node {
    int[] list, papers;
    int x;

    Node(int x, int[] list, int[] papers) {
      this.x = x;
      this.list = list;
      this.papers = papers;
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
      res = 10 * res + (r - 48);
    }
  }
}
