import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, matrix[][], deltas[][] = new int[][]{{},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}}; ;
	static boolean[][] cloud;

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static void solve(int d, int s) {
		cloud = moveCloud(deltas[d], s);
		rain();
		for (int i = 0; i < N * N; i++) if(cloud[i / N][i % N]) waterCopyBug(i / N, i % N);
		cloud = makeCloud();
	}

	static boolean[][] moveCloud(int[] d, int s) {
		boolean[][] next = new boolean[N][N];
		for (int i = 0; i < N * N; i++) {
			if (cloud[i / N][i % N]) next[((i / N + d[0] * s + N) % N + N) % N][((i % N + d[1] * s + N) % N + N) % N] = true;
		}
		return next;
	}

	static void rain() {
		for (int i = 0; i < N * N; i++) if(cloud[i / N][i % N]) matrix[i / N][i % N] += 1;
	}

	static void waterCopyBug(int x, int y) {
		for (int d : new int[]{2,4,6,8}) {
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || matrix[nx][ny] == 0) continue;
			matrix[x][y]++;
		}
	}

	static boolean[][] makeCloud() {
		boolean[][] next = new boolean[N][N];
		for (int i = 0; i < N * N; i++) {
			if (cloud[i / N][i % N] || matrix[i / N][i % N] < 2) continue;
			next[i / N][i % N] = true;
			matrix[i / N][i % N] -= 2;
		}
		return next;
	}

	static int sumWater() {
		int sum = 0;
		for (int i = 0; i < N * N; i++) sum += matrix[i / N][i % N];
		return sum;
	}

	public static void main(String[] args) throws Exception {
		N = read(); M = read(); matrix = new int[N][N];
		for (int i = 0; i < N * N; i++) matrix[i / N][i % N] = read();
		cloud = new boolean[N][N];
		cloud[N -1][0] = cloud[N -2][0] = cloud[N - 1][1] = cloud[N -2][1] = true;
		for (int i = 0; i < M; i++) solve(read(), read());
		System.out.println(sumWater());
	}
}