import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N;
	static int max = -1_000_000_000;
	static int min = 1_000_000_000;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		N = read();
		arr = new int[N];

		for (int i = 0; i < N; i++) arr[i] = read();
		
		DFS(arr[0], 1, read(), read(), read(), read());
		
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n").append(min);
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void DFS(int sum, int n, int plus, int minus, int multiple, int mod) {
		for (int i = 0; i < 4; i++) {
			int newSum = sum;
			switch(i) {
				case 0:
					if (plus == 0) break;
					newSum += arr[n];
					DFS(newSum, n + 1, plus - 1, minus, multiple, mod);
					break;
				case 1:
					if (minus == 0) break;
					newSum -= arr[n];
					DFS(newSum, n + 1, plus, minus - 1, multiple, mod);
					break;
				case 2:
					if (multiple == 0) break;
					newSum *= arr[n];
					DFS(newSum, n + 1, plus, minus, multiple - 1, mod);
					break;
				case 3:
					if (mod == 0) break;
					newSum /= arr[n];
					DFS(newSum, n + 1, plus, minus, multiple, mod - 1);
					break;
			}
			
			if(n == N) {
				max = Math.max(max, newSum);
				min = Math.min(min, newSum);
			}
		}
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
