import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int n = read();
		int k = read();
		
		Node[] nodes = new Node[100_001];
		for (int i = 0; i < 100_001; i++) nodes[i] = new Node(i,-1,0);
		nodes[n].t = 0;
		nodes[n].r = 1;
		
		Queue<Node> q = new LinkedList<>();
		q.add(nodes[n]);
		nodes[n].visited = true;
		
		while (!q.isEmpty()) {
			Node n1 = q.poll();
			
			if (n1.n == k) {
				System.out.println(n1.t + "\n" + n1.r);
				break;
			}
			
			int[] arr = {n1.n - 1, n1.n + 1, 2 * n1.n};
			for(int n2 : arr) {
				if (n2 < 0 || n2 > 100_000) continue;
				if (nodes[n2].t == -1) nodes[n2].t = n1.t + 1;
				if (nodes[n2].t == n1.t + 1) nodes[n2].r += n1.r;
				if (nodes[n2].visited) continue;
				nodes[n2].visited = true;
				q.add(nodes[n2]);
			}
			
		}
	}
	
	public static class Node{
		int n, t, r;
		boolean visited = false;
		public Node(int n, int t, int r) {
			this.n = n;
			this.t = t;
			this.r = r;
		}
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 32 || r == 10) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}
