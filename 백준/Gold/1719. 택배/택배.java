import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] res;
	static int n, m;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] graph;
	
	public static void main(String[] args) throws IOException {
		n = read();
		m = read();
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int n1 = read();
			int n2 = read();
			int w = read();
			graph[n1].add(new Node(n1, n2, w, 0));
			graph[n2].add(new Node(n2, n1, w, 0));
		}
		
		res = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			writeRoute(i);
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(i == j ? "-" : res[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void writeRoute(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] list = new int[n + 1];
		Arrays.fill(list, INF);
		list[start] = 0;
		pq.add(new Node(start, 0, 0, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cur.w > list[cur.n1]) continue;
			res[start][cur.n1] = res[start][cur.from];
			if(cur.from == start) res[start][cur.n1] = cur.n1;
			for (Node next : graph[cur.n1]) {
				if(list[next.n2] < list[cur.n1] + next.w) continue;
				list[next.n2] = list[cur.n1] + next.w;
				pq.add(new Node(next.n2, 0, list[next.n2], cur.n1));
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		int n1, n2, w, from;

		Node(int n1, int n2, int w, int from) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
			this.from = from;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
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
