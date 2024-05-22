import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int H = read();
        int M = read();

        int newM = (M + 15) % 60;
        int newH = H;
        if(newM > M) newH = (H + 23) % 24;

        System.out.println(newH + " " + newM);
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
