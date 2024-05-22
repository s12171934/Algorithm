import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        String[] str = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[][] dists = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] tomato = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int elem = Integer.parseInt(stringTokenizer.nextToken());
                tomato[i][j] = elem;
                if (elem == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    tomato[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] dist : dists) {
                int y = node[0] + dist[0];
                int x = node[1] + dist[1];

                if (y < 0 || x < 0 || y >= M || x >= N) continue;
                if (tomato[y][x] == -1) continue;
                if (visited[y][x]) continue;

                queue.add(new int[]{y, x});
                tomato[y][x] = tomato[node[0]][node[1]] + 1;
                visited[y][x] = true;
            }
        }

        int result = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] != -1 && !visited[i][j]) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, tomato[i][j]);
            }
        }

        System.out.println(result);
        bufferedReader.close();
    }
}