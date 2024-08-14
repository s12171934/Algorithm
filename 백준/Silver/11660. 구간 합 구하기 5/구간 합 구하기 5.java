import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int M = read();
		int[][] matrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N ; j++) {
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j -1] - matrix[i -1][j -1] + read();
			}
		}
		for (int i = 0; i < M; i++) {
			int[] info = {read() - 1, read() - 1, read(), read()};
			sb.append(matrix[info[0]][info[1]] + matrix[info[2]][info[3]] - matrix[info[0]][info[3]] - matrix[info[2]][info[1]]).append("\n");
		}
		System.out.println(sb.toString());
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
