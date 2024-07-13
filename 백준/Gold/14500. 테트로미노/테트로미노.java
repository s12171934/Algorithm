import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();

        int[][][] matrix = {new int[n][m], new int[m][n], new int[n][m], new int[m][n]};
        int[][][] blocks = {{{0,0},{0,1},{0,2},{0,3}}, {{0,0},{0,1},{1,0},{1,1}}, {{0,0},{1,0},{2,0},{2,1}}, {{0,0},{0,1},{0,2},{1,2}} ,{{0,0},{1,0},{1,1},{2,0}}, {{0,0},{1,0},{1,1},{2,1}}, {{0,0},{0,1},{1,1},{1,2}}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = read();
                matrix[0][i][j] = num;
                matrix[1][j][n - i - 1] = num;
                matrix[2][n - i - 1][m - j - 1] = num;
                matrix[3][m - j - 1][i] = num;
            }
        }

        int max = 0;

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < matrix[k].length; i++) {
                for (int j = 0; j < matrix[k][i].length; j++) {
                    for (int[][] block : blocks) {
                        int sum = 0;
                        int count = 0;
                        for (int[] b : block) {
                            int x = i + b[0];
                            int y = j + b[1];
                            if(x >= 0 && x < matrix[k].length && y >= 0 && y < matrix[k][i].length) {
                                sum += matrix[k][x][y];
                                count++;
                            }
                            else {
                                break;
                            }
                        }
                        if (count == 4) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
        }

        System.out.println(max);
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