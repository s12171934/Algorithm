import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int N = br.read() - '0';
		Queue<Integer> q = new ArrayDeque<>();
		q.addAll(Arrays.asList(2,3,5,7));
		while (q.peek() < Math.pow(10, N - 1)) {
			int n = q.poll() * 10;
			for (int i : new int[] {1,3,5,7,9}) if(isPrime(n + i)) q.add(n + i);
		}
		for (int n : q) System.out.println(n);
	}
	static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
		return true;
	}
}