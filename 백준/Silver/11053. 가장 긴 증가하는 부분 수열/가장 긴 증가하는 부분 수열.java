import java.io.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String args[]) throws IOException {
		int pointer = 1;
		int N = read();
		int[] dp = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			int cur = read();
			if(dp[pointer - 1] < cur) {
				dp[pointer++] = cur;
				continue;
			}
			
			int temp = pointer - 1;
			while (true) {
				if(dp[temp -1] < cur) {
					dp[temp] = cur;
					break;
				}
				else {
					temp--;
				}
			}
		}
		
		System.out.println(pointer - 1);
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