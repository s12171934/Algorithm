import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int R = read();
		int C = read();
		int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
		char[][] matrix = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R; i++) matrix[i] = br.readLine().toCharArray();
		
		Queue<Node> q = new LinkedList<>();
		Queue<Node> fires = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(matrix[i][j] == 'J') {
					q.add(new Node(i,j,0));
					visited[i][j] = true;
				}
				if(matrix[i][j] == 'F') {
					fires.add(new Node(i,j,0));
				}
			}
		}
		
		int fireTime = 1;
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.t >= fireTime) {
				int fireLen = fires.size();
				for (int i = 0; i < fireLen; i++) {
					Node fire = fires.poll();
					
					for (int[] d : deltas) {
						int x = fire.x + d[0];
						int y = fire.y + d[1];
						if (x < 0 || x >= R || y < 0 || y >= C) continue;
						if (matrix[x][y] == '#') continue;
						if (visited[x][y] && matrix[x][y] == 'F') continue;
						visited[x][y] = true;
						matrix[x][y] = 'F';
						fires.add(new Node(x,y,0));
					}
				}
				fireTime++;
			}
			
			if(matrix[node.x][node.y] == 'F') continue;
			
			for (int[] d : deltas) {
				int x = node.x + d[0];
				int y = node.y + d[1];
				if (x < 0 || x >= R || y < 0 || y >= C) {
					System.out.println(node.t + 1);
					return;
				}
				if (matrix[x][y] == 'F' || matrix[x][y] == '#') continue;
				if (visited[x][y]) continue;
				visited[x][y] = true;
				q.add(new Node(x,y,node.t + 1));
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}
	
	public static class Node{
		int x,y,t;
		public Node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 32 || r == 10) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}
