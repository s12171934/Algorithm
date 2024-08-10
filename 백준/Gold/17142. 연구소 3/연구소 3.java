import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, V, min;
	static int[][] oriMatrix, virus;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	
	
	public static void main(String[] args) throws IOException {
		N = read();
		M = read();
		oriMatrix = new int[N][N];
		virus = new int[10][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int n = read();
				if (n == 2) {
					virus[V][0] = i;
					virus[V++][1] = j;
				}
				oriMatrix[i][j] = n;
			}
		}
		
		min = N * N + 1;
		DFS(0,0);
		System.out.println(min == N * N + 1 ? -1 : min);
	}
	
	static void DFS(int activeVirus, int idx) {
		if (check(activeVirus)) {
			BFS(activeVirus);
			return;
		}
		if (idx == V) return;
		DFS((activeVirus | (1 << idx)), idx + 1);
		DFS(activeVirus, idx + 1);
	}
	
	static boolean check(int activeVirus) {
		int count = 0;
		for(int i = 0; i < V; i++) {
			if((activeVirus & (1 << i)) != 0) count++;
		}
		return count == M;
	}
	
	static void BFS(int activeVirus) {
		int[][] matrix = new int[N][N];
		Queue<Node> q = new ArrayDeque<>();
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = oriMatrix[i][j];
				if(matrix[i][j] == 0) cnt++;
			}
		}
		
		if(cnt == 0) {
			min = 0;
			return;
		}
		
		for (int i = 0; i < V; i++) {
			if((activeVirus & (1 << i)) != 0) {
				q.add(new Node(virus[i][0], virus[i][1], 0));
				matrix[virus[i][0]][virus[i][1]] = 1;		
			}
		}
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.t + 1 > min) return;
			
			for (int[] d : deltas) {
				int x = cur.x + d[0];
				int y = cur.y + d[1];
				if(x < 0 || y < 0 || x >= N || y >= N) continue;
				if(matrix[x][y] == 1) continue;
				if(matrix[x][y] == 0 && --cnt == 0) {
					min = cur.t + 1;
					return;
				}
				matrix[x][y] = 1;
				q.add(new Node(x, y, cur.t + 1));
			}
		}
	}
	
	static class Node {
		int x, y, t;
		Node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}
