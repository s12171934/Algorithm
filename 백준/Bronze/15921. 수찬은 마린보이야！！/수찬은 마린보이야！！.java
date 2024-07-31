import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		System.out.println(read() == 0 ? "divide by zero" : "1.00");
	}
	
	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32)
				return res;
			if (r == 13)
				continue;
			res = 10 * res + (r - 48);
		}
	}
}