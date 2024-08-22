import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			boolean[] list = new boolean[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), ",");
			while(st.hasMoreTokens()) {
				StringTokenizer token = new StringTokenizer(st.nextToken(),"-");
				int low = Integer.parseInt(token.nextToken());
				if(low > N) continue;
				if(!token.hasMoreTokens()) {
					list[low] = true;
					continue;
				}
				int high = Math.min(Integer.parseInt(token.nextToken()), N);
				for (int i = low; i <= high; i++) {
					list[i] = true;
				}
			}
			int sum = 0;
			for (boolean print : list) {
				sum += print ? 1 : 0;
			}
			res.append(sum).append("\n");
		}
		System.out.println(res.toString());
	}
}
