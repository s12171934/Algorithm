import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Node>[] graph; 
	static int N, M, s, e, start, end;
	
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static class Node {
		int n, w;
		Node(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}
	
	static boolean BFS(int max) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		q.add(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Node next : graph[cur]) {
				if (visited[next.n] || next.w <= max) continue;
				visited[next.n] = true;
				if (next.n == end) return true;
				q.add(next.n);
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		N = read(); 
		M = read();
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
		for (int i = 1; i <= M; i++) {
			int n1 = read(), n2 = read(), w = read();
			e = Math.max(e, w);
			graph[n1].add(new Node(n2,w));
			graph[n2].add(new Node(n1,w));
		}
		start = read();
		end = read();
		while(s < e) {
			int m = (s + e) / 2;
			if(BFS(m)) {
				s = m + 1;
			} else {
				e = m;
			}
		}
		System.out.println(e);
	}
}