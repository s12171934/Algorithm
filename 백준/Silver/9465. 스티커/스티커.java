import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int TC = read();
		
		for (int tc = 0; tc < TC; tc++) {
			int n = read();
			int[][] list = new int[2][n + 1];
			int[][] dp = new int[3][n + 1];
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= n; j++) {
					list[i][j] = read();
				}
			}
			dp[0][1] = list[0][1];
			dp[1][1] = list[1][1];
			dp[2][1] = Math.max(dp[0][1], dp[1][1]);
			
			for (int i = 2; i <= n; i++) {
				dp[0][i] =  Math.max(dp[2][i - 2], dp[1][i - 1]) + list[0][i];
				dp[1][i] =  Math.max(dp[2][i - 2], dp[0][i - 1]) + list[1][i];
				dp[2][i] = Math.max(dp[0][i], dp[1][i]);
			}
			
			sb.append(dp[2][n]).append("\n");
		}
		
		System.out.println(sb.toString());
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
