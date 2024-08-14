import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int[][] foods = new int[2][1 << N];
		Arrays.fill(foods[0], 1);
		
		for (int i = 0; i < N; i++) {
			int sour = read();
			int bitter = read();
			for (int j = 1 << i; j < 1 << N; j ++) {
				if((j & (1 << i)) == 0) continue;
				foods[0][j] *= sour;
				foods[1][j] += bitter;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < (1 << N); i++) {
			min = Math.min(min, Math.abs(foods[0][i] - foods[1][i]));
		}
		
		System.out.println(min);
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