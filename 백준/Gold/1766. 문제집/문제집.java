import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int n = read();
        int m = read();

        boolean[] child = new boolean[n + 1];
        boolean[] visited = new boolean[n + 1];

        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = read();
            int e = read();
            graph1.get(s).add(e);
            graph2.get(e).add(s);
            child[e] = true;
        }



        for (int i = 1; i <= n; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            if (child[i]) continue;
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(i).append(" ");
            for (int n1 : graph1.get(i)) {
                boolean ok = true;
                for (int n2 : graph2.get(n1)) {
                    if(!visited[n2]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) pq.add(n1);
            }
            while (!pq.isEmpty()) {
                int u = pq.poll();
                if (visited[u]) continue;
                visited[u] = true;
                sb.append(u).append(" ");
                for (int n1 : graph1.get(u)) {
                    boolean ok = true;
                    for (int n2 : graph2.get(n1)) {
                        if(!visited[n2]) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) pq.add(n1);
                }
            }
        }

        System.out.println(sb);
    }

    public static int read() throws Exception {
        int res = 0;
        while (true) {
            int r = br.read();
            if(r == 10 || r == 32) return res;
            res = 10 * res + r - 48;
        }
    }
}