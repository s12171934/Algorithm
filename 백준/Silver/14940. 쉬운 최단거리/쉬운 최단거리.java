import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int startX = 0;
        int startY = 0;
        int[][] dists = new int[][]{{0 , 1}, {0 , -1}, {1, 0}, {-1, 0}};
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                int elem = Integer.parseInt(stringTokenizer.nextToken());
                if (elem == 2) {
                    startY = i;
                    startX = j;
                }
                map[i][j] = elem;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        map[startY][startX] = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] dist : dists) {
                int y = node[0] + dist[0];
                int x = node[1] + dist[1];
                if (y < 0 || y >= n || x < 0 || x >= m) continue;
                if (visited[y][x] || map[y][x] == 0) continue;
                queue.add(new int[]{y, x});
                visited[y][x] = true;
                map[y][x] = map[node[0]][node[1]] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    stringBuilder.append(-1).append(" ");
                }
                else {
                    stringBuilder.append(map[i][j]).append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}