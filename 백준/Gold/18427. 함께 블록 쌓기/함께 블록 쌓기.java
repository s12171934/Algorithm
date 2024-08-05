import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int M = read();
		int H = read();
		int[][] matrix = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][H + 1];
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(matrix[i], -1);
			matrix[i][0] = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 1;
			while (st.hasMoreTokens()) {
				matrix[i][j++] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		dp[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (matrix[i][j] == -1) break;
				for (int k = matrix[i][j]; k <= H; k++) {
					dp[i][k] += dp[i - 1][k - matrix[i][j]];
					dp[i][k] %= 10007;
				}
			}
		}
		
		System.out.println(dp[N][H]);
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
