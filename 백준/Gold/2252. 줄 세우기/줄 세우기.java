import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        int N = read();
        int M = read();
        int[] startNode = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < M; i++){
            int start = read();
            int end = read();
            graph.get(start).add(end);
            startNode[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        while (Arrays.stream(startNode).sum() != -1 * N) {
            for (int i = 1; i <= N; i++) {
                if(startNode[i] == 0) {
                    queue.add(i);
                    startNode[i]--;
                    stringBuilder.append(i).append(" ");
                }
            }

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for(int n : graph.get(node)) {
                    if(startNode[n] != 0) startNode[n] --;
                }
            }
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    public static int read() throws Exception {
        int res = 0;
        int mode = 1;
        while (true) {
            int r = bufferedReader.read();
            if(r == 10 || r == 32) return res;
            if(r == 45) {
                mode = -1;
                continue;
            }
            res = 10 * res + mode * (r - 48);
        }
    }
}