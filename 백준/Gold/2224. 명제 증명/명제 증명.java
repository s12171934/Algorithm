import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder res = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception {
		int N = readInt();
		boolean[][] matrix = new boolean[52][52];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int p = str.charAt(0);
			int q = str.charAt(5);
			p = p < 97 ? p - 65 : p - 71;
			q = q < 97 ? q - 65 : q - 71;
			matrix[p][q] = true;
		}
		for (int k = 0; k < 52; k++) {
			for (int i = 0; i < 52; i++) {
				for (int j = 0; j < 52; j++) {
					matrix[i][j] = matrix[i][j] || (matrix[i][k] && matrix[k][j]);
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i < 52; i++) {
			for(int j = 0; j < 52; j++) {
				if(i != j && matrix[i][j]) {
					cnt++;
					res.append(String.format("%c => %c\n", i < 26 ? i + 65 : i + 71, j < 26 ? j + 65 : j + 71));
				}
			}
		}
		System.out.println(cnt);
		System.out.println(res.toString());
 	}

	static int readInt() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}
