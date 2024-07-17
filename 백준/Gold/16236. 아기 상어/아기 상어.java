import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = read();
		Queue<Node> q = new LinkedList<>();
		
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = read();
				if (matrix[i][j] == 9) {
					q.add(new Node(i,j,2,2,0));
					matrix[i][j] = 0;
				}
			}
		}
		
		int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
		int ans = 0;
		
		while(!q.isEmpty()) {
			boolean[][] visited = new boolean[n][n];
			ArrayList<Node> canEat = new ArrayList<>();
			int limit = 400;
			
			while(!q.isEmpty()) {
				Node shark = q.poll();
				visited[shark.x][shark.y] = true;
				if(limit < shark.time) {
					q.clear();
					break;
				}
				
				for (int[] d : deltas) {
					int x = shark.x + d[0];
					int y = shark.y + d[1];
					if (x < 0 || x >= n || y < 0 || y >= n) continue;
					if (matrix[x][y] > shark.size) continue;
					if (visited[x][y]) continue;
					visited[x][y] = true;
					if (matrix[x][y] != 0 && matrix[x][y] < shark.size) {
						canEat.add(new Node(x,y,shark.size,shark.count - 1,shark.time + 1));
						limit = shark.time;
					}
					else {
						q.add(new Node(x,y,shark.size,shark.count,shark.time + 1));
					}
				}
			}
			
			if(canEat.size() != 0) {
				canEat.sort((n1, n2) -> {
					if (n1.x == n2.x) {
						return n1.y - n2.y;
					}
					else {
						return n1.x - n2.x;
					}
				});
				
				matrix[canEat.get(0).x][canEat.get(0).y] = 0;
				if (canEat.get(0).count == 0) {
					canEat.get(0).size += 1;
					canEat.get(0).count = canEat.get(0).size;
				}
				
				ans = canEat.get(0).time;
				q.add(canEat.get(0));
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static class Node {
		int x,y,size,count,time;
		public Node (int x, int y, int size, int count, int time) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.count = count;
			this.time = time;
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
