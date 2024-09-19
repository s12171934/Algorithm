import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, cnt, max, wall[][], room[][], deltas[][] = {{0,-1},{-1,0},{0,1},{1,0}};
	static ArrayList<Integer> size = new ArrayList<>();

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static void solve() {
		for (int i = 0; i < N * M; i++) {
			if (room[i / N][i % N] == 0) BFS(i, ++cnt);
		}
		System.out.println(cnt);
		System.out.println(max);
		for (int i = 0; i < N * M; i++) {
			if (i / N != M - 1 && room[i / N][i % N] != room[i / N + 1][i % N]) max = Math.max(max, size.get(room[i / N][i % N]) + size.get(room[i / N + 1][i % N]));
			if (i % N != N - 1 && room[i / N][i % N] != room[i / N][i % N + 1]) max = Math.max(max, size.get(room[i / N][i % N]) + size.get(room[i / N][i % N + 1]));
		}
		System.out.println(max);
	}

	static void BFS(int idx, int number) {
		int sum = 1;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(idx);
		room[idx / N][idx % N] = number;
		while (!q.isEmpty()) {
			int cur = q.poll(), x = cur / N, y = cur % N;
			for (int i = 0; i < 4; i++) {
				int nx = x + deltas[i][0], ny = y + deltas[i][1];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N || room[nx][ny] != 0) continue;
				if ((wall[x][y] & 1 << i) != 0) continue;
				sum++;
				room[nx][ny] = number;
				q.add(nx * N + ny);
			}
		}
		max = Math.max(max, sum);
		size.add(sum);
	}

	public static void main(String[] args) throws Exception {
		N = read(); M = read(); wall = new int[M][N]; room = new int[M][N];
		size.add(0);
		for (int i = 0; i < N * M; i++) wall[i / N][i % N] = read();
		solve();
	}
}