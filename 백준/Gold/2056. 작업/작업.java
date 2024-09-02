import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		int N = read();
		int res = 0;
		int[] work = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int max = 0;
			int now = read();
			int pre = read();
			for (int j = 0; j < pre; j++) max = Math.max(max, work[read()]);
			work[i] = now + max;
			res = Math.max(res, work[i]);
		}
		System.out.println(res);
	}
}