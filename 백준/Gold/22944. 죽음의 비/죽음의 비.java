import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] deltas = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static int N, D;
	
	public static void main(String[] args) throws IOException {
		N = read();
		int H = read();
		D = read();
		Node[][] matrix = new Node[N][N];
		
		Queue<Node> q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < N; j ++) {
				matrix[i][j] = new Node(i, j, 0, 0, arr[j]);
				if (matrix[i][j].c == 'S') {
					matrix[i][j].hp = H;
					matrix[i][j].visited = true;
					q.add(matrix[i][j]);
				}
			}
		}
	
		while (!q.isEmpty()) {
			Node node = q.poll();
			
			if (node.c == 'E') {
				System.out.println(node.t);
				return;
			}
			
			if (node.hp == 0) continue;
			
			for (int[] d : deltas) {
				int x = node.x + d[0];
				int y = node.y + d[1];
				if (x < 0 || y < 0 || x >= N || y >= N) continue;
				if (matrix[x][y].visited) {
					if(node.hp + node.u - 1 > matrix[x][y].hp + matrix[x][y].u) {
						matrix[x][y].hp = node.hp;
						matrix[x][y].u = node.u;
						if(matrix[x][y].u == 0) {
							matrix[x][y].hp--;
						}
						else {
							matrix[x][y].u--;
						}
						matrix[x][y].t = node.t + 1;
						q.add(matrix[x][y]);
					}
					continue;
				}
				matrix[x][y].visited = true;
				matrix[x][y].hp = node.hp;
				matrix[x][y].u = node.u;
				if(matrix[x][y].c == 'U') {
					matrix[x][y].u = D;
				}
				if(matrix[x][y].u == 0) {
					matrix[x][y].hp--;
				}
				else {
					matrix[x][y].u--;
				}
				matrix[x][y].t = node.t + 1;
				q.add(matrix[x][y]);
			}
		}
		
		System.out.println(-1);
	}
	
	static class Node {
		int x,y,hp,u,t,c;
		boolean visited;
		
		Node (int x, int y, int hp, int t, int c) {
			this.x = x;
			this.y = y;
			this.hp = hp;
			this.t = t;
			this.c = c;
		}
	}
	
	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}