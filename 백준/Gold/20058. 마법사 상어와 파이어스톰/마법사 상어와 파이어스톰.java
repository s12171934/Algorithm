import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = 1 << read();
		int Q = read();
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = read();
			}
		}
		for (int i = 0; i < Q; i++) {
			int L = 1 << read();
			matrix = fireStorm(L, matrix);
		}

		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new ArrayDeque<>();
		
		int sum = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += matrix[i][j];
				if(visited[i][j] || matrix[i][j] == 0) continue;
				visited[i][j] = true;
				int size = 1;
				q.add(new int[] {i, j});
				
				while (!q.isEmpty()) {
					int[] cur = q.poll();
					
					for (int[] d : deltas) {
						int x = cur[0] + d[0];
						int y = cur[1] + d[1];
						if(x < 0 || y < 0 || x >= N || y >= N || visited[x][y] || matrix[x][y] == 0) continue;
						visited[x][y] = true;
						size++;
						q.add(new int[] {x,y});
					}
				}
				
				max = Math.max(max, size); 
			}
		}
		
		System.out.println(new StringBuilder().append(sum).append("\n").append(max).toString());
	}
	
	static int[][] fireStorm(int L, int[][] matrix) {
		int[][] newMatrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int x = (i / L) * L + (L - 1 - (j % L));
				int y = (j / L) * L + (i % L);
				newMatrix[i][j] = matrix[x][y]; 
			}
		}
		
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(newMatrix[i][j] == 0) continue;
				int count = 0;
				for (int[] d : deltas) {
					int x = i + d[0];
					int y = j + d[1];
					if(x < 0 || y < 0 || x >= N || y >= N || newMatrix[x][y] == 0) {
						continue;
					}
					count++;
				}
				if(count < 3) list.add(new int[] {i, j});
			}
		}
		
		for (int[] cur : list) {
			newMatrix[cur[0]][cur[1]]--;
		}
		
		return newMatrix;
	}
	
	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32)
				return res;
			if (r == 13)
				continue;
			res = 10 * res + (r - 48);
		}
	}
}