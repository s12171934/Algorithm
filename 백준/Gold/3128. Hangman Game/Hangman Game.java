import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int min = 100;
  static String res;

  static void DFS(int now, int cnt, int alphabets, String route) {
    if (alphabets == 0) {
      if (cnt < min) {
        min = cnt;
        res = route;
      }
      return;
    }
    for (int i = 0; i < 26; i++) {
      if ((alphabets & 1 << ((now + i) % 26)) == 0) continue;
      DFS((now + i) % 26, cnt + i + 1, alphabets & ~(1 << ((now + i) % 26)), route + (char)('A' + (now + i) % 26));
      break;
    }
    for (int i = 0; i < 26; i++) {
      if ((alphabets & 1 << ((now - i + 26) % 26)) == 0) continue;
      DFS((now - i + 26) % 26, cnt + i + 1, alphabets & ~(1 << ((now - i + 26) % 26)), route + (char)('A' + (now - i + 26) % 26));
      break;
    }
  }

  public static void main(String[] args) throws Exception {
    char[] arr = br.readLine().toCharArray();
    int alphabets = 0, start = 0;
    for (char c : arr) if (c != ' ') alphabets |= 1 << (c - 'A');
    if (alphabets % 2 == 1) {
      start++;
      alphabets -= 1;
    }
    DFS(0, start, alphabets, start == 1 ? "A" : "");
    System.out.println(min);
    System.out.println(res);
  }
}