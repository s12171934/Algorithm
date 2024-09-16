import java.io.*;
import java.util.*;

public class Main {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static StringTokenizer st;
   static int N, list[][];
   static List<Integer> res = new ArrayList<>();

   static int read() throws Exception {
       if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
       return Integer.parseInt(st.nextToken());
   }

   static void init() throws Exception {
        N = read(); list = new int[N][];
        for (int i = 0; i < N; i++) list[i] = new int[]{read(), read(), 0};
        Arrays.sort(list, Comparator.comparingInt(o -> o[0]));
   }

   static void solve() {
       Queue<int[]> use = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
       Queue<Integer> wait = new PriorityQueue<>();
       use.add(list[0]);
       res.add(1);
       for (int i = 1; i < N; i++) {
           while (!use.isEmpty() && use.peek()[1] < list[i][0]) wait.add(use.poll()[2]);
           if (wait.isEmpty()) {
               list[i][2] = res.size();
               res.add(1);
           }
           else {
               list[i][2] = wait.poll();
               res.set(list[i][2], res.get(list[i][2]) + 1);
           }
           use.add(list[i]);
       }
   }

   static void result() {
       StringBuilder sb = new StringBuilder();
       sb.append(res.size()).append('\n');
       for (int r : res) sb.append(r).append(' ');
       System.out.println(sb);
   }

    public static void main(String[] args) throws Exception {
        init();
        solve();
        result();
    }
}