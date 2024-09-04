public class Main {
	static int[] dp;
	public static void main(String[] args) {
		int N = new java.util.Scanner(System.in).nextInt();
		dp = new int[N + 1];
		for (int i = 2; i <= N; i++) dp[i] = calc(i);
		System.out.println(dp[N]);
	}
	static int calc(int n) {
		if (n == 1 || dp[n] != 0) return dp[n];
		if (n % 6 == 0) return Math.min(Math.min(calc(n / 3), calc(n / 2)), calc(n - 1)) + 1;
		if (n % 3 == 0) return Math.min(calc(n / 3), calc(n - 1)) + 1;
		if (n % 2 == 0) return Math.min(calc(n / 2), calc(n - 1)) + 1;
		return calc(n - 1) + 1;
	}
}
