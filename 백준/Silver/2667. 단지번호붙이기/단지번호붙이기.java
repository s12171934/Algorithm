import java.io.*;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, count;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        N = read();
        map = new char[N][N];
        for(int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        ArrayList<Integer> complex = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 48) continue;
                count = 0;
                DFS(i, j);
                complex.add(count);
            }
        }
        complex.sort(Integer::compareTo);
        sb.append(complex.size()).append("\n");
        for(int n : complex) sb.append(n).append("\n");

        System.out.println(sb);
        br.close();
    }

    public static void DFS(int i, int j) {
        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        map[i][j] = '0';
        count++;

        for(int k = 0; k < 4; k++) {
            if(i + y[k] < 0 || i + y[k] >= N || j + x[k] < 0 || j + x[k] >= N) continue;
            if(map[i + y[k]][j + x[k]] == 48) continue;
            DFS(i + y[k], j + x[k]);
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