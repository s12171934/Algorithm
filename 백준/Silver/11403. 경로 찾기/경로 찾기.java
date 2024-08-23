import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int result[][], N;
	static ArrayList<Integer>[] graph;
	
	
	public static void main(String[] args) throws IOException {
		N = read();
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
		result = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++){
				if(read() == 1) graph[i].add(j);
			}
 		}
		for (int i = 0; i < N; i++) {
			Queue<Integer> q = new ArrayDeque<>();
			q.add(i);
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int next : graph[cur]) {
					if(next == i) {
						result[i][i] = 1;
						continue;
					}
					if(result[i][next] == 1) continue;
					result[i][next] = 1;
					q.add(next);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
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
