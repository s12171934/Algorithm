import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int read() throws Exception {
        int res = 0;
        while (true) {
            int n = br.read();
            if (n == 10 || n == 32) {
                return res;
            }
            res = 10 * res + n - 48;
        }

    }
    public static void main(String[] args) throws Exception {
        int result = -1;
        int[] distX = new int[]{0, 0, 1, -1};
        int[] distY = new int[]{-1, 1, 0, 0};
        int N = read();
        int M = read();
        char[][] matrix = new char[N][M];
        boolean[][][] visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0,1});

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            if(visited[node[0]][node[1]][node[2]]) continue;
            visited[node[0]][node[1]][node[2]] = true;
            if (node[0] == N - 1 && node[1] == M - 1) {
               result = node[3];
               break;
            }
            for (int i = 0; i < 4; i++) {
                int count = node[2];
                int y = distY[i] + node[0];
                int x = distX[i] + node[1];
                if(x < 0 || y < 0 || x >= M || y >= N) continue;
                if(visited[y][x][count]) continue;
                if(matrix[y][x] == '1') {
                    if(node[2] == 1) continue;
                    count++;
                }
                queue.add(new int[]{y, x, count, node[3] + 1});
            }
        }

        System.out.println(result);
        br.close();
    }
}