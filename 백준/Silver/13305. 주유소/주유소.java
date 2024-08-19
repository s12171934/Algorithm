import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		long[] len = new long[N];
		long[] price = new long[N];
		long res = 0;
		price[0] = 1_000_000_000;
		for (int i = 1; i < N; i++) len[i] = read();
		for (int i = 1; i < N; i++) price[i] = Math.min(price[i -1], read());
		for (int i = 1; i < N; i++) res += len[i] * price[i];
		System.out.println(res);
 	}
	
	static int read() throws IOException {
		int res = 0;
		while(true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}
