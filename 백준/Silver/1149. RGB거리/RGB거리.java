import java.io.*;
import java.util. *;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder res = new StringBuilder();
    static StringTokenizer st;
    
    static int read() throws Exception {
    	if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    	return Integer.parseInt(st.nextToken());
    }
     
    public static void main(String[] args) throws Exception {
        int N = read();
        int[][] dp = new int[2][3];
        for (int i = 1; i <= N; i++) {
        	for (int j = 0; j < 3; j++) dp[i % 2][j] = read() + Math.min(dp[(i + 1) % 2][(j + 1) % 3], dp[(i + 1) % 2][(j + 2) % 3]);
        }
        System.out.println(Math.min(Math.min(dp[N % 2][0], dp[N % 2][1]), dp[N % 2][2]));
    }
}
