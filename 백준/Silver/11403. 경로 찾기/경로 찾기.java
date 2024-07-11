import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		int n = readInt();
		StringBuilder sb = new StringBuilder();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
			for (int j = 0; j < n; j++) {
				if(readInt() == 1) {
					graph.get(i).add(j);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			int[] list = new int[n];
			Queue<Integer> queue = new LinkedList<>();
			queue.add(i);
			
			while (!queue.isEmpty()) {
				int node = queue.poll();
				
				for (int n1 : graph.get(node)) {
					if (list[n1] == 1) continue;
					list[n1] = 1;
					queue.add(n1);
				}
			}
			
			for (int l : list) {
				sb.append(l).append(" ");
			}
			sb.append("\n");
		}
	
		System.out.println(sb);
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
