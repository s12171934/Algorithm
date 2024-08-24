import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long MOD = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		int N = read();
		if (N == 1) {
			System.out.println(0);
			return;
		}
		long[] list = new long[N];
		for (int i = 0; i < N; i++) list[i] = read();
		Arrays.sort(list);
		long[] twice = new long[N - 1];
		twice[0] = 1;
		for (int i = 1; i < N - 1; i++) {
			twice[i] = 2 * twice[i -1];
			twice[i] %= MOD;
		}
		long sum = 0;
		long diff = 0;
		for (int i = 0; i < N / 2; i++) {
			diff += list[N - 1 - i] - list[i];
			diff %= MOD;
			sum += diff * (2 * (i + 1) == N ? twice[N / 2 - 1] : twice[N - 2 - i] + twice[i]);
			sum %= MOD;
		}
		System.out.println(sum);
 	}
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}
