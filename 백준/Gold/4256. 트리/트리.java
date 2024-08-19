import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] preorder, inorder;
	static int N;
	static StringBuilder res = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			preorder = new int[N];
			inorder = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
			}
			res.append(postOrder(0, 0, N, 0, N)).append("\n");
		}
		System.out.println(res.toString());
	}
	
	static String postOrder(int idx, int s1, int e1, int s2, int e2) {
		if(idx >= N || s1 > e1 || s2 > e2) return "";
		StringBuilder sb = new StringBuilder();
		int i = s2;
		for (; i < e2; i++) {
			if (inorder[i] == preorder[idx]) break;
		}
		sb.append(postOrder(idx + 1, s1 + 1, s1 + i - s2, s2, i));
		sb.append(postOrder(idx + i - s2 + 1, s1 + i - s2 + 1, e1, i + 1, e2));
		sb.append(preorder[idx]).append(" ");
		return sb.toString();
	}
}
