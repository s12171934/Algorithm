import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] input = br.readLine().toCharArray();
    ArrayList<int[]> list = new ArrayList<>();
    int cntK = 0;
    for (int i = 0 ; i < input.length ; i++) {
      if (input[i] == 'K') cntK++;
      else list.add(new int[]{cntK, 0});
    }
    cntK = 0;
    int idx = list.size() - 1;
    for (int i = input.length - 1 ; i >= 0 ; i--) {
      if (input[i] == 'K') cntK++;
      else list.get(idx--)[1] = cntK;
    }
    int sIdx = 0, eIdx = list.size() - 1, ans = 0;
    while (sIdx <= eIdx) {
      int[] s = list.get(sIdx), e = list.get(eIdx);
      ans = Math.max(ans, eIdx - sIdx + 1 + 2 * Math.min(s[0], e[1]));
      if (s[0] < e[1]) sIdx++;
      else eIdx--;
    }
    System.out.println(ans);
  }
}
