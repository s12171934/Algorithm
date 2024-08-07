import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int W = read();
		int H = read();
		int N = read();
		
		int[][] store = new int[N][2];
		for (int i = 0; i < N; i++) {
			store[i][0] = read();
			store[i][1] = read();
		}
		
		int d = read();
		int p = read();
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			int sd = store[i][0];
			int sp = store[i][1];
			
			if (d == sd) {
				sum += Math.abs(p - sp);
				continue;
			}
			
			int[] ps = new int[5];
			ps[d] = p;
			ps[sd] = sp;
			
			int rel = (1 << (d - 1)) + (1 << (sd - 1));
			switch (rel) {
			case 3:
				sum += H + Math.min(ps[1] + ps[2], 2 * W - ps[1] - ps[2]);
				break;
			case 5:
				sum += ps[1] + ps[3];
				break;
			case 6:
				sum += ps[2] + (H - ps[3]);
				break;
			case 9:
				sum += (W - ps[1]) + ps[4];
				break;
			case 10:
				sum += (W - ps[2]) + (H - ps[4]);
				break;
			case 12:
				sum += W + Math.min(ps[3] + ps[4], 2 * H - ps[3] - ps[4]);
				break;
			}
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
