import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] bishop = {{1,1},{1,-1},{-1,-1},{-1,1}};
	
	static ArrayList<int[]> list;
	static int N, max;
	  
	public static void main(String[] args) throws IOException {
		N = read();
		ArrayList<int[]>[] lists = new ArrayList[2];
		lists[0] = new ArrayList<>();
		lists[1] = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (read() == 1) lists[(i + j) % 2].add(new int[] {i,j});
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 2; i++) {
			max = 0;
			list = lists[i];
			DFS(0,0,new int[N]);
			sum += max;
		}
		
		System.out.println(sum);
	}
	
	static void DFS(int idx, int count, int[] matrix) {
		if(idx == list.size()) {
			max = Math.max(max, count);
			return;
		}
		
		int[] cur = list.get(idx);
		
		boolean isAble = true;
		check : for (int[] d : bishop) {
			int x = cur[0];
			int y = cur[1];
			
			while (true) {
				x += d[0];
				y += d[1];
				if (x < 0 || y < 0 || x >= N || y >= N) break;
				if ((matrix[x] & (1 << y)) != 0) {
					isAble = false;
					break check;
				}
			}
		}
		
		DFS(idx + 1, count, matrix);
		if(isAble) {
			int[] newMatrix = matrix.clone();
			newMatrix[cur[0]] += 1 << cur[1];
			DFS(idx + 1, count + 1, newMatrix);
		}
	}
	
	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32)
				return res;
			if (r == 13)
				continue;
			res = 10 * res + (r - 48);
		}
	}
}
