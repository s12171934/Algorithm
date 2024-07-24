import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[] parents;
	public static int[] inOrder;
	public static int[] postOrder;
	
	public static void main(String[] args) throws IOException {
		int n = read();
		inOrder = new int[n];
		postOrder = new int[n];
		
		for (int i = 0; i < n; i++) inOrder[i] = read();
		for (int i = 0; i < n; i++) postOrder[i] = read();
		
		makePreOrder(0, n - 1, 0, n - 1);
	}
	
	public static void makePreOrder(int inS, int inE, int postS, int postE) {
		if(postS > postE) return;
		int root = postOrder[postE];
		System.out.print(root + " ");
		if(postS == postE) return;
		
		int i;
		for (i = 0; i < inE - inS; i++) {
			if(inOrder[inS + i] == root) break;
		}
		makePreOrder(inS, inS + i - 1, postS, postS + i - 1);
		makePreOrder(inS + i + 1, inE, postS + i, postE - 1);
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {;
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}