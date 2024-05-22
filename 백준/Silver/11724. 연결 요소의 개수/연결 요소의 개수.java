import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[][] grid;
    static boolean[] node;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        String[] str = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int count = 0;

        grid = new int[n + 1][n + 1];
        node = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            grid[x][y] = 1;
            grid[y][x] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (!node[i]) {
                DFS(i);
               count++;
            }
        }

        System.out.println(count);
        bufferedReader.close();
    }

    static void DFS(int value) {
        node[value] = true;
        for (int i = 1; i <= n; i++) {
            if (grid[value][i] == 1 && !node[i]) {
                DFS(i);
            }
        }
    }
}