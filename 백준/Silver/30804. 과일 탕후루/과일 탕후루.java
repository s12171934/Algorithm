import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		int ans = 0;
		
		int n = readInt();
		int[] nums = new int[n];
		int[] check = new int[11];
		Arrays.fill(check, -1);
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int num = readInt();
			nums[i] = num;
			if (check[num] == -1) {
				list.add(new int[] {num,i,i});
				check[num] = list.size() - 1;
			}
			else {
				if (list.get(check[num])[2] < i) list.get(check[num])[2] = i;
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int min = Math.min(list.get(i)[1], list.get(j)[1]);
				int max = Math.max(list.get(i)[2], list.get(j)[2]);
				int count = 0;
				int len = 0;
				for (int k = min; k <= max; k++) {
					if (nums[k] == list.get(i)[0] || nums[k] == list.get(j)[0]) {
						count++;
					}
					else {
						len = Math.max(len, count);
						count = 0;
					}
				}
				len = Math.max(len, count);
				ans = Math.max(ans, len);
			}
		}
		
		if (list.size() <= 2) ans = n;
		
		System.out.println(ans);
		br.close();
	}
	
	public static int readInt() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 32 || r == 10) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}