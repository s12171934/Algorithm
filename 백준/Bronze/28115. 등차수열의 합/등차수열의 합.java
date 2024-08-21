import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int[] A = new int[N];
		A[0] = read();
		if(N == 1) {
			System.out.println("YES\n" + A[0] + "\n0");
			return;
		}
		A[1] = read();
		int d = A[1] - A[0];
		for (int i = 2; i < N; i++) {
			A[i] = read();
			if(A[i] - A[i -1] != d) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		for (int i = 0; i < N; i++) {
			res.append(A[i]).append(" ");
		}
		res.append("\n");
		for (int i = 0; i < N; i++) {
			res.append(0).append(" ");
		}
		System.out.println(res.toString());
 	}
	
	static int read() throws IOException {
		int res = 0;
		int mode = 1;
		while(true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			if (r == '-') {
				mode = -1;
				continue;
			}
			res = 10 * res + mode * (r - 48);
		}
	}
}
