import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int M = read();
		int[] list = new int[N + 1];
		for (int i = 1; i <= N; i++) list[i] = list[i - 1] + read();
		for (int i = 1; i <= M; i++) sb.append(-1 * list[read() - 1] + list[read()]).append("\n");
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