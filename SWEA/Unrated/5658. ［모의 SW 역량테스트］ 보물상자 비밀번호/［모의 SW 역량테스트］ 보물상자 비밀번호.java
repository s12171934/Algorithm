import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	static StringTokenizer st;
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		int TC = read();
		for (int tc = 1; tc <= TC; tc++) {
			int N = read(), K = read();
			Set<Integer> set = new HashSet<>();
			int[] nums = new int[4];
			String str = br.readLine();
			for (int i = 0; i < 4; i++) {
				nums[i] = Integer.parseInt(str.substring(i * (N / 4), (i + 1) * (N / 4)), 16);
				set.add(nums[i]);
			}
			
			
			for (int i = 0; i < N / 4; i++) {
				int next = nums[3] & 15;
				for (int j = 0; j < 4; j++) {
					int temp = nums[j] & 15;
					nums[j] = nums[j] >> 4 | next << ((N / 4 - 1) * 4);
					set.add(nums[j]);
					next = temp;
				}
			}
			
			Integer[] list = new Integer[set.size()];
			list = set.toArray(list);
			Arrays.sort(list, (n1, n2) -> n2 - n1);
			res.append(String.format("#%d %d\n", tc, list[K - 1]));
		}
		System.out.println(res.toString());
	}
}