import java.io.*;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int sum = 0;
		int[][] matrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				matrix[i][j] = matrix[i][j - 1] + read();
			}
			sum += matrix[i][N];
		}
		
		int res = sum;
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				for (int d1 = 1; d1 <= N; d1++) {
					if (y - d1 < 1) continue;
					for (int d2 = 1; d2 <= N; d2++) {
						if (x + d1 + d2 > N) continue;
						if (y + d2 > N) continue;
						int[] people = new int[5];
						
						for (int i = 1; i <= x + d1 - 1; i++) {
							people[0] += matrix[i][y - Math.max(0, i - (x - 1))]; 
						}
						
						for (int i = 1; i <= x + d2; i++) {
							people[1] += matrix[i][N] - matrix[i][y + Math.max(0, i - x)];
						}
						
						for (int i = x + d1; i <= N; i++) {
							people[2] += matrix[i][y - d1 + d2 - 1 - Math.max(0, x + d1 + d2 - i)];
						}
						
						for (int i = x + d2 + 1; i <= N; i++) {
							people[3] += matrix[i][N] - matrix[i][y - d1 + d2 - 1 + Math.max(0, x + d1 + d2 + 1 - i)];
						}
						
						people[4] = sum - (people[0] + people[1] + people[2] + people[3]);
						
						int min = people[0];
						int max = people[0];
						for (int i = 1; i <= 4; i++) {
							min = Math.min(min, people[i]);
							max = Math.max(max, people[i]);
						}
						res = Math.min(res, max - min);
					}
				}
			}
		}
		
		System.out.println(res);
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
