import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder res = new StringBuilder();

    static int read() throws Exception {
        if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
    
    public static void main(String[] args) throws Exception {
        while (init()) {
            solve();
        }
        System.out.println(res.toString());
    }

    static int n;
    static int[] heights;
    
    static boolean init() throws Exception {
        n = read();
        if (n == 0) {
            return false;
        }

        heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = read();
        }

        return true;
    }

    static void solve() {
        long max = 0;
        LinkedList<int[]> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int idx = i;
            while (!stack.isEmpty() && stack.getLast()[1] > heights[i]) {
                int[] remove = stack.removeLast();
                max = Math.max(max, (long)(i - remove[0]) * remove[1]);
                idx = remove[0];
            }

            stack.addLast(new int[]{idx, heights[i]}); 
        }

        while(!stack.isEmpty()) {
            int[] remove = stack.removeLast();
            max = Math.max(max, (long)(n - remove[0]) * remove[1]);
        }
        
        res.append(max).append("\n");
    }
}