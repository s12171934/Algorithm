import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	static int N, list[];

	public static void main(String[] args) throws IOException {
		int N = read();
		int T = read();
		long[][] carrots = new long[N][2];
		for (int i = 0; i < N; i++) {
			carrots[i][0] = read();
			carrots[i][1] = read();
		}
		Arrays.sort(carrots, (o1, o2) -> (int)(o2[1] - o1[1]));
		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += carrots[i][0] + (T - 1 - i) * carrots[i][1];
		}
		System.out.println(sum);
	}
	
	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if(r == 10 || r == 32) return res;
			if(r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}
