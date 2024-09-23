import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static int gcd(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;
		do {
			if (a < b) {
				int temp = a;
				a = b;
				b = temp;
			}
		} while ((a = a % b) != 0);
		return b;
	}

	public static void main(String[] args) throws Exception {
		int N = read();
		int[] list = new int[N], diff = new int[N -1];
		for (int i = 0; i < N; i++) list[i] = read();
		if (N == 1) {
			System.out.println(list[0]);
			return;
		}
		if (N == 2) {
			System.out.println(gcd(list[0], list[1]));
			return;
		}
		Arrays.sort(list);
		for (int i = 0; i < N - 1; i++) diff[i] = list[i + 1] - list[i];
		int ans = gcd(diff[0], diff[1]);
		for (int i = 2; i < N - 1; i++) ans = gcd(ans, diff[i]);
		System.out.println(ans);
	}
}