import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = read();
        int remain = N % 5;
        int ans = 0;
        switch (remain) {
            case 1:
                ans += 2;
                N -= 6;
                break;

            case 2:
                ans += 4;
                N -= 12;
                break;

            case 3:
                ans += 1;
                N -= 3;
                break;

            case 4:
                ans += 3;
                N -= 9;
                break;
            
            default:
                break;
        }
        
        if(N < 0) ans = -1;
        else ans += N / 5;

        System.out.println(ans);
        br.close();
    }

    static int read() throws IOException {
        int res = 0;
        while (true) {
            int n = br.read();
            if(n == 10 || n == 32) return res;
            res = 10 * res + n - 48;
        }
    }
}
