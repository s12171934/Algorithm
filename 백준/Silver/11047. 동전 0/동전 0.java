import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int n = read();
        int k = read();
        int ans = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = read();
        for(int i = n - 1; i >= 0; i--) {
            if(k == 0) break;
            ans += k / arr[i];
            k = k % arr[i];
        }

        System.out.println(ans);
        br.close();
    }

    public static int read() throws Exception {
        int res = 0;
        while (true) {
            int r = br.read();
            if(r == 10 || r == 32) return res;
            res = 10 * res + r - 48;
        }
    }
}