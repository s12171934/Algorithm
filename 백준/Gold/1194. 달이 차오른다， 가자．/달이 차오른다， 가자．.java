import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int M = read();
		char[][] map = new char[N][M];
		boolean[][][] visited = new boolean[N][M][1 << 6];
		Queue<Node> q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					q.add(new Node(i,j,0,0));
				}
			}
		}
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if (map[cur.x][cur.y] == '1') {
				System.out.println(cur.time);
				return;
			}
			
			for (int[] d : deltas) {
				int x = cur.x + d[0];
				int y = cur.y + d[1];
				
				if(x < 0 || y < 0 || x >= N || y >= M) continue;
				if(map[x][y] == '#') continue;
				if(map[x][y] >= 'A' && map[x][y] <= 'F') {
					if((cur.key & (1 << (map[x][y] - 65))) == 0) continue;
				}
				if(visited[x][y][cur.key]) continue;
				visited[x][y][cur.key] = true;
				
				int newKey = cur.key;
				if(map[x][y] >= 'a' && map[x][y] <= 'f') {
					newKey = cur.key | (1 << (map[x][y] - 97));
				}
				
				q.add(new Node(x,y,newKey,cur.time + 1));
			}
		}
		
		System.out.println(-1);
	}
	
	static class Node {
		int x, y, key, time;
		
		Node (int x, int y, int key, int time) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.time = time;
		}
	}
	
	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}