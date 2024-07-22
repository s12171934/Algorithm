import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		ArrayList<Integer>[][] matrix = new ArrayList[101][2];
		for (int i = 0; i <= 100; i++) {
			matrix[i][0] = new ArrayList<>();
			matrix[i][1] = new ArrayList<>();
		}
		
		int N = read();
		for (int i = 0; i < N; i++) matrix[read()][0].add(i);
		
		int M = read();
		for (int i = 0; i < M; i++) matrix[read()][1].add(i);
		
		int pointer = 100;
		int pa = -1;
		int pb = -1;
		int len = 0;
		StringBuilder sb = new StringBuilder();
		while (pointer > 0) {
			matrix[pointer][0].sort((n1, n2) -> n2 - n1);
			matrix[pointer][1].sort((n1, n2) -> n2 - n1);
			
			int sizeA = 0;
			int sizeB = 0;
			
			for (int i = 0; i < matrix[pointer][0].size(); i++) {
				if (matrix[pointer][0].get(i) > pa) {
					sizeA++;
				}
				else {
					break;
				}
			}
			
			for (int i = 0; i < matrix[pointer][1].size(); i++) {
				if (matrix[pointer][1].get(i) > pb) {
					sizeB++;
				}
				else {
					break;
				}
			}
			
			if (sizeA == 0 || sizeB == 0) {
				pointer--;
				continue;
			}
			
			int size = Math.min(sizeA, sizeB);
			pa = matrix[pointer][0].get(sizeA - size);
			pb = matrix[pointer][1].get(sizeB - size);
			
			len += size;
			for (int i = 0; i < size; i++) {
				sb.append(pointer).append(" ");
			}
			pointer--;
		}
		
		System.out.println(len);
		System.out.println(sb);
		
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}