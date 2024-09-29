import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		int N = read();
		String[] list = br.readLine().split(" ");
		Arrays.sort(list, (s1, s2) -> {
			String str1 = s1 + s2;
			String str2 = s2 + s1;
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) == str2.charAt(i)) continue;
				return str1.charAt(i) < str2.charAt(i) ? 1 : -1;
			}
			return 0;
		});
		for (int i = 0; i < N; i++) sb.append(list[i]);
		System.out.println(sb.charAt(0) == '0' ? 0 : sb);
	}
}