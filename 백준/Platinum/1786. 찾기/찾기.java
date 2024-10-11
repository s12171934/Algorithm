import java.io.*;

public class Main {
  static int count;
  static StringBuilder res = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] T = br.readLine().toCharArray(), P = br.readLine().toCharArray();
    int[] pi = makePiTable(P);
    KMP(T,P,pi);
    System.out.println(count);
    System.out.println(res.toString().trim());
  }

  static int[] makePiTable(char[] P) {
    int pi[] = new int[P.length], prefix = 0;
    for (int i = 1; i < P.length; i++) {
      while (prefix > 0 && P[i] != P[prefix]) prefix = pi[prefix - 1];
      if (P[i] == P[prefix]) pi[i] = ++prefix;
    }
    return pi;
  }

  static void KMP(char[] T,char[] P,int[] pi){
    int start = 0, check = 0;
    while (start <= T.length - P.length) {
      if (T[start] != P[0]) {
        start++;
        continue;
      }
      int p = check;
      for (; p < P.length; p++) {
        if (T[start + p] != P[p]) break;
      }
      if (p == P.length) {
        count++;
        res.append(start + 1).append(" ");
      }
      check = pi[p - 1];
      start += p - check;
    }
  }
}
