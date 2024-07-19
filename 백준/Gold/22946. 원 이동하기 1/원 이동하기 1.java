import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static boolean[] visited;
	public static int s = 0;
	public static int maxD = 0;
	
	public static void main(String[] args) throws IOException {
		int N = read();
		long[][] circles = new long[N + 1][3];
		for (int i = 1; i <= N; i++) {
			circles[i] = new long[]{read(), read(), read()};
		}
		
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			matrix.add(new ArrayList<>());
		}
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				double len = Math.pow(circles[i][0] - circles[j][0], 2) + (long)Math.pow(circles[i][1] - circles[j][1], 2);
				if (circles[i][2] < circles[j][2]) {
					if (len > Math.pow(circles[j][2],2)) {
						matrix.get(i).add(0);
						matrix.get(j).add(0);
					}
					else {
						matrix.get(i).add(j);
					}
				}
				else {
					if (len > Math.pow(circles[i][2],2)) {
						matrix.get(i).add(0);
						matrix.get(j).add(0);
					}
					else {
						matrix.get(j).add(i);
					}
				}
			}
		}
		
		int[] parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j : matrix.get(i)) {
				if(parents[i] == 0) parents[i] = j;
				for(int k : matrix.get(j)) {
					if(k == parents[i]) {
						parents[i] = j;
						break;
					}
				}				
			}
		}
		
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		for (int i = 1; i <= N; i++) {
			graph.get(i).add(parents[i]);
			graph.get(parents[i]).add(i);
		}
		
		visited = new boolean[N + 1];
		DFS(0,0);
		visited = new boolean[N + 1];
		DFS(s,0);
		System.out.println(maxD);
	}
	
	public static void DFS(int circle, int depth) {
		if(visited[circle]) return;
		visited[circle] = true;
		if(depth > maxD) {
			s = circle;
			maxD = depth;
		}
		for (int next : graph.get(circle)) {
			DFS(next, depth + 1);
		}
	}
	
	public static int read() throws IOException {
		int res = 0;
		int mode = 1;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			if (r == 45) {
				mode = -1;
				continue;
			}
			res = 10 * res + mode * (r - 48);
		}
	}
}