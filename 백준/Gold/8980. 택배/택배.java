import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int C = read();
		int M = read();
		int sum = 0;
		int[][] matrix = new int[M][];
		int[] villages = new int[N + 1];
		for (int i = 0; i < M; i++) {
			matrix[i] = new int[] {read(), read(), read()};
		}
		Arrays.sort(matrix, (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
		for (int i = 0; i < M; i++) {
			matrix[i][2] = Math.min(matrix[i][2], C - villages[matrix[i][1]]);
			for (int j = matrix[i][1]; j > matrix[i][0]; j--) {
				villages[j] += matrix[i][2];
			}
			sum += matrix[i][2];
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
