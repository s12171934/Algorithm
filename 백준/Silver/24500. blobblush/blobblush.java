import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		long N = Long.parseLong(br.readLine());
		long len = (1l << Long.toBinaryString(N).length()) - 1;
		if (len == N) {
			System.out.printf("1\n%d", N);
		}
		else {
			System.out.printf("2\n%d %d", Math.min(N, ~N & len), Math.max(N, ~N & len));
		}
	}
}
