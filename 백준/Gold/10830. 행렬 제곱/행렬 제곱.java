import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		long N = read();
		char[] B = Long.toBinaryString(read()).toCharArray();
		
		int[][][] matrix = new int[B.length][(int)N][(int)N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[0][i][j] = (int)read();
			}
		}
		
		for (int k = 1; k < B.length; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int n = 0; n < N; n++) {
						matrix[k][i][j] += (matrix[k - 1][i][n] * matrix[k - 1][n][j]) % 1000;
					}
					matrix[k][i][j] %= 1000;
				}
			}
		}
		
		Stack<int[][]> stack = new Stack<>();
		for (int k = 0; k < B.length; k++) {
			if(B[k] == '0') continue;
			if(stack.isEmpty()) stack.add(matrix[B.length - 1- k]);
			else {
				int[][] result = new int[(int)N][(int)N];
				int[][] prev = stack.pop();
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						for (int n = 0; n < N; n++) {
							result[i][j] += (matrix[B.length - 1- k][i][n] * prev[n][j]) % 1000;
						}
						result[i][j] %= 1000;
					}
				}
				stack.add(result);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int[] row : stack.pop()) {
			for(int n : row) {
				sb.append(n % 1000).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static long read() throws IOException {
		long res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}