import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] matrix = new int[31][31];
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static void makeMatrix() {
		for(int i = 1; i <= 30; i++) {matrix[1][i] = i;matrix[i][i] = 1;}
		for(int i = 2; i <= 30; i++) {
			for(int j = i + 1; j <= 30; j++) matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j - 1];
		}
	}
	
	public static void main(String[] args) throws Exception {
		int TC = read();makeMatrix();
		while(TC-- > 0) sb.append(matrix[read()][read()]).append("\n");
		System.out.println(sb.toString());
	}
}