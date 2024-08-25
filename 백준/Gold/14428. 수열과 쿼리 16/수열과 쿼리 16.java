import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder res = new StringBuilder();
	static int[] list, tree;

	public static void main(String[] args) throws Exception {
		int N = read();
		list = new int[N + 1];
		list[0] = Integer.MAX_VALUE;
		tree = new int[N * 4];
		for (int i = 1; i <= N; i++) list[i] = read();
		initTree(1,1,N);
		
		
		int M = read();
		for (int i = 0; i < M; i++) {
			int mode = read();
			if (mode == 1) {
				int idx = read();
				int value = read();
				list[idx] = value;
				changeTree(1, 1, N, idx);
			}
			else {
				res.append(getIdx(1, 1, N, read(), read())).append("\n");
			}
		}
		System.out.println(res.toString());
 	}
	
	static void changeTree(int treeIdx, int s, int e, int idx) {
		while(s != idx || e != idx) {
			int m = (s + e) / 2;
			if (idx <= m) {
				treeIdx = treeIdx * 2;
				e = m;
			}
			else {
				treeIdx = treeIdx * 2 + 1;
				s = m + 1;
			}
		}
		while(treeIdx > 1) {
			treeIdx /= 2;
			int left = tree[treeIdx * 2];
			int right = tree[treeIdx * 2 + 1];
			tree[treeIdx] = list[left] <= list[right] ? left : right;
		}
	}
	
	static int getIdx(int treeIdx, int s, int e, int sIdx, int eIdx) {
		if(sIdx > eIdx) return 0;
		if(s == sIdx && e == eIdx) return tree[treeIdx];
		int m = (s + e) / 2;
		int left = getIdx(treeIdx * 2, s, m, Math.max(s, sIdx), Math.min(m, eIdx));
		int right = getIdx(treeIdx * 2 + 1, m + 1, e, Math.max(m + 1, sIdx), Math.min(e, eIdx));
		return list[left] <= list[right] ? left : right;
	}
	
	static int initTree(int idx, int s, int e) {
		tree[idx] = s;
		if(s != e) {
			int m = (s + e) / 2;
			int left = initTree(idx * 2, s, m);
			int right = initTree(idx * 2 + 1, m + 1, e);
			tree[idx] = list[left] <= list[right] ? left : right;
		}
		return tree[idx];
	}
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}
