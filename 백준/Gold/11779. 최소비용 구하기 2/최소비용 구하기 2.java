import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int n = read();
		int m = read();
		boolean[] visited = new boolean[n + 1];
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			int s = read();
			int e = read();
			int w = read();
			graph.get(s).add(new Node(s,e,w));
		}
		int start = read();
		int end = read();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0,0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if(visited[node.s]) continue;
			if(node.s == end) {
				System.out.println(node.w);
				System.out.println(node.route.size() + 1);
				for(Node r : node.route) {
					System.out.print(r.s + " ");
				}
				System.out.println(node.s);
			}
			visited[node.s] = true;
			
			for (Node n1 : graph.get(node.s)) {
				Node newNode = new Node(n1.e, 0, node.w + n1.w);
				newNode.route.addAll(node.route);
				newNode.route.add(node);
				pq.add(newNode);
			}
		}
		
		
		
	}
	
	public static class Node implements Comparable<Node> {
		int s,e,w;
		ArrayList<Node> route = new ArrayList<>();
		public Node (int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
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
