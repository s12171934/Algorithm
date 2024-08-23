import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int M = read();
		int K = read();
		int X = read();
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			graph[read()].add(read());
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {X, 0});
		visited[X] = true;
		while(!q.isEmpty() && q.peek()[1] != K) {
			int[] cur = q.poll();
			for (int next : graph[cur[0]]) {
				if(visited[next]) continue;
				visited[next] = true;
				q.add(new int[] {next, cur[1] + 1});
			}
		}
		
		if (q.isEmpty()) System.out.println(-1);
		else {
			int[] res = new int[q.size()];
			for (int i= 0; i < res.length; i++) {
				res[i] = q.poll()[0];
			}
			Arrays.sort(res);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < res.length; i++) {
				sb.append(res[i]).append("\n");
			}
			System.out.println(sb.toString());
		}
	}
	
	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}
