import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		int ans = 0;
		int n = readInt();
		int m = readInt();
		int[][] dists = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		char[][] matrix = new char[n][m];
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			matrix[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 'I') {
					queue.add(new int[]{i, j});
					visited[i][j] = true;
					break;
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			for (int[] dist : dists) {
				int x = node[0] + dist[0];
				int y = node[1] + dist[1];
				
				if(x < 0 || x >= n || y < 0 || y >= m) continue;
				if(visited[x][y]) continue;
				if(matrix[x][y] == 'X') continue;
				if(matrix[x][y] == 'P') ans++;
				visited[x][y] = true;
				queue.add(new int[]{x,y});
			}
		}
		
		System.out.println(ans == 0 ? "TT" : ans);
		br.close();
	}
	
	public static int readInt() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 32 || r == 10) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}