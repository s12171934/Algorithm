import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder res = new StringBuilder();
	static Node[] tree;
	static int[] list;

	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		list = new int[N + 1];
		tree = new Node[(int)Math.pow((int)Math.sqrt(N) + 1, 2) * 4];
		for (int i = 1; i <= N; i++) list[i] = read();
		initTree(1,1,N);
		for (int i = 0; i < M; i++) {
			int[] result = getMinMax(1, read(), read());
			res.append(String.format("%d %d\n", result[0], result[1]));
		}
		System.out.println(res.toString());
 	}
	
	static Node initTree(int idx, int s, int e) {
		if (s == e) return tree[idx] = new Node(s, e, list[s], list[s]);
		int m = (s + e) / 2;
		Node left = initTree(2 * idx, s, m);
		Node right = initTree(2 * idx + 1, m + 1, e);
		return tree[idx] = new Node(s, e, Math.min(left.min, right.min), Math.max(left.max, right.max));
	}
	
	static int[] getMinMax(int idx, int s, int e) {
		if (s > e) return new int[] {Integer.MAX_VALUE, 0};
		if (tree[idx].s == s && tree[idx].e == e) return new int[] {tree[idx].min, tree[idx].max};
		int m = (tree[idx].s + tree[idx].e) / 2;
		int[] left = getMinMax(idx * 2, s, Math.min(e, m));
		int[] right = getMinMax(idx * 2 + 1, Math.max(s, m + 1), e);
		return new int[] {Math.min(left[0], right[0]), Math.max(left[1], right[1])};
	}
	
	static class Node {
		int s, e, min, max;
		
		Node(int s, int e, int min, int max) {
			this.s = s;
			this.e = e;
			this.min = min;
			this.max = max;
		}
	}

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}
