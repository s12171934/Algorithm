import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int K = read();
		int[] list = new int[N + 1];
		for (int i = 1; i <= N; i++) list[i] = list[i - 1] + read();
		int[] dp = new int[N + 1];
		
		int pointer = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i - 1];
			while (list[i - 1] - list[pointer] >= K) pointer++;
			int foods = list[i] - list[pointer] - K;
			if(foods >= 0) dp[i] = Math.max(dp[i], dp[pointer] + foods);
		}
		
		System.out.println(dp[N]);
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
