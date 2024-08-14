import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		N = read();
		M = read();
		DFS(0,0,0);
		System.out.println(res.toString());
	}
	
	static void DFS(int pointer, int depth, int visit) {
		if(depth == M) {
			for (int i = 1; i <= 8; i++) {
				if((visit & (1 << i)) == 0) continue;
				res.append(i).append(" ");
			}
			res.append("\n");
			return;
		}
		for (int i = pointer + 1; i <= N; i++) {
			DFS(i, depth + 1, visit | 1 << i);
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