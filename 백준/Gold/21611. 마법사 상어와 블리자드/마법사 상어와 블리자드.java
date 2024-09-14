import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, res, delta[][] = {{},{-1,0},{1,0},{0,-1},{0,1}}, matrix[][];
	static ArrayDeque<Integer> queue = new ArrayDeque<>();

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static void init() throws Exception {
		N = read(); M = read(); matrix = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int count = N * N, x = 0, y = 0, d = 0, order[] = {4,2,3,1};
		for (int i = 0; i < N * N; i++) matrix[i / N][i % N] = read();
		while (--count > 0) {
			if (matrix[x][y] != 0) queue.addFirst(matrix[x][y]);
			visited[x][y] = true;
			matrix[x][y] = count;
			int nx = x + delta[order[d]][0], ny = y + delta[order[d]][1];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])  d = (d + 1) % 4;
			x = x + delta[order[d]][0];
			y = y + delta[order[d]][1];
		}
	}

	static void solve(int d, int s) {
		spell(d, s);
		while (bomb()) {};
		change();
	}

	static void spell(int d, int s) {
		int cnt = 1, len = queue.size();
		for (int i = 1; i <= len; i++) {
			int cur = queue.pollFirst();
			if (cnt <= s && i == matrix[N / 2 + delta[d][0] * cnt][N / 2 + delta[d][1] * cnt]) {
				cnt++;
				continue;
			}
			queue.addLast(cur);
		}
	}

	static boolean bomb() {
		boolean loop = false;
		int len = queue.size();
		while (len > 0) {
			int cnt = 1, cur = queue.pollFirst();
			len--;
			while (!queue.isEmpty() && queue.peekFirst() == cur && len > 0) {
				cnt++;
				queue.removeFirst();
				len--;
			}
			if (cnt < 4) {
				for (int i = 0; i < cnt; i++) queue.addLast(cur);
			}
			else {
				res += cur * cnt;
				loop = true;
			}
		}
		return loop;
	}

	static  void change() {
		int len = queue.size(), size = 0;
		while (len > 0) {
			int A = 1, B = queue.pollFirst();
			len--;
			while (!queue.isEmpty() && queue.peekFirst() == B && len > 0) {
				A++;
				queue.removeFirst();
				len--;
			}
			if (++size >= N * N) {
				while(len-- > 0) queue.pollFirst();
				return;
			}
			queue.addLast(A);
			if (++size >= N * N) {
				while(len-- > 0) queue.pollFirst();
				return;
			}
			queue.addLast(B);
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		for (int i = 0; i < M; i++) solve(read(), read());
		System.out.println(res);
	}
}