import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] draw;
    public static void main(String[] args) throws Exception {
        int TC = read();

        for(int i = 0; i < TC; i++) {
            int H = read();
            int W = read();
            int N = read();

            String ans = (N % H == 0 ? H + String.format("%02d", N / H) : N % H + String.format("%02d", (N / H) + 1)) + "\n";
            bw.write(ans);
        }

        bw.flush();
        bw.close();
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