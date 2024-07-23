import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static char[][] matrix;
    public static int[][] visited;
    public static int group = 1;

    public static void main(String[] args) throws IOException {
        int N = read();
        int M = read();

        visited = new int[N][M];
        matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] != 0) continue;
                if (DFS(i,j)) count++;
                group++;
            }
        }

        System.out.println(count);
    }

    public static boolean DFS(int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] == group) return true;
        if (visited[i][j] != 0 && visited[i][j] != group) return false;
        visited[i][j] = group;
        switch (matrix[i][j]) {
            case 'D':
                return DFS(i + 1, j);
            case 'U':
                return DFS(i - 1, j);
            case 'L':
                return DFS(i, j - 1);
            case 'R':
                return DFS(i, j + 1);
        }
        return false;
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