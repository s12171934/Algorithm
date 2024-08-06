import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		
		if (N < 3) {
			System.out.println(0);
			return;
		}
		
		int[] list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = read();
		}
		Arrays.sort(list);
		
		int[][][] dp = new int[N][2501][2501];
		for (int n = 0; n < N; n++) {
			for (int i = 0; i <= 2500; i++) {
				for (int j = 0; j <= 2500; j++) {
					dp[n][i][j] = -1;
				}
			}
		}
		dp[0][0][0] = list[0];
		dp[0][list[0]][0] = 0;
		dp[0][0][list[0]] = 0;
		
		for (int n = 1; n < N; n++) {
			for (int i = 0; i <= 2500; i++) {
				for (int j = 0; j <= 2500; j++) {
					if(dp[n - 1][i][j] == -1) continue;
					dp[n][i + list[n]][j] = dp[n - 1][i][j];
					dp[n][i][j + list[n]] = dp[n - 1][i][j];
					dp[n][i][j] = dp[n - 1][i][j] + list[n];
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i <= 2500; i++) {
			for (int j = i; j <= 2500; j++) {
				if(dp[N - 1][i][j] == -1 || dp[N - 1][i][j] > i) continue;
				max = Math.max(max, dp[N - 1][i][j]);
			}
		}
		
		System.out.println(max);
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
