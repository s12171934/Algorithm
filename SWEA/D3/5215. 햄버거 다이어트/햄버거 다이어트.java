import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	static int N, list[];

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				matrix[i][0] = Integer.parseInt(st.nextToken());
				matrix[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) {
				list = new int[N];
				Arrays.fill(list, N - i, N, 1);
				
				while(true) {
					int val = 0;
					int cal = 0;
					
					for(int j = 0; j < N; j++) {
						val += list[j] * matrix[j][0];
						cal += list[j] * matrix[j][1];
					}
					
					if(cal <= L) ans = Math.max(ans, val);
					if(!np()) break;
				}
			}
			
			res.append(String.format("#%d %d\n", tc, ans));
		}
		System.out.println(res.toString());
	}
	
	static boolean np() {
		int pivot = N - 2;
		while(pivot >= 0 && list[pivot] >= list[pivot + 1]) pivot--;
		if(pivot < 0) return false;
		int pointer = N - 1;
		while(list[pointer] == 0) pointer--;
		list[pivot] = 1;
		list[pointer] = 0;
		for (int i = 1; i <= (N - 1 - pivot) / 2; i++) {
			int temp = list[pivot + i];
			list[pivot + i] = list[N - i];
			list[N - i] = temp;
		}
		return true;
	}
}
