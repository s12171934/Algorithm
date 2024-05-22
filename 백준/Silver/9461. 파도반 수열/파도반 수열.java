import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int TC = read();
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        for(int i = 6; i <= 100; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }
        for(int t = 0; t < TC; t++) {
            sb.append(arr[read()]).append("\n");
        }
        System.out.println(sb);
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