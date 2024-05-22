import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int start = read();
        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int n1 = read();
            int n2 = read();
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        for(int i = 1; i <= n; i++) graph[i].sort(Integer::compareTo);

        visited = new boolean[n + 1];
        DFS(start);
        sb.append("\n");
        visited = new boolean[n + 1];
        BFS(start);

        System.out.println(sb);
        br.close();
    }

    public static void DFS(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if(visited[node]) continue;
            visited[node] = true;
            sb.append(node).append(" ");
            for(int  i = graph[node].size() - 1; i >= 0; i--) {
                int n = graph[node].get(i);
                if(visited[n]) continue;
                stack.push(n);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if(visited[node]) continue;
            visited[node] = true;
            sb.append(node).append(" ");
            for(int n : graph[node]) {
                if(visited[n]) continue;
                queue.add(n);
            }
        }
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