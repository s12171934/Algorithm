import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		System.out.println(N == 4 || N == 7 ? - 1 : N / 5 + (N % 5 == 0 || N % 5 == 3 ? (N % 5) / 3 : N % 5 == 2 ? 2 : (N % 5 + 5) / 3 - 1));
	}
}
