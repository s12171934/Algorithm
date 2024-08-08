import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, K;
	static int[][] A;
	static Node[][] matrix;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
	
	public static void main(String[] args) throws IOException {
		init();
		
		for (int k = 0; k < K; k++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		result(0);
	}
	
	static class Node {
		int food = 5;
		Deque<Integer> tree = new ArrayDeque<>();
		Deque<Integer> die = new ArrayDeque<>();
	}
	
	static void init() throws IOException {
		N = read();
		M = read();
		K = read();
		
		A = new int[N][N];
		matrix = new Node[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = read();
				matrix[i][j] = new Node();
			}
		}
		
		for (int i = 0; i < M; i++) {
			matrix[read() - 1][read() -1].tree.add(read());
		}
	}
	
	static void spring() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Node cur = matrix[i][j];
				int len = cur.tree.size();
				for (int n = 0; n < len; n++) {
					int age = cur.tree.pollFirst();
					if (cur.food < age) {
						cur.die.add(age);
						continue;
					}
					
					cur.food -= age;
					cur.tree.addLast(age + 1);
				}
			}
		}
	}
	
	static void summer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Node cur = matrix[i][j];
				while (!cur.die.isEmpty()) {
					cur.food += cur.die.poll() / 2;
				}
				cur.die.clear();
			}
		}
	}
	
	static void fall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int tree : matrix[i][j].tree) {
					if (tree % 5 != 0) continue;
					for (int[] d : deltas) {
						int x = i + d[0];
						int y = j + d[1];
						if (x < 0 || y < 0 || x >= N || y >= N) continue;
						matrix[x][y].tree.addFirst(1);
					}
				}
			}
		}
	}
	
	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j].food += A[i][j];
			}
		}
	}
	
	static void result(int cnt) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += matrix[i][j].tree.size();
			}
		}
		
		System.out.println(cnt);
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
