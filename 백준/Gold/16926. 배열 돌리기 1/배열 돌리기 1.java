import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = read();
		int M = read();
		int R = read();
		int[][] list = new int[Math.min(N, M) / 2][];
		int[][] matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = read();
			}
		}
		for (int n = 0; n < Math.min(N, M) / 2; n++) {
			list[n] = new int[2 * (N + M) - 4 - 8 * n];
			int pointer = 0;
			for (int i = n; i < M - n; i++) {
				list[n][pointer++] = matrix[n][i];
			}
			for (int i = n + 1; i < N - n; i++) {
				list[n][pointer++] = matrix[i][M - 1 - n];
			}
			for (int i = M - n - 2; i >= n; i--) {
				list[n][pointer++] = matrix[N - 1 - n][i];
			}
			for (int i = N - n - 2; i >= n + 1; i--) {
				list[n][pointer++] = matrix[i][n];
			}
		}
		
		for (int n = 0; n < Math.min(N, M) / 2; n++) {
			int pointer = R % list[n].length;
			for (int i = n; i < M - n; i++) {
				matrix[n][i] = list[n][pointer++];
				pointer %= list[n].length;
			}
			for (int i = n + 1; i < N - n; i++) {
				matrix[i][M - 1 - n] = list[n][pointer++];
				pointer %= list[n].length;
			}
			for (int i = M - n - 2; i >= n; i--) {
				matrix[N - 1 - n][i] = list[n][pointer++];
				pointer %= list[n].length;
			}
			for (int i = N - n - 2; i >= n + 1; i--) {
				matrix[i][n] = list[n][pointer++];
				pointer %= list[n].length;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				res.append(matrix[i][j]).append(" ");
			}
			res.append("\n");
		}
		System.out.println(res.toString());
	}
	
	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if(r == 10 || r == 32) return res;
			if(r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}
