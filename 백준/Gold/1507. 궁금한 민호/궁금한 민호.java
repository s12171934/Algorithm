import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder res = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = read();
		int sum = 0;
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = read();
			}
		}
		for (int i = 0; i < N; i++) {
			next: for (int j = i + 1; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (k == i || k == j) continue;
					if (matrix[i][j] == matrix[i][k] + matrix[k][j]) continue next;
					if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
						System.out.println(-1);
						return;
					}
				}
				sum += matrix[i][j];
			}
		}
		System.out.println(sum);
 	}

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}
