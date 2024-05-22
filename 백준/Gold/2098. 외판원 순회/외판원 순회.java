import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int[][] dist;
    static int N;
    public static void main(String[] args) throws Exception {
        N = read();
        arr = new int[N][N];
        dist = new int[1<<N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = read();
            }
        }

        int ans = tsp(1, 0);
        System.out.println(ans);
        bufferedReader.close();
    }

    public static int tsp(int visited, int now) {
        if (dist[visited][now] != 0) {}
        else if (visited == (1<<N) - 1) {
            dist[visited][now] = arr[now][0] != 0 ? arr[now][0] : 1_000_000_000;
        }
        else {
            int res = 1_000_000_000;
            for (int i = 1; i < N; i++) {
                int k = visited | 1<<i;
                if(k == visited) continue;
                if(arr[now][i] == 0) continue;
                res = Math.min(res,arr[now][i] + tsp(k, i));
            }
            dist[visited][now] = res;
        }
        return dist[visited][now];
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