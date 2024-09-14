import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M, S, shark, temp[][], deltas[] = {-1, -5, -4, -3, 1, 5, 4, 3}, sharkMove[] = {-4, -1, 4, 1};
	static Node[] matrix = new Node[16];

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static class Node{
		ArrayList<Integer> list = new ArrayList<>();
		int sum, left;

		void add(int d) {
			this.list.add(d);
			this.sum++;
		}

		void clear() {
			if (this.sum != 0) this.left = 2;
			this.list = new ArrayList<>();
			this.sum = 0;
		}

		int[] fishList() {
			int[] fishList = new int[this.sum];
			for (int i = 0; i < this.sum; i++) fishList[i] = this.list.get(i);
			return fishList;
		}
	}

	static void init() throws Exception {
		M = read(); S = read();
		for (int i = 0; i < 16; i++) matrix[i] = new Node();
		for (int i = 0; i < M; i++) matrix[(read() - 1) * 4 + read() - 1].add(read() - 1);
		shark = (read() - 1) * 4 + read() - 1;
	}

	static void solve() {
		cloneFish();
		matrix = moveFish();
		moveShark(howToMove());
		spell();
	}

	static void cloneFish() {
		temp = new int[16][];
		for (int i = 0; i < 16; i++) temp[i] = matrix[i].fishList();
	}

	static boolean move(int i, int next) {
		return next < 0 || next >= 16 || (next / 4 != i / 4 && next % 4 != i % 4);
	}

	static Node[] moveFish() {
		Node[] newMatrix = new Node[16];
		for (int i = 0; i < 16; i++) newMatrix[i] = new Node();
		for (int i = 0; i < 16; i++) {
			if (matrix[i].left != 0) newMatrix[i].left = matrix[i].left - 1;
			nextFish:
			for (int d : matrix[i].list) {
				int next = i + deltas[d], oriD = d;
				while (next < 0 || next >= 16
						|| (i % 4 == 0 && (d == 0 || d == 1 || d == 7))
						|| (i % 4 == 3 && (d == 3 || d == 4 || d == 5))
						|| next == shark || matrix[next].left != 0) {
					d = (d + 7) % 8;
					if (d == oriD) {
						newMatrix[i].add(oriD);
						continue nextFish;
					};
					next = i + deltas[d];
				}
				newMatrix[next].add(d);
			}
		}
		return newMatrix;
	}

	static int[] howToMove() {
		int move[] = new int[3], maxIdx[] = new int[3], max = -1;
		for (int i = 0; i < 4; i++) {
			if (move(shark, (move[0] = shark + sharkMove[i]))) continue;
			int first = matrix[move[0]].sum;
			for (int j = 0; j < 4; j++) {
				if (move(move[0], (move[1] = move[0] + sharkMove[j]))) continue;
				int second = matrix[move[1]].sum;
				for (int k = 0; k < 4; k++) {
					if (move(move[1], (move[2] = move[1] + sharkMove[k]))) continue;
					int third = matrix[move[2]].sum;
					if (move[0] == move[2]) third = 0;
					if (max >= first + second + third) continue;
					max = first + second + third;
					maxIdx = move.clone();
				}
			}
		}
		return maxIdx;
	}

	static void moveShark(int[] move) {
		for (int i = 0; i < 3; i++) {
			if((i == 0 && shark == move[0]) || (i != 0 && move[i - 1] == move[i])) continue;
			matrix[move[i]].clear();
		}
		shark = move[2];
	}

	static void spell() {
		for (int i = 0; i < 16; i++) {
			for (int j : temp[i]) matrix[i].add(j);
		}
	}

	static int sumFish() {
		int sum = 0;
		for (int i = 0; i < 16; i++) if (matrix[i] != null) sum += matrix[i].sum;
		return sum;
	}

	public static void main(String[] args) throws Exception {
		init();
		for (int i = 0; i < S; i++) solve();
		System.out.println(sumFish());
	}
}