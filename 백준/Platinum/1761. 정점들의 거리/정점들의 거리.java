import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {	
		int N = read();
		ArrayList<Node>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			int n1 = read();
			int n2 = read();
			int weight = read();
			graph[n1].add(new Node(n1, n2, weight, 0));
			graph[n2].add(new Node(n2, n1, weight, 0));
		}
		
		Node[] nodes = new Node[N + 1];
		nodes[1] = new Node(1, 1, 0, 1);
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (Node next : graph[cur]) {
				if(nodes[next.n2] != null) continue;
				q.add(next.n2);
				nodes[next.n2] = new Node(next.n2, next.n1, next.weight, nodes[next.n1].depth + 1);
			}
		}
		
		int M = read();
		for (int i = 0; i < M; i++) {
			int n1 = read();
			int n2 = read();
			int len = 0;
			while (n1 != n2) {
				if (nodes[n1].depth > nodes[n2].depth) {
					len += nodes[n1].weight;
					n1 = nodes[n1].n2;
				}
				else {
					len += nodes[n2].weight;
					n2 = nodes[n2].n2;
				}
			}
			System.out.println(len);
		}
	}
	
	static class Node {
		int n1, n2, weight, depth;
		
		Node (int n1, int n2, int weight, int depth) {
			this.n1 = n1;
			this.n2 = n2;
			this.weight = weight;
			this.depth = depth;
			
		}
	}

	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}
