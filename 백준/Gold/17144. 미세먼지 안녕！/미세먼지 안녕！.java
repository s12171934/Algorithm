import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int R,C,rc;
	
	public static void main(String[] args) throws IOException {
		R = read();
		C = read();
		int T = read();
		
		ArrayList<LinkedList<Integer>> matrix = new ArrayList<>();
		for (int i = 0; i < R + 4; i++) {
			matrix.add(new LinkedList<>());
		}
		
		int condition = 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int num = read();
				if (num == -1) {
					rc = i;
					condition--;
					continue;
				}
				
				int deque = i;
				
				if (j == 0 || j == C - 1) {
					deque = R;
					deque += j == 0 ? 0 : 2;
					deque += condition == 0 ? 1 : 0;
				}
				
				matrix.get(deque).add(num);
			}
		}
		
		for (int t = 0; t < T; t++) {
			matrix = spreadDust(matrix);
			
			matrix.get(0).addLast(matrix.get(R + 2).pollFirst());
			matrix.get(R + 2).addLast(matrix.get(rc - 1).pollLast());
			matrix.get(rc - 1).addFirst(0);
			matrix.get(R).addFirst(matrix.get(0).pollFirst());
			matrix.get(R).pollLast();
			
			matrix.get(R - 1).addLast(matrix.get(R + 3).pollLast());
			matrix.get(R + 3).addFirst(matrix.get(rc).pollLast());
			matrix.get(rc).addFirst(0);
			matrix.get(R + 1).addLast(matrix.get(R - 1).pollFirst());
			matrix.get(R + 1).pollFirst();		
		}
		
		int sum = 0;
		for (LinkedList<Integer> list : matrix) {
			for(int dust : list) {
				sum += dust;
			}
		}
		System.out.println(sum);
	}
	
	public static ArrayList<LinkedList<Integer>> spreadDust(ArrayList<LinkedList<Integer>> matrix) {
		ArrayList<LinkedList<Integer>> newMatrix = new ArrayList<>();
		for (int i = 0; i < matrix.size(); i++) {
			newMatrix.add(new LinkedList<>());
			for (int j = 0; j < matrix.get(i).size(); j++) {
				newMatrix.get(i).add(0);
			}
		}
		int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
		for (int i = 0; i < R; i++) {
			for(int j = 0; j < C - 2; j++) {
				int dust = matrix.get(i).get(j);
				int spread = dust / 5;
				int count = 0;
				for (int[] d : deltas) {
					int x = i + d[0];
					int y = j + d[1];
					
					if (x < 0 || x >= R) continue;
					if (y == -1) {
						if (x < rc - 1) {
							newMatrix.get(R).set(x, newMatrix.get(R).get(x) + spread);
						}
						else if (x > rc) {
							newMatrix.get(R + 1).set(x - rc - 1, newMatrix.get(R + 1).get(x - rc - 1) + spread);
						}
						else {
							count--;
						}
					}
					else if (y == C - 2) {
						if (x <= rc - 1) {
							newMatrix.get(R + 2).set(x, newMatrix.get(R + 2).get(x) + spread);
						}
						else if (x >= rc) {
							newMatrix.get(R + 3).set(x - rc, newMatrix.get(R + 3).get(x - rc) + spread);
						}
						
					}
					else {
						newMatrix.get(x).set(y, newMatrix.get(x).get(y) + spread);
					}
					count++;
				}
				newMatrix.get(i).set(j, newMatrix.get(i).get(j) + dust - count * spread);
			}
		}
		
		for (int i = 0; i < 4; i ++) {
			for(int j = 0; j < matrix.get(R + i).size(); j++) {
				int dust = matrix.get(R + i).get(j);
				int spread = dust / 5;
				int count = 0;
				
				int row = j + (i % 2 == 1 ? (i == 1 ? rc + 1 : rc) : 0);
				int col = i >= 2 ? C - 3 : 0;
				newMatrix.get(row).set(col, newMatrix.get(row).get(col) + spread);
				count++;
				
				for (int d : new int[] {-1, 1}) {
					int x = j + d;
					if (x < 0 || x >= matrix.get(R + i).size()) continue;
					newMatrix.get(R + i).set(x, newMatrix.get(R + i).get(x) + spread);
					count++;
				}
				
				if (j == matrix.get(R+2).size() - 1 && i == 2) {
					count++;
					newMatrix.get(R + 3).set(0, newMatrix.get(R + 3).get(0) + spread);
				}
				if (j == 0 && i == 3) {
					count++;
					newMatrix.get(R + 2).set(rc - 1, newMatrix.get(R + 2).get(rc - 1) + spread);
				}
				
				newMatrix.get(R + i).set(j, newMatrix.get(R + i).get(j) + dust - count * spread);
			}
		}
		return newMatrix;
	}
	
	public static int read() throws IOException {
		int res = 0;
		int mode = 1;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			if (r == 45) {
				mode = -1;
				continue;
			}
			res = 10 * res + mode * (r - 48);
		}
	}
}