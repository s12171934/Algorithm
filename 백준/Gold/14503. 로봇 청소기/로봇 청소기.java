import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int M = read();
		int x = read();
		int y = read();
		int d = read();
		int[][] matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = read();
			}
		}
		
		int count = 0;
		loop: while (true) {
			if (matrix[x][y] == 0) {
				matrix[x][y] = 2;
				count++;
				continue loop;
			}
			
			for (int i = 3; i >= 0; i--) {
				int nd = (d + i) % 4;
				if(matrix[x + deltas[nd][0]][y + deltas[nd][1]] == 0) {
					x += deltas[nd][0];
					y += deltas[nd][1];
					d = nd;
					continue loop;
				}
			}
			
			x -= deltas[d][0];
			y -= deltas[d][1];
			if (matrix[x][y] == 1) {
				break loop;
			}
		}
		
		System.out.println(count);
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
