import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int TC = read();
		
		for (int tc = 0; tc < TC; tc++) {
			int n = read();
			int[][] list = new int[2][n + 1];
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= n; j++) {
					list[i][j] = read();
				}
			}
			
			for (int i = 2; i <= n; i++) {
				list[0][i] +=  Math.max(list[1][i - 2], list[1][i - 1]);
				list[1][i] +=  Math.max(list[0][i - 2], list[0][i - 1]);
			}
			
			sb.append(Math.max(list[0][n], list[1][n])).append("\n");
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
