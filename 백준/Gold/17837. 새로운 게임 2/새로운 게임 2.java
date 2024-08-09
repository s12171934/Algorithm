import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int[][] deltas = {{},{0,1},{0,-1},{-1,0},{1,0}};
		int N = read();
		int K = read();
		int[][][] matrix = new int[N + 2][N + 2][2];
		Piece[] pieces = new Piece[K + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				matrix[i][j][0] = read();
			}
		}
		for (int i = 0; i < N + 2; i++) {
			matrix[i][0][0] = 2;
			matrix[0][i][0] = 2;
			matrix[i][N + 1][0] = 2;
			matrix[N + 1][i][0] = 2;
		}
		
		
		for (int i = 1; i <= K; i++) {
			int x = read();
			int y = read();
			int dist = read();
			pieces[i] = new Piece(i, x, y, dist);
			matrix[x][y][1] = i;
		}
		
		for (int t = 1; t <= 1000; t++) {
			for (int i = 1; i <= K; i++) {
				Piece cur = pieces[i];
				int nx = cur.x + deltas[cur.dist][0];
				int ny = cur.y + deltas[cur.dist][1];
				
				if (matrix[nx][ny][0] == 2) {
					switch(cur.dist) {
					case 1:
						cur.dist = 2;
						break;
					case 2:
						cur.dist = 1;
						break;
					case 3:
						cur.dist = 4;
						break;
					case 4:
						cur.dist = 3;
						break;
					}
					
					nx = cur.x + deltas[cur.dist][0];
					ny = cur.y + deltas[cur.dist][1];
				}
				
				if (matrix[nx][ny][0] == 2) {
					continue;
				}
				
				Deque<Integer> dq = new ArrayDeque<>();
				int temp = i;
				int oriX = cur.x;
				int oriY = cur.y;
				do {
					pieces[temp].x = nx;
					pieces[temp].y = ny;
					dq.addLast(temp);
					temp = pieces[temp].top;
				} while (pieces[temp] != null);
				
				matrix[oriX][oriY][1] = cur.bottom;
				if (cur.bottom != 0) {
					pieces[cur.bottom].top = 0;
					cur.bottom = 0;
				}
				
				while (!dq.isEmpty()) {
					int num = 0;
					if(matrix[nx][ny][0] == 1) {
						num = dq.pollLast();
					}
					else {
						num = dq.pollFirst();
					}
					pieces[num].top = 0;
					pieces[num].bottom = 0;
					
					if(matrix[nx][ny][1] == 0) {
						pieces[num].depth = 1;
					}
					else {
						pieces[matrix[nx][ny][1]].top = num;
						pieces[num].bottom = matrix[nx][ny][1];
						pieces[num].depth = pieces[matrix[nx][ny][1]].depth + 1;
					}
					
					matrix[nx][ny][1] = num;
					
					if (pieces[matrix[nx][ny][1]].depth == 4) {
						System.out.println(t);
						return;
					}
				}
				
				
			}
		}
		
		System.out.println(-1);
	}
	
	static class Piece {
		int num, x, y, dist, top, bottom, depth;
		
		Piece (int num, int x, int y, int dist) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.depth = 1;
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