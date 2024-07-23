import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[] parents;
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int M = read();
		parents = new int[N];
		for(int i = 0; i < N; i++) parents[i] = i;
		
		for (int i = 1; i <= M; i++) {
			int n1 = read();
			int n2 = read();
			if(getParent(n1) == getParent(n2)) {
				System.out.println(i);
				return;
			}
			
			union(n1, n2);
		}
		System.out.println(0);
	}
	
	public static int getParent(int n) {
		if(parents[n] == n) return n;
		return getParent(parents[n]);
	}
	
	public static void union(int n1,int n2) {
		n1 = getParent(n1);
		n2 = getParent(n2);
		
		if (n1 < n2) {
			parents[n2] = n1;
		}
		else {
			parents[n1] = n2;
		}
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