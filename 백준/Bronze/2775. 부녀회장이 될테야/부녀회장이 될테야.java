import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int[][] grid = new int[15][15];
        for(int i = 1; i < 15; i++) {
            grid[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        int TC = read();
        for (int i = 0; i < TC; i++) {
            System.out.println(grid[read()][read()]);
        }
        br.close();
    }

    static int read() throws IOException {
        int res = 0;
        while (true) {
            int n = br.read();
            if(n == 10 || n == 32) return res;
            res = 10 * res + n - 48;
        }
    }
}
