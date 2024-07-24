import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int[] start = new int[N];
		for (int i = 0; i < N; i++) {
			start[i] = read();
		}
		int[] goal = start.clone();
		Arrays.sort(goal);
		
		int startInt = 0;
		int goalInt = 0;
		
		for (int i = 0; i < N; i++) {
			if(start[i] == 10) start[i] = 0;
			if(goal[i] == 10) goal[i] = 0;
			startInt += start[i] * Math.pow(10, i);
			goalInt += goal[i] * Math.pow(10, i);
		}
		
		int M = read();
		int[][] orders = new int[M][3];
		for (int i = 0; i < M; i++) {
			orders[i][0] = read();
			orders[i][1] = read();
			orders[i][2] = read();
		}
		
		boolean[] visited = new boolean[1_000_000_000];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startInt, 0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if(visited[node.list]) continue;
			visited[node.list] = true;
			
			if(node.list == goalInt) {
				System.out.println(node.weight);
				return;
			}
			
			for (int[] order : orders) {
				int newList = node.list;
				int a = (newList % (int)Math.pow(10, order[0])) / (int)Math.pow(10, order[0] - 1);
				int b = (newList % (int)Math.pow(10, order[1])) / (int)Math.pow(10, order[1] - 1);
				newList = newList - (a - b) * (int)(Math.pow(10, order[0] - 1) - Math.pow(10,  order[1] - 1));
				pq.add(new Node(newList, node.weight + order[2]));
			}	
		}
		
		System.out.println(-1);
	}
	
	public static class Node implements Comparable<Node>{
		int list;
		int weight;
		
		public Node(int list, int weight) {
			this.list = list;
			this.weight = weight;
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return list;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return this.list == ((Node)obj).list;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
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