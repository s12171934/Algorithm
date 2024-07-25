import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static Node[] graph;
	public static int count;
	
	
	public static void main(String[] args) throws IOException {
		int N = read();
		
		graph = new Node[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new Node(i);
		}
		for (int i = 0; i < N - 1; i++) {
			int n1 = read();
			int n2 = read();
			
			graph[n1].list.add(n2);
			graph[n2].list.add(n1);
		}
		
		DFS(1);
		
		 System.out.println(count);
	}
	
	public static boolean DFS(int n) {	
		graph[n].visited = true;
		
		for(int next : graph[n].list) {
			if(graph[next].visited) continue;
			if(DFS(next)) continue;
			if(graph[n].early) continue;
			graph[n].early = true;
			count++;
		}
		
		return graph[n].early;
	}
	
	public static class Node implements Comparable<Node>{
		int n;
		boolean visited, early;
		ArrayList<Integer> list = new ArrayList<>();
		
		public Node(int n) {
			this.n = n;
		}
		
		@Override
		public int compareTo(Node o) {
			return o.list.size() - this.list.size();
		}
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