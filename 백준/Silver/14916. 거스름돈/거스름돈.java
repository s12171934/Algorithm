import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		System.out.println(n == 1 || n == 3 ? -1 : (n % 5) % 2 == 1 ? (n / 5) - 1 + (n % 5 + 5) / 2 : n / 5 + (n % 5) / 2);
	}
}
