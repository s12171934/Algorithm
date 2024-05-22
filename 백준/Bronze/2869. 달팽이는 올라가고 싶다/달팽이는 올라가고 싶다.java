import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int A = read();
        int B = read();
        int V = read();
        System.out.println((int)Math.ceil((double)(V - B) / (A - B)));
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