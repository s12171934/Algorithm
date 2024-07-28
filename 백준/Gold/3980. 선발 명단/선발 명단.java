import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] matrix = new int[11][11];
	static int max;
	
	public static void main(String[] args) throws IOException {
		int TC = read();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < TC; t++) {
			max = 0;
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					matrix[i][j] = read();
				}
			}
			DFS(0,0,0);
			sb.append(max).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void DFS(int sum, int n, int check) {
		if(check == (1 << 11) - 1) {
			max = Math.max(max, sum);
			return;
		}
		if(n == 11) return;
		for (int i = 0; i < 11; i++) {
			if(matrix[n][i] == 0) continue;
			if((check & (1 << i)) != 0) continue;
			DFS(sum + matrix[n][i], n + 1, check | (1 << i));
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
