import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] candies;
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        int N = read();
        int M = read();
        int K = read();

        candies = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            candies[i][0] = 1;
            candies[i][1] = read();
        }
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            if(getParent(a) == getParent(b)) continue;
            union(a,b);
        }

        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{0,0});
        for (int i = 1; i <= N; i++) {
            if(candies[i][0] == 0) continue;
            list.add(candies[i]);
        }

        int[][] matrix = new int[list.size()][K];
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < K; j++) {
                int[] candy = list.get(i);
                if(candy[0] <= j) {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - candy[0]] + candy[1]);
                }
                else{
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }

        System.out.println(matrix[list.size() - 1][K - 1]);
    }

    public static int getParent(int n) {
        if (parents[n] == n) return n;
        else return getParent(parents[n]);
    }

    public static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        parents[b] = a;
        candies[a][0] += candies[b][0];
        candies[a][1] += candies[b][1];
        candies[b][0] = 0;
        candies[b][1] = 0;
    }

    public static int read() throws IOException {
        int res = 0;
        while (true) {
            int r = br.read();
            if (r == 10 || r == 32) return res;
            if (r == 13) continue;
            res = 10 * res + (r - 48);
        }
    }
}