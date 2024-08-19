import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int res = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) pq.add(read());
		for (int i = 0; i < N - 1; i++) {
			int mix = pq.poll() + pq.poll();
			pq.add(mix);
			res += mix;
		}
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
