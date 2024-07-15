import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int n;
	public static ArrayList<ArrayList<Integer>> graph;
	
	
	public static void main(String[] args) throws IOException {
		n = readInt();
		int m = readInt();
		
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			int n1 = readInt();
			int n2 = readInt();
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		boolean exist = false;
		
		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[n + 1];
			if(DFS(i,1,visited)) {
				exist = true;
				break;
			}
		}
		
		System.out.println(exist ? 1 : 0);	
	}
	
	public static boolean DFS(int n1, int depth, boolean[] visited) {
		boolean[] newVisited = visited.clone();
		boolean ans = depth == 5;
		if (newVisited[n1]) return false;
		if (ans) return ans;
		newVisited[n1] = true;
		
		for (int n2 : graph.get(n1)) {
			ans = ans || DFS(n2, depth + 1, newVisited);
		}
		
		
		return ans;
	}
	
	public static int readInt() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 32 || r == 10) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}

}
