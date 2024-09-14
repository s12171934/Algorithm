import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, square, cnt = 1, res = 11, matrix[], stuck[][], deltas[][] = {{0,-1},{1,0},{0,1},{-1,0}};

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static void init() throws Exception {
		N = read(); K = read(); matrix = new int[N];
		for (int i = 0; i < N; i++) matrix[i] = read();
		square = (int)Math.sqrt(N);
	}

	static boolean solve() {
		setFish();
		rollUp();
		flip();
		calcResult();
		return res > K;
	}

	static void setFish() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) min = Math.min(min, matrix[i]);
		for (int i = 0; i < N; i++) if (matrix[i] == min) matrix[i]++;
	}

	static void rollUp() {
		int h = Math.min(N / square, square + 1);
		int w = N - (h - 1) * square;
		stuck = new int[h][w];
		boolean[][] visited = new boolean[h][w];
		if(stuck[0].length != square) visited[h - 1][square] = true;
		int x = 0, y = stuck[0].length - 1, d= 0;
		for (int i = N - 1; i >= 0; i--) {
			stuck[x][y] = matrix[i];
			visited[x][y] = true;
			int nx = x + deltas[d][0], ny = y + deltas[d][1];
			if (nx < 0 || nx >= stuck.length || ny < 0 || ny >= stuck[0].length || visited[nx][ny]) d = (d + 1) % 4;
			x = x + deltas[d][0]; y = y + deltas[d][1];
		}
		calcDiff();
		remake();
	}

	static void flip() {
		stuck = new int[4][N / 4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < N / 4; j++) {
				stuck[(i + 1) % 4][i % 2 == 0 ? N / 4 - j - 1 : j] = matrix[i * N / 4 + j];
			}
		}
		calcDiff();
		remake();
	}

	static void calcDiff() {
		int[][] temp = new int[stuck.length][stuck[0].length];
		for (int i = 0; i < stuck.length; i++) temp[i] = stuck[i].clone();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if (stuck[i][j] == 0) break;
				if (i != temp.length - 1 && stuck[i + 1][j] != 0) {
					int diff = (stuck[i][j] - stuck[i + 1][j]) / 5;
					temp[i][j] -= diff;
					temp[i + 1][j] += diff;
				}
				if (j != temp[0].length - 1 && stuck[i][j + 1] != 0) {
					int diff = (stuck[i][j] - stuck[i][j + 1]) / 5;
					temp[i][j] -= diff;
					temp[i][j + 1] += diff;
				}
			}
		}
		stuck = temp;
	}

	static void remake() {
		int idx = 0;
		for (int i = 0; i < stuck[0].length; i++) {
			for (int j = 0; j < stuck.length; j++) {
				if (stuck[j][i] == 0) break;
				matrix[idx++] = stuck[j][i];
			}
		}
	}

	static void calcResult() {
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			min = Math.min(min, matrix[i]);
			max = Math.max(max, matrix[i]);
		}
		res = max - min;
	}

	public static void main(String[] args) throws Exception {
		init();
		while (solve()) {cnt++;};
		System.out.println(cnt);
	}
}