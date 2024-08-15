import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int p;
	
	public static void main(String[] args) throws IOException {
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		ArrayList<Integer> res = new ArrayList<>();
		int[] pi = new int[P.length];
		int idx = 0;
		for (int j = 1; j < P.length; j++) {
			while(idx > 0 && P[idx] != P[j]) idx = pi[idx - 1];
			if(P[idx] == P[j]) pi[j] = ++idx;

		}
		
		idx = 0;
		for(int t = 0; t <= T.length - P.length + idx; t++) {
			int startIdx = t - idx;
			while(startIdx <= T.length - P.length && T[startIdx] != P[0]) startIdx++;
			if(startIdx > T.length - P.length) break;
			for (p = idx ; p < P.length; p++) {
				if(T[startIdx + p] != P[p]) break;
			}
			t = startIdx + p - 1;
			if (p == P.length) res.add(startIdx + 1);
			idx = pi[p - 1];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(res.size()).append("\n");
		for (int r : res) sb.append(r).append(" ");
		System.out.println(sb.toString());
 	}
}