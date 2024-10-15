import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static int[][][] matrix;
	static int N, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		N = read();
		int K = read();
		matrix = new int[N][N][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j][0] = read();
				matrix[i][j][1] = 1 << i | 1 << j;
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j][0] >= matrix[i][k][0] + matrix[k][j][0]) {
						matrix[i][j][0] = matrix[i][k][0] + matrix[k][j][0];
						matrix[i][j][1] = matrix[i][k][1] | matrix[k][j][1];
					}
				}
			}
		}

		DFS(K, 0, 1 << K);
		System.out.println(min);
	}

	static void DFS(int k, int value, int visited) {
		if (Integer.bitCount(visited) == N) {
			min = Math.min(min, value);
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((visited >> i) % 2 == 0) DFS(i, value + matrix[k][i][0], visited | matrix[k][i][1]);
		}
	}
}