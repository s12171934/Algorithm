import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int t = read();
		
		while (t-- > 0) {
			int n = read();
			ArrayList<Map<Integer,Integer>> tri = new ArrayList<>();
			tri.add(new HashMap<>());
			for (int i = 0; i < n; i++) {
				int idx = 0;
				char[] number = br.readLine().toCharArray();
				for(int j = 0; j < number.length; j++) {
					if(!tri.get(idx).containsKey(number[j] - 48)) {
						 tri.get(idx).put(number[j] - 48, tri.size());
						 tri.add(new HashMap<>());
					}
					idx = tri.get(idx).get(number[j] - 48);
				}
			}
			for (Map map : tri) {
				if(map.size() == 0) n--;
			}
			sb.append(n == 0 ? "YES\n" : "NO\n");
		}
		
		System.out.println(sb);
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