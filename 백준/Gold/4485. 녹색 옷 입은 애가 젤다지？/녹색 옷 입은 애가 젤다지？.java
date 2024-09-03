import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, tc;
	static int INF = 1_000_000_000;
	static int deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static class Node implements Comparable<Node> {
		int x, y, w;
		
		Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		while ((N = read()) != 0) {
			int[][] matrix = new int[N][N];
			int[][] dist = new int[N][N];
			for (int i = 0; i < N * N; i++) matrix[i / N][i % N] = read();
			for (int i = 0; i < N * N; i++) dist[i / N][i % N] = INF;
			Queue<Node> q = new PriorityQueue<>();
			dist[0][0] = matrix[0][0];
			q.add(new Node(0,0,dist[0][0]));
			while (!q.isEmpty()) {
				Node cur = q.poll();
				if (cur.x == N - 1 && cur.y == N - 1) break;
				if (dist[cur.x][cur.y] < cur.w) continue;
				for (int[] d : deltas) {
					int x = cur.x + d[0];
					int y = cur.y + d[1];
					if (x < 0 || y < 0 || x >= N || y >= N) continue;
					if (dist[x][y] <= dist[cur.x][cur.y] + matrix[x][y]) continue;
					dist[x][y] = dist[cur.x][cur.y] + matrix[x][y];
					q.add(new Node(x,y,dist[x][y]));
				}
			}
			sb.append(String.format("Problem %d: %d\n", ++tc, dist[N - 1][N -1]));
		}
		System.out.println(sb.toString());
	}
}