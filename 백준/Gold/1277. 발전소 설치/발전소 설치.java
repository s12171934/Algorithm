import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder res = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception {
		int N = readInt();
		int W = readInt();
		double M = readDouble();
		long[][] matrix = new long[N + 1][2];
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = readInt();
			matrix[i][1] = readInt();
		}
		double[][] dist = new double[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				double len = Math.sqrt(Math.pow(matrix[i][0] - matrix[j][0], 2) + Math.pow(matrix[i][1] - matrix[j][1], 2));
				dist[i][j] = dist[j][i] = len > M ? -1 : len;
			}
		}
		for (int i = 0; i < W; i++) {
			int n1 = readInt();
			int n2 = readInt();
			dist[n1][n2] = dist[n2][n1] = 0;
		}
		
		double[] minLen = new double[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(minLen, Double.MAX_VALUE);
		minLen[1] = 0;
		visited[1] = true;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			visited[cur.n] = true;
			if (cur.w > minLen[cur.n]) continue;
			for (int i = 1; i <= N; i++) {
				if (dist[cur.n][i] == -1) continue;
				if (minLen[i] < cur.w + dist[cur.n][i]) continue;
				if (visited[i] & dist[cur.n][i] == 0) continue;
				minLen[i] = cur.w + dist[cur.n][i];
				pq.add(new Node(i, minLen[i]));
			}
		}
		
		System.out.println((int)(minLen[N] * 1000));
 	}
	
	static class Node implements Comparable<Node> {
		int n;
		double w;
		
		Node(int n, double w) {
			this.n = n;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w == o.w ? 0 : this.w > o.w ? 1 : -1;
		}
		
	}
	
	static int readInt() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static double readDouble() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Double.parseDouble(st.nextToken());
	}
}
