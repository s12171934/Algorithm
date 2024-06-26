import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();
        int k = read();

        int[] arr = new int[m];
        boolean[] check = new boolean[m];
        for (int i = 0; i < m; i++) arr[i] = read();
        Arrays.sort(arr);

        for (int tc = 0; tc < k; tc++) {
            int target = read();
            int s = 0;
            int e = m - 1;
            while (s < e) {
                int mid = (s + e) / 2;
                if (arr[mid] == target) {
                    e = mid + 1;
                    break;
                } else if (arr[mid] < target) {
                    s = mid + 1;
                } else {
                    e = mid;
                }
            }
            while (check[e]) e++;
            check[e] = true;
            System.out.println(arr[e]);
        }
    }


    public static int read() throws IOException {
        int res = 0;

        while (true) {
            int n = br.read();
            if (n == 10 || n == 32) return res;
            res = res * 10 + n - 48;
        }
    }
}