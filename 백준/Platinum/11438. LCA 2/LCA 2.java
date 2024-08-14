import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int MAX_DEPTH;
	
	public static void main(String[] args) throws IOException {
		int N = read();
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < N - 1; i++) {
			int n1 = read();
			int n2 = read();
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		int[][] matrix = new int[N + 1][2];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		Arrays.fill(matrix[1], 1);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			MAX_DEPTH = matrix[cur][1];
			for (int next : graph[cur]) {
				if(matrix[next][1] != 0) continue;
				matrix[next][0] = cur;
				matrix[next][1] = matrix[cur][1] + 1;
				q.add(next);
			}
		}
		
		int rowNum = 0;
		while ((1 << rowNum++) < MAX_DEPTH) {};
		int[][] sparseTable = new int[rowNum][N + 1];
		for (int i = 1; i <= N; i++) {
			sparseTable[0][i] = matrix[i][0]; 
		}
		for (int j = 1; j < rowNum; j++) {
			for (int i = 1; i <= N; i++) {
				sparseTable[j][i] = sparseTable[j - 1][sparseTable[j - 1][i]];
			}
		}
		
		int M = read();
		
		for (int i = 0; i < M; i++) {
			int n1 = read();
			int n2 = read();
			if (matrix[n1][1] < matrix[n2][1]) {
				int temp = n1;
				n1 = n2;
				n2 = temp;
			}
			if (matrix[n1][1] > matrix[n2][1]) {
				int diff = matrix[n1][1] - matrix[n2][1];
				for(int j = 0; j <= rowNum; j++) {
					if((diff & (1 << j)) == 0) continue;
					n1 = sparseTable[j][n1];
				}
			}
			
			if(n1 == n2) {
				System.out.println(n1);
				continue;
			}
			int depth = 0;
			while(sparseTable[0][n1] != sparseTable[0][n2]) {
				if(sparseTable[depth + 1][n1] == sparseTable[depth + 1][n2]) {
					n1 = sparseTable[depth][n1];
					n2 = sparseTable[depth][n2];
					depth = 0;
					continue;
				}
				depth++;
			}
			System.out.println(sparseTable[0][n1]);
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
