import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[][] grid;
    static boolean[] node;
    static int n;
    static int count = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        grid = new int[n + 1][n + 1];
        node = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            grid[x][y] = 1;
            grid[y][x] = 1;
        }

        DFS(1);

        System.out.println(count);
        bufferedReader.close();
    }

    static void DFS(int value) {
        node[value] = true;
        count++;
        for (int i = 1; i <= n; i++) {
            if (grid[value][i] == 1 && !node[i]) {
                DFS(i);
            }
        }
    }
}