import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		long N = Long.parseLong(br.readLine());
		long res = 1;
		if(N == 1) {
			System.out.println(1);
			return;
		}
		for (int i = 2; i < (int)Math.sqrt(N) + 1; i++) {
			long exp = 0;
			while (N % i == 0) {
				N /= i;
				exp++;
			}
			if(exp == 0) continue;
			res *= (int)(Math.pow(i, exp) - Math.pow(i, exp - 1));
			if(N == 1) break;
		}
		if(N != 1) {
			res *= (N - 1);
		}
		
		System.out.println(res);
	}
}
