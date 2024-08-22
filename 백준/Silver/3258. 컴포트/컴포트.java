import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int Z = read() % N;
		int M = read();
		boolean[] list = new boolean[N];
		list[1] = true;
		for (int i = 0; i < M; i++) list[read()] = true;
		loop : for (int i = 1; i < N; i++) {
			int now = 1;
			while(now != Z) {
				now = (now + i) % N;
				if (list[now]) continue loop;
			}
			System.out.println(i);
			return;
		}
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
