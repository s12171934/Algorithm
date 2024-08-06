import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int[] list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = read();
		}
		int M = read();
		int max = 0;
		int[] res = new int[M];
		for (int i = 0; i < M; i++) {
			res[i] = read();
			max = Math.max(max, res[i]);
		}
		
		Set<Integer> dp = new HashSet<>();
		dp.add(0);
		
		for(int i = 0; i < N; i++) {
			Integer[] temp = new Integer[dp.size()];	
			for (int j : dp.toArray(temp)) {
				for (int k : new int[] {-1, 1}) {
					dp.add(j + k * list[i]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i : res) {
			sb.append(dp.contains(i) ? 'Y' : 'N').append(' '); 
		}
		System.out.println(sb.toString());
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