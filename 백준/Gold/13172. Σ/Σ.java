import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		int M = read();
		Queue<long[]> q = new LinkedList<>();
		long[] sum = {read(),read()};
		for(int i = 1; i < M; i++) {
			long d1 = read();
			long d2 = read();
			long s1 = (sum[0] * d1) % MOD;
			long s2 = (sum[0] * d2 + sum[1] * d1) % MOD;
			sum[0] = s1;
			sum[1] = s2;
		}
		
		char[] biMod = Integer.toBinaryString(MOD - 2).toCharArray();
		long[] twice = new long[biMod.length];
		twice[biMod.length -1] = sum[0];
		for(int i = biMod.length - 2; i >= 0; i--) {
			twice[i] = (twice[i + 1] * twice[i + 1]) % MOD; 
		}
		long b = 1;
		for(int i = 0; i < biMod.length; i++) {
			if(biMod[i] == '1') b *= twice[i];
			b %= MOD;
		}
		System.out.println((sum[1] * b) % MOD);
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}