import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] matrix = makeMatrix();
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static int[][] makeMatrix() {
		int[][] mat = new int[31][31];
		for(int i = 1; i <= 30; i++) {
			mat[1][i] = i;
			mat[i][i] = 1;
		}
		for(int i = 2; i <= 30; i++) {
			for(int j = i + 1; j <= 30; j++) {
				mat[i][j] = mat[i - 1][j - 1] + mat[i][j - 1];
			}
		}
		return mat;
	}
	
	public static void main(String[] args) throws Exception {
		int TC = read();
		while(TC-- > 0) sb.append(matrix[read()][read()]).append("\n");
		System.out.println(sb.toString());
	}
}