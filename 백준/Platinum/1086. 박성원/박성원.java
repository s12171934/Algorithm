import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] mod = new int[751];
	
	public static void main(String[] args) throws IOException {
		int N = read();
		String[] list = new String[N];
		for (int i = 0; i < N; i++) {
			list[i] = br.readLine();
		}
		int K = read();
		mod[0] = 1;
		for (int i = 1; i <= 750; i++) {
			mod[i] = (mod[i - 1] * 10) % K;
		}
		int[][] matrix = new int[N][2];
		for (int i = 0; i < N; i++) {
			matrix[i][1] = list[i].length();
			int times = (matrix[i][1] - 1) / 8;
			if(times == 0) {
				matrix[i][0] = Integer.parseInt(list[i]) % K;
			}
			else {
				int start = 0;
				int end = matrix[i][1] % 8;
				if (end == 0) end = 8;
				for (int j = 0; j <= times; j++) {
					matrix[i][0] += (Integer.parseInt(list[i].substring(start,end)) % K) * mod[8 * (times - j)];
					matrix[i][0] %= K;
					start = end;
					end += 8;
				}
			}
		}
		
		long[][] dp = new long [1 << N][K];
		dp[0][0] = 1l;
		for (int i = 1; i < 1 << N; i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) == 0) continue;
				int len = 0;
				for (int n = 0; n < N; n++) {
					if(((i - (1 << j)) & (1 << n)) == 0) continue;
					len += matrix[n][1];
				}
				for (int k = 0 ; k < K; k++) {
					dp[i][(k + matrix[j][0] * mod[len]) % K] += dp[i - (1 << j)][k];
				}
			}
		}
		
		long numerator = dp[(1 << N) - 1][0];
		long denominator = 1;
		for (long i = 1; i <= N; i++) {
			denominator *= i;
		}
		
		if(numerator == 0) {
			System.out.println("0/1");
			return;
		}
		if(numerator == denominator) {
			System.out.println("1/1");
			return;
		}
		
		long gcd = gcd(numerator, denominator);
		System.out.printf("%d/%d",numerator/gcd,denominator/gcd);
	}
	
	static long gcd(long a, long b) {
		if(b % a == 0) {
			return a;
		}
		b -= a;
		if(b > a) {
			return gcd(a,b);
		}
		else {
			return gcd(b,a);
		}
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