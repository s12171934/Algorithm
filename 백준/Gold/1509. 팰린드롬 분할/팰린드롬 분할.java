import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		char[] list = (0 + br.readLine()).toCharArray();
		int[] dp = new int[list.length];
		
		for (int i = 1; i < list.length; i++) {
			int s = 1;
			while (s < i) {
				if (list[s] != list[i]) {
					s++;
					continue;
				}
				int ms = s;
				int me = i;
				boolean palindrome = true;
				while (ms < me) {
					if(list[ms] == list[me]) {
						ms++;
						me--;
					}
					else {
						palindrome = false;
						break;
					}
				}
				if(palindrome) {
					if(dp[i] == 0) dp[i] = dp[s - 1] + 1;
					dp[i] = Math.min(dp[i], dp[s - 1] + 1);
				}
				s++;
			}
			if(dp[i] == 0) dp[i] = dp[i - 1] + 1;
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
		}
		
		System.out.println(dp[list.length - 1]);
	}
}
