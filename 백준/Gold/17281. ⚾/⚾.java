import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = read();
		int max = 0;
		int[][] matrix = new int[N][9];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 9; j++) {
				matrix[i][j] = read();
			}
		}
		int[][] permutation = new int[40320][9];
		permutation[0] = new int[] {0,1,2,3,4,5,6,7,8};
		for (int i = 1; i < permutation.length; i++) {
			permutation[i] = permutation[i -1].clone();
			int pivot = 7;
			for (; pivot >= 0; pivot--) {
				if(permutation[i][pivot] < permutation[i][pivot + 1]) break;
			}
			for (int j = 8; j > pivot; j--) {
				if(permutation[i][pivot] < permutation[i][j]) {
					int temp = permutation[i][pivot];
					permutation[i][pivot] = permutation[i][j];
					permutation[i][j] = temp;
					break;
				}
			}
			for (int j = 1; j <= (8 - pivot) / 2; j++) {
				int temp = permutation[i][pivot + j];
				permutation[i][pivot + j] = permutation[i][9 - j];
				permutation[i][9 - j] = temp;
			}
		}
		
		for (int[] set : permutation) {
			int score = 0;
			int cur = 1;
			for (int n = 0; n < N; n++) {
				int out = 3;
				boolean[] people = new boolean[3];
				while(out > 0) {
					int idx = 0;
					if(cur > 4) {
						idx =  cur - 1;
					}
					else if(cur < 4) {
						idx = cur;
					}
					switch (matrix[n][set[idx]]) {
					case 0: 
						out--;
						break;
					case 1:
						if(people[2]) score++;
						people[2] = people[1];
						people[1] = people[0];
						people[0] = true;
						break;
					case 2:
						if(people[2]) score++;
						if(people[1]) score++;
						people[2] = people[0];
						people[1] = true;
						people[0] = false;
						break;
					case 3:
						if(people[2]) score++;
						if(people[1]) score++;
						if(people[0]) score++;
						people[2] = true;
						people[1] = false;
						people[0] = false;
						break;
					case 4:
						score++;
						if(people[2]) score++;
						if(people[1]) score++;
						if(people[0]) score++;
						people[2] = false;
						people[1] = false;
						people[0] = false;
						break;
					}
					cur++;
					if(cur == 10) cur = 1;
				}
			}
			max = Math.max(max, score);
		}
		
		System.out.println(max);
	}
	
	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if(r == 10 || r == 32) return res;
			if(r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}
