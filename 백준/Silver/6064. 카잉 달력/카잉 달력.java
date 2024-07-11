import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		int TC = readInt();
		
		for (int t = 0; t < TC; t++) {
			int ans = -1;
			
			int N = readInt();
			int M = readInt();
			int x = readInt();
			int y = readInt();
			
			int max = N * M / gcd(N, M);

			
			for (int i = 0; i < max / N; i++) {
				if ((i * N + x - y) % M == 0) {
					ans = i * N + x;
				}
			}
			
			System.out.println(ans);
		}
		
		
		br.close();
	}
	
	public static int gcd(int a, int b) {
		
		while (true) {
			if(a < b) {
				int temp = a;
				a = b;
				b = temp;
			}
			
			if (a % b == 0) {
				break;
			}
			else {
				a -= b;
			}
		}
		return b;
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