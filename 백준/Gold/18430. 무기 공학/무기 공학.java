import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static ArrayList<Weapon> weapons = new ArrayList<>();
	static int N,M,max;
	
	public static void main(String[] args) throws IOException {
		N = read();
		M = read();
 		
 		if (N == 1 || M == 1) {
 			System.out.println(0);
 			return;
 		}
 		
 		int[][] matrix = new int[N][M];
 		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = read();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 1; k < 5; k++) {
					int[] d1 = deltas[k - 1];
					int[] d2 = deltas[k % 4];
					if(i + d1[0] < 0 || i + d1[0] >= N || j + d1[1] < 0 || j + d1[1] >= M) continue;
					if(i + d2[0] < 0 || i + d2[0] >= N || j + d2[1] < 0 || j + d2[1] >= M) continue;
					weapons.add(
							new Weapon(
									matrix[i][j] * 2 + matrix[i + d1[0]][j + d1[1]] + matrix[i + d2[0]][j + d2[1]], 
									(1 << (M * i + j)) + (1 << (M * (i + d1[0]) + j + d1[1])) +  + (1 << (M * (i + d2[0]) + j + d2[1]))
									)
							);
				}
			}
		}
		
		DFS(0, 0, 0);
		
		System.out.println(max);
	}
	
	static void DFS(int sum, int n, int check) {
		if(n == weapons.size()) {
			max = Math.max(max, sum);
			return;
		}
		
		DFS(sum, n + 1, check);
		if((check & weapons.get(n).check) == 0) DFS(sum + weapons.get(n).weight, n + 1, check | weapons.get(n).check);
	}
	
	static class Weapon {
		int weight, check;
		
		Weapon(int weight, int check) {
			this.weight = weight;
			this.check = check;
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
