//10:10
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            int n1 = read();
            int n2 = read();

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        for (int i = 0; i <= N; i++) graph.get(i).sort(Integer::compareTo);

        int s = read();
        int e = read();

        Queue<ArrayList<Integer>> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(new ArrayList<>(List.of(s)));
        visited[s] = true;
        int count = 0;

        while (!q.isEmpty()) {
            ArrayList<Integer> route = q.poll();
            if (route.get(route.size() - 1) == e) {
                count += route.size() - 1;
                visited = new boolean[N + 1];
                for (int r : route) {
                    if (r == s) continue;
                    visited[r] = true;
                }
                break;
            }

            for (int next : graph.get(route.get(route.size() - 1))) {
                if (visited[next]) continue;
                visited[next] = true;
                ArrayList<Integer> nextArr = new ArrayList<>(route);
                nextArr.add(next);
                q.add(nextArr);
            }
        }

        Queue<int[]> q2 = new LinkedList<>();
        q2.add(new int[]{e,count});

        while (!q2.isEmpty()) {
            int[] node = q2.poll();

            if (node[0] == s) {
                System.out.println(node[1]);
                return;
            }

            for (int next : graph.get(node[0])) {
                if (visited[next]) continue;
                visited[next] = true;
                q2.add(new int[]{next, node[1] + 1});
            }
        }


    }

    // Int 입력을 위한 메서드
    public static int read() throws Exception {
        int res = 0;
        while (true) {
            int r = br.read();
            if (r == 10 || r == 32) return res;
            res = 10 * res + r - 48;
        }
    }
}