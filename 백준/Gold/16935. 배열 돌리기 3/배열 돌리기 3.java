import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] matrix;
	
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int M = read();
		int R = read();
		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = read();
			}
		}
		Deque<Integer> orders = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			int order = read();
			if(orders.isEmpty()) {
				orders.addLast(order);
				continue;
			}
			if(((order == 1 || order == 2) ? (orders.getLast() == order) : ((orders.getLast() - 1) / 2 == (order -1) / 2 && orders.getLast() != order))) orders.pollLast();
			else orders.addLast(order);
		}
		while (!orders.isEmpty()) {
			int[][] before = new int[matrix.length][matrix[0].length];
			for (int i = 0; i < matrix.length; i++) {
				before[i] = matrix[i].clone();
			}
			switch(orders.pollFirst()) {
			case 1:
				spin1(before);
				break;
			case 2:
				spin2(before);
				break;
			case 3:
				spin3(before);
				break;
			case 4:
				spin4(before);
				break;
			case 5:
				spin5(before);
				break;
			case 6:
				spin6(before);
				break;
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				res.append(matrix[i][j]).append(" ");
			}
			res.append("\n");
		}
		System.out.println(res.toString());
	}
	
	static void spin1(int[][] before) {
		matrix = new int[before.length][before[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = before[matrix.length - 1 - i][j];
			}
		}
	}
	
	static void spin2(int[][] before) {
		matrix = new int[before.length][before[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = before[i][matrix[0].length - 1 - j];
			}
		}
	}
	
	static void spin3(int[][] before) {
		matrix = new int[before[0].length][before.length];
		for (int i = 0; i < before.length; i++) {
			for (int j = 0; j < before[1].length; j++) {
				matrix[j][before.length - 1 - i] = before[i][j];
			}
		}
	}
	
	static void spin4(int[][] before) {
		matrix = new int[before[0].length][before.length];
		for (int i = 0; i < before.length; i++) {
			for (int j = 0; j < before[0].length; j++) {
				matrix[before[0].length - 1- j][i] = before[i][j];
			}
		}
	}
	
	static void spin5(int[][] before) {
		matrix = new int[before.length][before[0].length];
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				matrix[i][j + matrix[0].length / 2] = before[i][j];
			}
		}
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = matrix[0].length / 2; j < matrix[0].length; j++) {
				matrix[i + matrix.length / 2][j] = before[i][j];
			}
		}
		for (int i = matrix.length / 2; i < matrix.length; i++) {
			for (int j = matrix[0].length / 2; j < matrix[0].length; j++) {
				matrix[i][j - matrix[0].length / 2] = before[i][j];
			}
		}
		for (int i = matrix.length / 2; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				matrix[i - matrix.length / 2][j] = before[i][j];
			}
		}
	}
	
	static void spin6(int[][] before) {
		matrix = new int[before.length][before[0].length];
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				matrix[i + matrix.length / 2][j] = before[i][j];
			}
		}
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = matrix[0].length / 2; j < matrix[0].length; j++) {
				matrix[i][j - matrix[0].length / 2] = before[i][j];
			}
		}
		for (int i = matrix.length / 2; i < matrix.length; i++) {
			for (int j = matrix[0].length / 2; j < matrix[0].length; j++) {
				matrix[i - matrix.length / 2][j] = before[i][j];
			}
		}
		for (int i = matrix.length / 2; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				matrix[i][j + matrix[0].length / 2] = before[i][j];
			}
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
