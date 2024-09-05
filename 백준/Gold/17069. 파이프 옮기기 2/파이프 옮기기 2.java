import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
    public static void main(String[] args) throws Exception {
        int n = read();
        long[][][] matrix = new long[n + 1][n + 1][4];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (read() == 1) {
                    matrix[i][j][0] = 1;
                }
            }
        }

        matrix[1][2][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {
                if (matrix[i][j][0] == 0) {
                    matrix[i][j][1] = matrix[i][j - 1][1] + matrix[i][j - 1][2];
                    matrix[i][j][3] = matrix[i - 1][j][2] + matrix[i - 1][j][3];
                    if (matrix[i][j - 1][0] == 0 && matrix[i - 1][j][0] == 0) {
                        matrix[i][j][2] = matrix[i - 1][j - 1][1] + matrix[i - 1][j - 1][2] + matrix[i - 1][j - 1][3];
                    }

                }
            }
        }

        System.out.println(matrix[n][n][1] + matrix[n][n][2] + matrix[n][n][3]);

    }
}
