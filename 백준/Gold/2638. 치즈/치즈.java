import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int n = read();
		int m = read();
		int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = read();
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[2]);
		matrix[0][0] = -1;
		while (!q.isEmpty()) {
			int[] outer = q.poll();
			
			for (int[] d : deltas) {
				int x = outer[0] + d[0];
				int y = outer[1] + d[1];
				if (x < 0 || x >= n || y < 0 || y >= m) continue;
				if (matrix[x][y] == 0) {
					matrix[x][y] = -1;
					q.add(new int[] {x,y});
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] != -1) {
					for (int[] d : deltas) {
						int x = i + d[0];
						int y = j + d[1];
						if (x < 0 || x >= n || y < 0 || y >= m) continue;
						if (matrix[x][y] == -1) matrix[i][j] += 1;
					}
					if (matrix[i][j] > 2) q.add(new int[] {i,j,1});
				}
			}
		}
		
		int time = 0;
		while (!q.isEmpty()) {
			int[] cheese = q.poll();
			time = cheese[2];
			matrix[cheese[0]][cheese[1]] = -1;
			
			for (int[] d : deltas) {
				int x = cheese[0] + d[0];
				int y = cheese[1] + d[1];
				if (x < 0 || x >= n || y < 0 || y >= m) continue;
				if (matrix[x][y] == -1) continue;
				if (matrix[x][y] == 0) {
					Queue<int[]> q2 = new LinkedList<>();
					q2.add(new int[] {x,y});
					matrix[x][y] = -1;
					
					while (!q2.isEmpty()) {
						int[] inner = q2.poll();
						
						for (int[] d2 : deltas) {
							int nx = inner[0] + d2[0];
							int ny = inner[1] + d2[1];
							if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
							if (matrix[nx][ny] == -1) continue;
							if (matrix[nx][ny] == 0) {
								q2.add(new int[] {nx,ny});
								matrix[nx][ny] = -1;
							}
							else {
								matrix[nx][ny] += 1;
								if (matrix[nx][ny] == 3) {
									q.add(new int[] {nx,ny,cheese[2] + 1});
								}
							}
						}
					}
				}
				else {
					matrix[x][y] += 1;
					if (matrix[x][y] == 3) {
						q.add(new int[] {x,y,cheese[2] + 1});
						
					}
				}
				
			}
		}
		
		System.out.println(time);
	}

	
	public static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}
