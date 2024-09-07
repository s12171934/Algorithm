import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		int N = read(), min = Integer.MAX_VALUE, list[] = new int[N];
		for (int i = 0; i < N; i++) list[i] = read();
		Arrays.sort(list);
		for (int i = 0; i < N; i++) {
			for (int j = i + 3; j < N; j++) {
				int elsa = list[i] + list[j];
				int s = i + 1;
				int e = j - 1;
				while (s < e) {
					int anna = list[s] + list[e];
					if (elsa == anna) {
						System.out.println(0);
						return;
					}
					if (elsa > anna) {
						s++;
					} else {
						e--;
					}
					min = Math.min(min, Math.abs(anna - elsa));
				}
			}
		}
		System.out.println(min);
	}
}