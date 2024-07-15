import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static char[][] matrix;
	public static int R,C;
	
	public static void main(String[] args) throws IOException {
		R = read();
		C = read();
		
		matrix = new char[R][C];
		for (int i = 0; i < R; i++) matrix[i] = br.readLine().toCharArray();
		
		boolean[] used = new boolean[26];
		System.out.println(DFS(0, 0, 1, used));
	}
	
	public static int DFS(int x, int y, int depth, boolean[] used) {
		int alphabet = matrix[x][y] - 65;
		boolean[] newUsed = used.clone();
		newUsed[alphabet] = true;
		
		int max = depth;
		
		for(int[] dist : new int[][]{{1,0},{-1,0},{0,1},{0,-1}}) {
			int nx = x + dist[0];
			int ny = y + dist[1];
			
			if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			int newAlphabet = matrix[nx][ny] - 65;
			if (newUsed[newAlphabet]) continue;
			max = Math.max(DFS(nx, ny, depth + 1, newUsed), max);
		}	
		return max;
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