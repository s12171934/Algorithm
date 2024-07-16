import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> list = input();
		int[][][] dp = new int[list.size() + 1][5][5];
		dp[0][0][0] = 1;
		
		for (int i = 1; i <= list.size(); i++) {
			int target = list.get(i - 1);
			for (int j = 0; j <= 4; j++) {
				if (target == j) continue;
				for (int k = 0; k <= 4; k++) {
					if (dp[i - 1][j][k] == 0) continue;
					int d = Math.abs(target - k);
					int temp = dp[i - 1][j][k];
					if (k == 0) {
						temp += 2;
					}
					else {
						if (d == 0) {
							temp += 1; 
						}
						else if (d == 2) {
							temp += 4;
						}
						else {
							temp += 3;
						}
					}
					
					if (dp[i][j][target] == 0) {
						dp[i][j][target] = temp;
					}
					dp[i][j][target] = Math.min(dp[i][j][target], temp);
					dp[i][target][j] = dp[i][j][target];
 				}
			}
		}
		
		int min = 500_000;
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) {
				if(dp[list.size()][i][j] != 0) {
					min = Math.min(min, dp[list.size()][i][j]);
				}
			}
		}
		
		System.out.println(min - 1);
	}
	
	public static ArrayList<Integer> input() throws IOException {
		ArrayList<Integer> list = new ArrayList<>();
		while (true) {
			int num = read();
			if (num == 0) return list;
			list.add(num);
		}
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 32 || r == 10) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}
