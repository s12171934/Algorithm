import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int[] list = new int[N];
		for(int i = 0; i < N; i++) list[i] = read();
		Arrays.sort(list);
		long sum = 0;
		for(int i = 0; i < N; i++) sum += Math.abs(list[i] - (i + 1));
		System.out.println(sum);
	}
	
	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}
