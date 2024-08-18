import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int MOD = 1_000_003;
	static int N;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken()) - 1;
		int E = Integer.parseInt(st.nextToken()) - 1;
		int T = Integer.parseInt(st.nextToken());
		
		long[][][] matrix = new long[(int)(Math.log(T) / Math.log(2)) + 1][N * 5][N * 5];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				matrix[0][i * 5 + j][i * 5 + j + 1] = 1;
			}
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				int time = str.charAt(j) - 49;
				if(time < 0) continue;
				matrix[0][i * 5 + time][j * 5] = 1;
			}
		}
		
		for (int n = 1; n < matrix.length; n++) {
			matrix[n] = piMatrix(matrix[n - 1], matrix[n - 1]);
		}
		
		long[][] result = new long[N * 5][N * 5];
		for (int i = 0; i < 5 * N; i++) {
			result[i][i] = 1;
		}
		for (int n = 0; n < matrix.length; n++) {
			if((T & (1 << n)) == 0) continue;
			result = piMatrix(result, matrix[n]);
		}
 		System.out.println(result[S * 5][E * 5]);
	}
	
	static long[][] piMatrix (long[][] m1, long[][] m2) {
		long[][] res = new long[N * 5][N * 5];
		for (int i = 0; i < N * 5; i++) {
			for (int j = 0; j < N * 5; j++) {
				for (int k = 0; k < N * 5; k++) {
					res[i][j] += (m1[i][k] * m2[k][j]) % MOD;
				}
				res[i][j] %= MOD;
			}
		}
		return res;
	}
}
