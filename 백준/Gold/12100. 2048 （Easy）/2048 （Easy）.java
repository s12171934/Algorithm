import javax.swing.plaf.PanelUI;
import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int[] dist;
    static int N;
    public static void main(String[] args) throws Exception {
        N = read();
        int[][] matrix = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] = read();
            }
        }
        dist = new int[]{1, 3, -1, -3};
        int ans = proc2048(matrix, 0);
        System.out.println(ans);
        bufferedReader.close();
    }

    public static int proc2048(int[][] matrix, int count) {
        if(count == 5) {
            return Arrays.stream(matrix).mapToInt(arr -> Arrays.stream(arr).max().getAsInt()).max().getAsInt();
        }

        int res = 2;
        for(int k = 0; k < 4; k++) {
            int[][] newMatrix = new int[N][N];
            int step = dist[k] % 2;
            if(Math.abs(dist[k]) == 1) {
                for (int i = 0; i < N; i++) {
                    int j = step < 0 ? N - 1 : 0;
                    int start = j;
                    while (j >= 0 && j < N) {
                        if(matrix[i][j] == 0) {
                            j += step;
                            continue;
                        }
                        if(newMatrix[i][start] == 0) {
                            newMatrix[i][start] = matrix[i][j];
                            j += step;
                            continue;
                        }

                        if(newMatrix[i][start] == matrix[i][j]) {
                            newMatrix[i][start] += matrix[i][j];
                            start += step;
                        }
                        else {
                            start += step;
                            newMatrix[i][start] = matrix[i][j];
                        }
                        j += step;
                    }
                }
            }
            else {
                for (int j = 0; j < N; j++) {
                    int i = step < 0 ? N - 1 : 0;
                    int start = i;
                    while (i >= 0 && i < N) {
                        if(matrix[i][j] == 0) {
                            i += step;
                            continue;
                        }
                        if(newMatrix[start][j] == 0) {
                            newMatrix[start][j] = matrix[i][j];
                            i += step;
                            continue;
                        }

                        if(newMatrix[start][j] == matrix[i][j]) {
                            newMatrix[start][j] += matrix[i][j];
                            start += step;
                        }
                        else {
                            start += step;
                            newMatrix[start][j] = matrix[i][j];
                        }
                        i += step;
                    }
                }
            }

            res = Math.max(res, proc2048(newMatrix, count + 1));
        }

        return res;
    }

    public static int read() throws Exception {
        int res = 0;
        while (true) {
            int r = bufferedReader.read();
            if(r == 10 || r == 32) return res;
            res = 10 * res + r - 48;
        }
    }
}