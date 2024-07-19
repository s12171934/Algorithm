import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static Node[] hackLen;
	public static boolean[] childs;
	public static boolean[] cycleVisited;
	public static int N, M;
	public static int max = 0;
	
	public static void main(String[] args) throws IOException {
		N = read();
		M = read();
		
		hackLen = new Node[N + 1];
		for (int i = 0; i <= N; i++) hackLen[i] = new Node(0);
		childs = new boolean[N + 1];
		
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			int A = read();
			int B = read();
			graph.get(B).add(A);
		}
		
		for (int i = 1; i <= N; i++) {
			if (childs[i]) continue;
			boolean checkCycle = false;
			
			boolean[] visited = new boolean[N + 1];
			visited[i] = true;
			
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			
			while(!q.isEmpty()) {
				int n = q.poll();
				
				for (int child : graph.get(n)) {
					if (child == i) checkCycle = true;
					if (visited[child]) continue;
					visited[child] = true;
					childs[child] = true;
					hackLen[i].x++;
					q.add(child);
				}
			}
			
			if(checkCycle) {
				cycleVisited = new boolean[N + 1];
				checkCycle(i,i);
			}
			
			max = Math.max(max, hackLen[i].x);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if(hackLen[i].x == max) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}
	
	public static class Node{
		int x;
		
		public Node(int x) {
			this.x = x;
		}
	}
	
	public static boolean checkCycle(int start, int now) {
		boolean check = false;
		cycleVisited[now] = true;
		
		for (int next : graph.get(now)) {
			if (cycleVisited[next]) {
				hackLen[now] = hackLen[next];
				check = true;
			}
			else {
				check = checkCycle(start, next) | check;
			}
		}
		
		if(check) {
			hackLen[now] = hackLen[start];
		}
		
		return check;
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
