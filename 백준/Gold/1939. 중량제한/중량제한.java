import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static class Node implements Comparable<Node> {
		int n1, n2, w;
		Node(int n1, int n2, int w) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return o.w - this.w;
		}
	}
	
	static int getParent(int n) {
		if (parent[n] != n) parent[n] = getParent(parent[n]);
		return parent[n];
	}
	
	static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a == b) return;
		if (a > b) parent[a] = b;
		else parent[b] = a;
	}
	
	public static void main(String[] args) throws Exception {
		int N = read(), M = read();
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) parent[i] = i;
		
		Queue<Node> q = new PriorityQueue<>();
		for (int i = 1; i <= M; i++) q.add(new Node(read(), read(), read()));
		
		int start = read(), end = read();
		while(!q.isEmpty()) {
			Node cur = q.poll();
			union(cur.n1, cur.n2);
			if (getParent(start) == getParent(end)) { System.out.println(cur.w); break; }
		}	
	}
}