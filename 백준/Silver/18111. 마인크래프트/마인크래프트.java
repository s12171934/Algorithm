import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		int n = readInt();
		int m = readInt();
		int b = readInt();
		
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = readInt();
				b += matrix[i][j];
			}
		}
		
		int max = b / (n * m);
		int h = 0;
		int[] ans = {Integer.MAX_VALUE,0};
		
		while (h <= max) {
			int time = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int mode = 1;
					if(matrix[i][j] > h) {
						mode = 2;
					}
					time += mode * Math.abs(matrix[i][j] - h);
				}
			}
			if(time <= ans[0]) {
				ans = new int[]{time, h};
			}
			h++;
		}
	
		System.out.println(ans[0] + " " + ans[1]);
	}
	
	public static int readInt() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 32 || r == 10) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}

}