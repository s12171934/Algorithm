import java.io.*;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int L = read();
		
		int[][][] matrix = new int[2][N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[0][i][j] = read();
				matrix[1][j][i] = matrix[0][i][j];
			}
		}
		
		int cnt = 0;
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < N; i++) {
				int before = matrix[k][i][0];
				int continuity = 1;
				int j = 1;
				for (j = 1; j < N; j++) {
					if (matrix[k][i][j] == before) {
						continuity++;
						continue;
					}
					if (matrix[k][i][j] == before + 1) {
						if (continuity >= L) {
							before = matrix[k][i][j];
							continuity = 1;
							continue;
						}
						break;
					}
					if (matrix[k][i][j] == before - 1) {
						continuity = 1;
						while (j + 1 < N && matrix[k][i][j + 1] == before - 1 && continuity < L) {
							j++;
							continuity++;
						}
						if (continuity == L) {
							before = matrix[k][i][j];
							continuity = 0;
							continue;
						}
						break;
					}
					break;
				}
				if (j == N) cnt++;
			}
		}
		
		System.out.println(cnt);
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
