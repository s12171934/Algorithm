import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static boolean[] visited;
	public static int[] dp;
	public static int N, R, Q;
	
	public static void main(String[] args) throws IOException {
		N = read();
		R = read();
		Q = read();
		
		visited = new boolean[N + 1];
		dp = new int[N + 1];
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		for	(int i = 0; i < N - 1; i++) {
			int U = read();
			int V = read();
			graph.get(U).add(V);
			graph.get(V).add(U);
		}
		
		DFS(R);
		
		for (int i = 0; i < Q; i++) {
			System.out.println(dp[read()]);
		}
	}
	
	public static void DFS(int n) {
		visited[n] = true;
		for (int next : graph.get(n)) {
			if (visited[next]) continue;
			DFS(next);
			dp[n] += dp[next];
		}
		dp[n] += 1;
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}