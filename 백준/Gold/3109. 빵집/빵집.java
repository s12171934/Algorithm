import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R, C;
	static char[][] matrix;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int cnt = 0;
		matrix = new char[R + 2][];
		matrix[0] =  new char[C];
		matrix[R + 1] =  new char[C];
		Arrays.fill(matrix[0], 'x');
		Arrays.fill(matrix[R + 1], 'x');
		for (int i = 1; i <= R; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		for (int i = 1; i <= R; i++) {
			if(DFS(i,0)) cnt++;
		}
		System.out.println(cnt);
	}
	
	static boolean DFS(int r, int c) {
		matrix[r][c] = 'x';
		if(r == 0 || r == R + 1) return false;
		if(c == C -1) return true;
		if((matrix[r  - 1][c + 1] != 'x' && DFS(r - 1, c + 1))) {
			return true;
		}
		if((matrix[r][c + 1] != 'x' && DFS(r, c + 1))) {
			return true;
		}
		if((matrix[r + 1][c + 1] != 'x' && DFS(r + 1, c + 1))) {
			return true;
		}
		return false;
	}
}
