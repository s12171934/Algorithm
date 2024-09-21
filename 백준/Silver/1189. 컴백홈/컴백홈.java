import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, K, cnt, deltas[];

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static void DFS(int cur, int depth, int visited) {
		if (depth == K) {
			if (cur == C - 1) cnt++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int d = deltas[i];
			if (cur + d < 0 || cur + d >= R * C || (cur % C == 0 && i == 1) || (cur % C == C - 1 && i == 0)) continue;
			if ((visited & 1 << (cur + d)) == 0) DFS(cur + d, depth + 1, visited | 1 << (cur + d));
		}
	}

	public static void main(String[] args) throws Exception {
		R = read(); C = read(); K = read(); int visited = 0; deltas = new int[]{1, -1, C, -C};
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == 'T') visited |= 1 << (i * C + j);
			}
		}
		DFS((R - 1) * C,1,visited | 1 << ((R - 1) * C));
		System.out.println(cnt);
	}
}