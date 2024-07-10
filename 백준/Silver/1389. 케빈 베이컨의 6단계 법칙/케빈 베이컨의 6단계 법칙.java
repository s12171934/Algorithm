import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		int n = readInt();
		int m = readInt();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < m; i++) {
			
			int node1 = readInt();
			int node2 = readInt();
			
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}
		
		int min = 10001;
		int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			int r = 0;
			boolean[] visited = new boolean[n + 1];
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {i,0});
			visited[i] = true;
			
			while (!queue.isEmpty()) {
				int[] n1 = queue.poll();
				r += n1[1];
				
				for (int n2 : graph.get(n1[0])) {
					if (visited[n2]) continue;
					visited[n2] = true;
					queue.add(new int[]{n2, n1[1] + 1});
				}
			}
			
			if (min > r) {
				min = r;
				answer = i;
			}
 		}
		
		System.out.println(answer);

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
