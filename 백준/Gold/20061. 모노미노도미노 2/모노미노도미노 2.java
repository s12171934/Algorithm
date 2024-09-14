import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int board[][] = new int[2][6], score;

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static void solve(int block, int x, int y) {
		drop(0, x, x + block / 3, block / 2 + 1);
		drop(1, y, y + (block + 1) % 2, block / 2 + 1);
	}

	static void drop(int type, int s, int e, int num) {
		if (s != e) num = 1;
		s = 1 << s | 1 << e;
		for (int i = 1; i < 6; i++) {
			if (i != 5 && (board[type][i + 1] & s) == 0) continue;
			board[type][i] |= s;
			if (num == 2) board[type][i - 1] |= s;
			break;
		}
		for (int i = 5; i > 0; i--) {
			if (board[type][i] == 15) {
				score++;
				i++;
				for (int j = i - 1; j > 0; j--) {
					board[type][j] = board[type][j - 1];
					board[type][j - 1] = 0;
				}
			}
		}
		int del = 0;
		if (board[type][1] != 0) del = 1;
		if (board[type][0] != 0) del = 2;
		for (int i = 5; i >= 2; i--) board[type][i] = board[type][i - del];
		for (int i = 0; i < 2; i++) board[type][i] = 0;
	}

	static int count() {
		int sum = 0;
		for (int i = 2; i <= 5; i++) sum += Integer.bitCount(board[0][i]) + Integer.bitCount(board[1][i]);
		return sum;
	}

	public static void main(String[] args) throws Exception {
		int N = read(); while (N-- > 0) {
			solve(read(), read(), read());
		}
		System.out.println(score + "\n" + count());
	}
}