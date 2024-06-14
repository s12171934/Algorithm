import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = read();
        int[] ans = new int[6];
        int[][] matrix = new int[n + 1][6];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                int grade = read();
                matrix[i][grade] = matrix[i - 1][grade] + 1;
                ans[grade] = Math.max(ans[grade], matrix[i][grade]);
            }
        }

        int maxGrade = 0;
        int max = 0;

        for (int i = 0; i < 6; i++) {
            if(max < ans[i]) {
                max = ans[i];
                maxGrade = i;
            }
        }

        System.out.println(max + " " + maxGrade);
    }

    public static int read() throws IOException {

        int res = 0;

        while (true) {
            int n = br.read();
            if (n == 32 || n == 10) return res;
            res = res * 10 + n - 48;
        }
    }
}