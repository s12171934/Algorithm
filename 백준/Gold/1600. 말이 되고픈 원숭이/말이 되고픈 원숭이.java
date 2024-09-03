import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] deltas = {{0,1,0},{0,-1,0},{1,0,0},{-1,0,0},{2,1,1},{2,-1,1},{-2,1,1},{-2,-1,1},{1,2,1},{1,-2,1},{-1,2,1},{-1,-2,1}};
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static class Monkey {
		int x, y, k, t;
		Monkey(int x, int y, int k, int t) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int K = read();
		int W = read();
		int H = read();
		int[][][] matrix = new int[K + 1][H][W];
		for (int i = 0; i < W * H; i++) {
			int read = read();
			for (int j = 0; j <= K; j++) {
				matrix[j][i / W][i % W] = read;
			}
		}
		
		Queue<Monkey> q = new ArrayDeque<>();
		q.add(new Monkey(0,0,0,0));
		matrix[0][0][0] = 1;
		while(!q.isEmpty()) {
			Monkey cur = q.poll();
			if(cur.x == H - 1 && cur.y == W - 1) {
				System.out.println(cur.t);
				return;
			}
			for (int[] d : deltas) {
				int x = cur.x + d[0];
				int y = cur.y + d[1];
				int k = cur.k + d[2];
				if (x < 0 || y < 0 || x >= H || y >= W || k > K || matrix[k][x][y] == 1) continue;
				matrix[k][x][y] = 1;
				q.add(new Monkey(x, y, k, cur.t + 1));
			}
			
		}
		System.out.println(-1);
	}
}