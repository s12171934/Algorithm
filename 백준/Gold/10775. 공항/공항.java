import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[] parents;
	
	public static void main(String[] args) throws IOException {
		int G = read();
		int P = read();
		parents = new int[G + 1];
		for(int i = 0; i <= G; i++) parents[i] = i;
		
		int i;
		for(i = 0; i < P; i++) {
			int g = read();
			int parentG = getParent(g);
			if (parents[parentG] == 0) break;
			parents[g]--;
			if (g == parentG) continue;
			parents[parentG]--;
		}
		
		System.out.println(i);
	}
	
	public static int getParent(int n) {
		if(parents[n] == n) return n;
		return getParent(parents[n]);
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}