import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[] parents;
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int M = read();
		parents = new int[N + 1];
		for(int i = 0; i <= N; i++) parents[i] = i;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= M; i++) {
			pq.add(new Node(read(), read(), read()));
		}
		
		int count = 0;
		int sum = 0;
		while(count < N - 2 && !pq.isEmpty()) {
			Node node = pq.poll();
			if(getParent(node.n1) == getParent(node.n2)) continue;
			union(node.n1, node.n2);
			count++;
			sum += node.w;
		}
		
		System.out.println(sum);
	}
	
	public static class Node implements Comparable<Node> {
		int n1,n2,w;
		
		public Node(int n1, int n2, int w) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
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