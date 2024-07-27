import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int[] points = {250, 275, 300};
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int level = read();
			int section = 4;
			for (int point : points) {
				section -= level / point;
			}
			sb.append(section).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int read() throws IOException {
		int res = 0;
		
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}