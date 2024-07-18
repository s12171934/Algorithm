import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int T = read();
		int[] A = makeArr(read());
		int[] B = makeArr(read());
		
		int pa = 0;
		int pb = B.length - 1;
		
		long count = 0;
		while (pa < A.length && pb >= 0) {
			int sum = A[pa] + B[pb];
			if (sum < T) {
				while (++pa < A.length && A[pa - 1] == A[pa]) {};
			}
			else if (sum > T) {
				while (--pb >= 0 && B[pb + 1] == B[pb]) {};
			}
			else {
				long oriPa = pa;
				long oriPb = pb;
				while (++pa < A.length && A[pa - 1] == A[pa]) {};
				while (--pb >= 0 && B[pb + 1] == B[pb]) {};
				count += (pa - oriPa) * (oriPb - pb);
			}
		}
		
		System.out.println(count);
	}
	
	public static int[] makeArr(int n) throws IOException {
		int[] res = new int[(n * (n + 1)) / 2];
		res[0] = read();
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] + read();
		}
		int pointer = n;
		for (int s = 0; s < n - 1; s++) {
			for (int e = s + 1; e < n; e++) {
				res[pointer++] = res[e] - res[s];
			}
		}
		Arrays.sort(res);
		return res;
	}

	
	public static int read() throws IOException {
		int res = 0;
        int mode = 1;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
            if (r == 45) {
                mode = -1;
                continue;
            }
			res = 10 * res + mode * (r - 48);
		}
	}
}
