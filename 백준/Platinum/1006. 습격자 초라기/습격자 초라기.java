import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int T = read();
		for (int t = 0; t < T; t++) {
			int N = read();
			int W = read();
			int[][] matrix = new int[N + 2][2];
			int[][][] temp = new int[4][2][2];
			boolean[] isContinue = new boolean[4];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					if (j < 2) {
						temp[0][j][i] = read();
						continue;
					}
					matrix[j][i] = read();
				}
			}
			
			if(N == 1) {
				sb.append(temp[0][0][0] + temp[0][0][1] <= W ? 1 : 2).append("\n");
				continue;
			}
			
			temp[1] = new int[][] {{temp[0][0][0], W},{temp[0][1][0], W}};
			temp[2] = new int[][] {{W, temp[0][0][1]},{W, temp[0][1][1]}};
			temp[3] = new int[][] {{W,W},{W,W}};
			
			isContinue[1] = temp[0][0][1] + temp[0][1][1] > W;
			isContinue[2] = temp[0][0][0] + temp[0][1][0] > W;
			isContinue[3] = isContinue[1] || isContinue[2];
			
			int min = 2 * N;
			for (int n = 0; n < 4; n++) {
				if(isContinue[n]) continue;
				matrix[1] = temp[n][1];
				matrix[N] = temp[n][0];
				int[][] dp = new int[N + 2][3];
				dp[1][1] = 1;
				dp[1][2] = 1;
				
				for (int i = 2; i <= N + 1; i++) { 
					boolean doubleBox = matrix[i - 1][0] + matrix[i - 2][0] <= W && matrix[i - 1][1] + matrix[i - 2][1] <= W;
					boolean doubleC = matrix[i - 1][0] + matrix[i - 1][1] <= W;
					boolean double0 = matrix[i - 1][0] + matrix[i][0] <= W;
					boolean double1 = matrix[i - 1][1] + matrix[i][1] <= W;
					
					dp[i][0] = Math.min(Math.min(doubleBox ? dp[i - 2][0] + 2 : 2 * N,dp[i - 1][0] + (doubleC ? 1 : 2)), Math.min(dp[i - 1][1] + 1, dp[i - 1][2] + 1));
					dp[i][1] = Math.min(Math.min(dp[i - 1][0] + (double1 ? 2 : 3), dp[i][0] + 1), Math.min(dp[i - 1][1] + 2, dp[i - 1][2] + (double1 ? 1 : 2)));
					dp[i][2] = Math.min(Math.min(dp[i - 1][0] + (double0 ? 2 : 3), dp[i][0] + 1), Math.min(dp[i - 1][1] + (double0 ? 1 : 2), dp[i - 1][2] + 2));
				}
				min = Math.min(min, dp[N + 1][0]  - ((n + 1) / 2));
			}
			sb.append(min).append("\n");
		}
		System.out.println(sb);
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
