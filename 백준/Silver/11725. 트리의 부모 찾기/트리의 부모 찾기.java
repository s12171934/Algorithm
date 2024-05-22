import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int N = read();
        int [] parent = new int[N + 1];

        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            nodes.add(arr);
        }

        for (int i = 0; i < N - 1; i++) {
            int a = read();
            int b = read();
            nodes.get(a - 1).add(b);
            nodes.get(b - 1).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i : nodes.get(node - 1)) {
                if(i == parent[node]) continue;
                queue.add(i);
                parent[i] = node;
            }
        }

        for (int i = 2; i <= N; i++) {
            stringBuilder.append(parent[i]).append("\n");
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    static int read() throws Exception {
        int res = 0;
        while (true) {
            int pointer = bufferedReader.read();
            if (pointer == 32 || pointer == 10) {
                return res;
            }
            res = 10 * res + pointer - 48;
        }
    }
}