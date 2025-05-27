import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int read() throws Exception {
        if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
    
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static int N;
    static int[][] route;
    static int d;
    
    static void init() throws Exception {
        N = read();

        route = new int[N][2];
        for (int i = 0; i < N ; i++) {
            int a = read();
            int b = read();
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            route[i][0] = a;
            route[i][1] = b;
        }

        d = read();
    }

    static void solve() {
        int res = 0;
        
        PriorityQueue<Integer> routeList = new PriorityQueue<>((n1, n2) -> route[n1][1] - route[n2][1]);
        PriorityQueue<Integer> includeList = new PriorityQueue<>((n1, n2) -> route[n1][0] - route[n2][0]);

        for (int i = 0; i < N; i++) {
            routeList.add(i);
        }

        while (!routeList.isEmpty()) {
            int idx = routeList.poll();
            int start = route[idx][1] - d;

            includeList.add(idx);
            while (!includeList.isEmpty() && route[includeList.peek()][0] < start) {
                includeList.poll();
            }
            res = Math.max(res, includeList.size());
        }

        System.out.println(res);
    }
}