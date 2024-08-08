import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int r = read();
		int c = read();
		int k = read();
		int[][] matrix = new int[101][101];
		int lenR = 3;
		int lenC = 3;
		for (int i = 1; i <= lenR; i++) {
			for (int j = 1; j <= lenC; j++) {
				matrix[i][j] = read();
			}
		}
		
		if (matrix[r][c] == k) {
			System.out.println(0);
			return;
		}
		
		for (int t = 1; t <= 100; t++) {
			if (lenR >= lenC) {
				//sort row
				int newLenC = 0;
				for (int i = 1; i <= lenR; i++) {
					Map<Integer,Integer> map = new HashMap<>();
					for (int j = 1; j <= lenC; j++) {
						if (matrix[i][j] == 0) continue;
						map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
					}
					List<Integer> keyset = new ArrayList<>(map.keySet());
					keyset.sort((n1,n2) -> {
						if (map.get(n1) == map.get(n2)) {
							return n1 - n2;
						}
						return map.get(n1) - map.get(n2);
					});
					int idx = 1;
					newLenC = Math.max(newLenC, keyset.size() * 2);
					for (int key : keyset) {
						matrix[i][idx++] = key;
						matrix[i][idx++] = map.get(key);
					}
					for (int j = idx; j <= lenC; j++) {
						matrix[i][j] = 0;
					}
				}
				lenC = newLenC;
			}
			else {
				//sort col
				int newLenR = 0;
				for (int i = 1; i <= lenC; i++) {
					Map<Integer,Integer> map = new HashMap<>();
					for (int j = 1; j <= lenR; j++) {
						if (matrix[j][i] == 0) continue;
						map.put(matrix[j][i], map.getOrDefault(matrix[j][i], 0) + 1);
					}
					List<Integer> keyset = new ArrayList<>(map.keySet());
					keyset.sort((n1,n2) -> {
						if (map.get(n1) == map.get(n2)) {
							return n1 - n2;
						}
						return map.get(n1) - map.get(n2);
					});
					int idx = 1;
					newLenR = Math.max(newLenR, keyset.size() * 2);
					for (int key : keyset) {
						matrix[idx++][i] = key;
						matrix[idx++][i] = map.get(key);
					}
					for (int j = idx; j <= lenC; j++) {
						matrix[j][i] = 0;
					}
				}
				lenR = newLenR;
			}
			
			if (matrix[r][c] == k) {
				System.out.println(t);
				return;
			}
		}
		
		System.out.println(-1);
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
