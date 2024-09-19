import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, min = 100_001, click[];
	static boolean[] list;

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static void check(int cnt) {
		for (int i = 1; i < N - 1; i++) {
			if (list[i] ^ (click[i - 1] + click[i]) % 2 == 0) {
				cnt++;
				click[i + 1] = 1;
			}
		}
		if (list[N - 1] ^ (click[N - 2] + click[N - 1]) % 2 == 1) min = Math.min(min, cnt);
	}

	public static void main(String[] args) throws Exception {
		N = read();
		list = new boolean[N];
		String str1 = br.readLine(), str2 = br.readLine();
		for (int i = 0; i < N; i++) list[i] = str1.charAt(i) == str2.charAt(i);
		if (list[0]) {
			click = new int[N];
			check(0);
			click = new int[N]; click[0] = 1; click[1] = 1;
			check(2);
		}
		else {
			click = new int[N]; click[0] = 1;
			check(1);
			click = new int[N]; click[1] = 1;
			check(1);

		}
		System.out.println(min == 100_001 ? -1 : min);
	}
}