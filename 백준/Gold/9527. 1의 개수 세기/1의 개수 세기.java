import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static long[] arr;
	
	public static void main(String[] args) throws IOException {
		long a = read();
		long b = read();
		int n = Long.toBinaryString(b).length();
		arr = new long[n + 1]; 
		for (int i = 1; i < n; i++) {
			arr[i] = arr[i - 1] * 2 + (long)Math.pow(2, i  - 1);
		}
	
		System.out.println(one(b) -  one(a - 1));
	}
	
	public static long one(long n) {
		char[] biArr = Long.toBinaryString(n).toCharArray();
		int len = biArr.length;
		long res = 0;
		
		for (int i = 0; i < len; i++) {
			if(biArr[i] == '1') {
				n -= ((long)Math.pow(2, len - 1 -i) - 1);
				res += arr[len - 1 -i] + n;
				n -= 1;
			}
		}
		
		return res;
	}
	
	public static long read() throws IOException {
		long res = 0;
		while (true) {
			int r = br.read();
			if (r == 32 || r == 10) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}

}
