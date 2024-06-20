import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = read();
        int[][] arr = new int[4][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                arr[j][i] = read();
            }
        }

        int[][] sum = new int[2][n * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[0][k] = arr[0][i] + arr[1][j];
                sum[1][k++] = arr[2][i] + arr[3][j];
            }
        }
        Arrays.sort(sum[0]);
        Arrays.sort(sum[1]);

        long count = 0;
        int pointer1 = 0;
        int pointer2 = n * n -1;
        while (true) {
            if (sum[0][pointer1] + sum[1][pointer2] < 0){
                if (pointer1 == n * n - 1) break;
                pointer1++;
            }
            else if (sum[0][pointer1] + sum[1][pointer2] > 0){
                if(pointer2 == 0) break;
                pointer2--;
            }
            else {
                long temp1 = 1;
                while (pointer1 < n * n - 1 && sum[0][pointer1] == sum[0][pointer1 + 1]){
                    pointer1++;
                    temp1++;
                }

                long temp2 = 1;
                while (pointer2 > 0 && sum[1][pointer2] == sum[1][pointer2 - 1]){
                    pointer2--;
                    temp2++;
                }

                count += temp1 * temp2;

                if(pointer1 == n * n - 1 && pointer2 == 0) break;
                if(pointer1 < n * n - 1) pointer1++;
                if(pointer2 > 0) pointer2--;
            }
        }

        System.out.println(count);
    }



    public static int read() throws IOException {
        int res = 0;
        int mod = 1;

        while (true) {
            int n = br.read();
            if (n == 10 || n == 32) return res;
            if (n == 45) {
                mod = -1;
                continue;
            }
            res = res * 10 + mod * ( n - 48 );
        }
    }
}