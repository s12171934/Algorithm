import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int n = read();
		int m = read();
		int r = read();
		
		int[] items = new int[n + 1];
		for (int i = 1; i <= n; i++) items[i] = read();
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		for (int i = 0; i < r; i++) {
			int n1 = read();
			int n2 = read();
			int weight = read();
			
			graph.get(n1).add(new Node(n1,n2,weight));
			graph.get(n2).add(new Node(n2,n1,weight));
		}
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int count = 0;
			
			boolean[] visited = new boolean[n + 1];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(i,0,0));
			
			while (!pq.isEmpty()) {
				Node node = pq.poll();
				if (visited[node.n1]) continue;
				visited[node.n1] = true;
				if (node.weight > m) continue;
				count += items[node.n1];
				
				for (Node nxt : graph.get(node.n1)) {
					pq.add(new Node(nxt.n2,0,node.weight + nxt.weight));
				}
			}
			
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}
	
	public static class Node implements Comparable<Node> {
		int n1,n2,weight;
		
		public Node(int n1, int n2, int weight) {
			this.n1 = n1;
			this.n2 = n2;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}
