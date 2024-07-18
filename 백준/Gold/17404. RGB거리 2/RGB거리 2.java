import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int[][] matrix = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = read();
			}
		}
		
		int[][][] res = new int[N][3][3];
		res[1] = new int[][]{
			{1_000_000_000, matrix[0][0] + matrix[1][1], matrix[0][0] + matrix[1][2]},
			{matrix[0][1] + matrix[1][0], 1_000_000_000, matrix[0][1] + matrix[1][2]},
			{matrix[0][2] + matrix[1][0], matrix[0][2] + matrix[1][1], 1_000_000_000}
		};
		for (int k = 2; k < N; k++) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					res[k][i][j] = Math.min(res[k - 1][i][(j + 1) % 3], res[k - 1][i][(j + 2) % 3]) + matrix[k][j];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == j) continue;
				min = Math.min(min, res[N - 1][i][j]);
			}
		}
		
		System.out.println(min);
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
