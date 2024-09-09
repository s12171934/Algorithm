import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	static StringTokenizer st;
	
	static long read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Long.parseLong(st.nextToken());
	}
	
	static void solve(long N) {
		long s = 0, e = 100_000_000;
		while (s < e) {
			long m = (s + e) / 2;
			long range = (3 * m * m + m) / 2;
			if (range == N) {
				e = m - 1;
				break;
			}
			if (range > N) e = m;
			else s = m + 1;
		}
		res.append(3 * (N - 1) + (N > (3 * e * e - e) / 2 ? 2 : 1)).append("\n");
	}
	
	public static void main(String[] args) throws Exception {
		long TC = read();
		while (TC -- > 0) solve(read());
		System.out.println(res.toString());
	}
}