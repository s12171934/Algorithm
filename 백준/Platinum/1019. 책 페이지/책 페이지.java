import java.io.*;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int len = String.valueOf(N).length();
		int[] max = new int[10];
		for (int i = 1; i < 10; i++) {
			max[i] = i * (int)(Math.pow(10, i - 1));
		}
		
		int[] res = new int[10];
		
		for (int n = 0; n <= N % 10; n++) {
			res[n] += 1;
		}
		
		for (int d = 1; d < len; d++) {
			int n = (N % (int)Math.pow(10,d + 1))/(int)Math.pow(10, d);
		
			for (int i = 0; i < n; i++) {
				res[i] += (int)Math.pow(10,d);
			}
			res[n] += N % (int)Math.pow(10, d) + 1;
			
			for (int i = 0; i < 10; i++) {
				res[i] += max[d] * n;
			}
		}
		
		for (int d = 0; d < len; d++) {
			res[0] -= (int)Math.pow(10, d);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int num : res) {
			sb.append(num).append(" ");
		};
		System.out.println(sb.toString());
	}
}