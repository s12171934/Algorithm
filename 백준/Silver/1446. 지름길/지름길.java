import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int D = read();
		int[] dp = new int[D + 1];
		Arrays.fill(dp, D);
		dp[0] = 0;
		Map<Integer, ArrayList<int[]>> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int s = read();
			int e = read();
			int d = read();
			if(!map.containsKey(e)) map.put(e, new ArrayList<>());
			map.get(e).add(new int[] {s, d});
		}
		for (int i = 1; i <= D; i++) {
			for (int[] element : map.getOrDefault(i, new ArrayList<>())) {
				dp[i] = Math.min(dp[i], dp[element[0]] + element[1]);
			}
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
		}
		System.out.println(dp[D]);
	}
	
	static int read() throws IOException {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}
