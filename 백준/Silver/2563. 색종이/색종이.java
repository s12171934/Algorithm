import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		boolean[][] matrix = new boolean[100][100];
		int N = read();
		
		for (int n = 0; n < N; n++) {
			int x = read();
			int y = read();
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					matrix[x + i][y + j] = true;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (matrix[i][j]) sum++;
			}
		}
		
		System.out.println(sum);
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
