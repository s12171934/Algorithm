import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int L = read();
		int R = read();
		
		int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
		
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = read();
			}
		}
		
		int count = 0;
		
		while (true) {
			ArrayList<ArrayList<Node>> union = new ArrayList<>();
			boolean finish = true;
			
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j]) continue;
					Queue<Node> q = new LinkedList<>();
					union.add(new ArrayList<>());
					
					Node start = new Node(i,j);
					q.add(start);
					union.get(union.size() - 1).add(start);
					visited[i][j] = true;
					
					while (!q.isEmpty()) {
						Node node = q.poll();
						
						for (int[] d : deltas) {
							int x = node.x + d[0];
							int y = node.y + d[1];
							if (x < 0 || x>= N || y < 0 || y >= N) continue;
							if (visited[x][y]) continue;
							int diff = Math.abs(matrix[node.x][node.y] - matrix[x][y]);
							if (diff < L || diff > R) continue;
							visited[x][y] = true;
							Node unionNode = new Node(x,y);
							q.add(unionNode);
							union.get(union.size() - 1).add(unionNode);
						}
					}	
				}
			}
			
			for (ArrayList<Node> nodes : union) {
				if (nodes.size() == 1) continue;
				finish = false;
				int sum = 0;
				for (Node node : nodes) {
					sum += matrix[node.x][node.y];
				}
				sum /= nodes.size();
				for (Node node : nodes) {
					matrix[node.x][node.y] = sum;
				}
			}
			
			if (finish) break;
			else count++;
		}
 		
		System.out.println(count);
	}
	
	public static class Node {
		int x,y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
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
