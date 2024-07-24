import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int MOD = 1_000_000_007;
		char[] biStr = Integer.toBinaryString(read()).toCharArray();
		long[][][] matrix = new long[biStr.length][8][8];
		matrix[0] = new long[][]{
				{0, 1, 1, 0, 0, 0, 0, 0},
				{1, 0, 1, 1, 0, 0, 0, 0},
				{1, 1, 0, 1, 1, 0, 0, 0},
				{0, 1, 1, 0, 1, 1, 0, 0},
				{0, 0, 1, 1, 0, 1, 1, 0},
				{0, 0, 0, 1, 1, 0, 0, 1},
				{0, 0, 0, 0, 1, 0, 0, 1},
				{0, 0, 0, 0, 0, 1, 1, 0}
		};
		
		for (int k = 1; k < biStr.length; k++) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					for (int l = 0; l < 8; l++) {
						matrix[k][i][j] += matrix[k - 1][i][l] * matrix[k - 1][l][j];
					}
					matrix[k][i][j] %= MOD;
				}
			}
		}
		
		Stack<long[][]> stack = new Stack<>();
		for (int k = 0; k < biStr.length; k++) {
			if (biStr[biStr.length - 1 - k] == '0') continue;
			if (stack.isEmpty()) {
				stack.add(matrix[k]);
				continue;
			}
			long[][] newMatrix = new long[8][8];
			long[][] stackMatrix = stack.pop();
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					for (int l = 0; l < 8; l++) {
						newMatrix[i][j] += matrix[k][i][l] * stackMatrix[l][j];
					}
					newMatrix[i][j] %= MOD;
				}
			}
			stack.add(newMatrix);
		}
		
		System.out.println(stack.pop()[0][0]);
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {;
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}