import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static int[] hackLen;
	public static int N, M;
	public static int max = 0;
	
	public static void main(String[] args) throws IOException {
		N = read();
		M = read();
		
		hackLen = new int[N + 1];
		
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			int A = read();
			int B = read();
			graph.get(B).add(A);
		}
		
		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N + 1];
			visited[i] = true;
			
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			
			while(!q.isEmpty()) {
				int n = q.poll();
				
				for (int child : graph.get(n)) {
					if (visited[child]) continue;
					visited[child] = true;
					hackLen[i]++;
					q.add(child);
				}
			}
			
			max = Math.max(max, hackLen[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if(hackLen[i] == max) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}
