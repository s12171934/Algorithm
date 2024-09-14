import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K, deltas[][] = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}}, sep[][] = {{0,2,4,6},{1,3,5,7}};
	static FireBalls[][] matrix;

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static class FireBalls {
		ArrayList<FireBall> list = new ArrayList<>();
		int sumM, sumS, cnt, d, same = -1;
	}

	static class FireBall {
		int m, s, d;
		FireBall(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static void solve() {
		FireBalls[][] temp = new FireBalls[N][N];
		for (int i = 0; i < N * N; i++) {
			if (matrix[i / N][i % N] == null) continue;
			for (FireBall f : matrix[i / N][i % N].list) {
				int x = ((i / N + deltas[f.d][0] * f.s) % N + N) % N;
				int y = ((i % N + deltas[f.d][1] * f.s) % N + N) % N;
				if (temp[x][y] == null) {
					temp[x][y] = new FireBalls();
					temp[x][y].d = f.d;
				}
				temp[x][y].cnt++;
				temp[x][y].sumM += f.m;
				temp[x][y].sumS += f.s;
				if (temp[x][y].same == -1) temp[x][y].same = f.d % 2;
				else if (temp[x][y].same != f.d % 2) temp[x][y].same = 2;
			}
		}

		for (int i = 0; i < N * N; i++) {
			FireBalls cur = temp[i / N][i % N];
			if (cur != null && cur.cnt == 1) {
				cur.list.add(new FireBall(cur.sumM, cur.sumS, cur.d));
				continue;
			}
			if (cur != null && cur.sumM < 5) cur = null;
			if (cur == null) continue;
			for (int d : sep[cur.same / 2]) {
				cur.list.add(new FireBall(cur.sumM / 5, cur.sumS / cur.cnt, d));
			}
		}

		matrix = temp;
	}

	static int sumM() {
		int sum = 0;
		for (int i = 0; i < N * N; i++) {
			if (matrix[i/ N][i % N] == null) continue;
			for (FireBall f : matrix[i / N][i % N].list) sum += f.m;
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		N = read(); M = read(); K = read(); matrix = new FireBalls[N][N];
		for (int i = 0; i < M; i++) {
			int x = read() - 1, y = read() - 1;
			if (matrix[x][y] == null) matrix[x][y] = new FireBalls();
			matrix[x][y].list.add(new FireBall(read(), read(),read()));
		}
		while (K-- > 0) solve();
		System.out.println(sumM());
	}
}