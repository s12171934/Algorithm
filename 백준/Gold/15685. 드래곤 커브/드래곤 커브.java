import java.io.*;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] matrix = new boolean[101][101];
	static int[][] deltas = {{1,0},{0,-1},{-1,0},{0,1}};
	
	public static void main(String[] args) throws IOException {
		int N = read();
		for (int i = 0; i < N; i++) {
			dragonCerve(read(),read(),read(),read());
		}
		
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (matrix[i][j] && matrix[i + 1][j] && matrix[i][j + 1] && matrix[i + 1][j + 1]) cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static void dragonCerve(int x, int y, int d, int g) {
		int[][] cerve = new int[(1 << g) + 1][2];
		cerve[0][0] = x;
		cerve[0][1] = y;
		cerve[1][0] = x + deltas[d][0];
		cerve[1][1] = y + deltas[d][1];
		
		for (int i = 1; i <= g; i++) {
			int idx = 1 << (i - 1);
			int nx = cerve[idx][0];
			int ny = cerve[idx][1];
			for (int j = idx - 1; j >= 0; j--) {
				cerve[2 * idx - j][0] = nx + ny - cerve[j][1];
				cerve[2 * idx - j][1] = ny - nx + cerve[j][0];
			}
		}
		
		for (int[] node : cerve) {
			matrix[node[0]][node[1]] = true;
		}
	}

	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}
