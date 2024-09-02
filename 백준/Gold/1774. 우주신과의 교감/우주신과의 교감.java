import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] parents;
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static int getParent(int n) {
		if (parents[n] != n) parents[n] = getParent(parents[n]);
		return parents[n];
	}
	
	static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a < b) parents[b] = a;
		else parents[a] = b;
	}
	
	static class Node implements Comparable<Node> {
		int n1, n2;
		double w;
		
		public Node(int n1, int n2, double w) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w < o.w ? -1 : 1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		int[][] input = new int[N][2];
		for (int i = 0; i < 2 * N; i++) input[i / 2][i % 2] = read();
		Queue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				pq.add(new Node(i + 1,j + 1,Math.sqrt(Math.pow(input[i][0] - input[j][0], 2) + Math.pow(input[i][1] - input[j][1], 2))));			
			}
		}
		int cnt = N - 1;
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) parents[i] = i;
		for (int i = 0; i < M; i++) {
			int n1 = read();
			int n2 = read();
			if (getParent(n1) == getParent(n2)) continue;
			union(n1, n2);
			cnt--;
		}
		
		double sum = 0.0;
		while (cnt > 0) {
			Node cur = pq.poll();
			if (getParent(cur.n1) == getParent(cur.n2)) continue;
			union(cur.n1, cur.n2);
			sum += cur.w;
			cnt--;
		}
		
		System.out.printf("%.2f", sum);
	}
}