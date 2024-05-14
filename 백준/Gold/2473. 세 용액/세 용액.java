import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int N = read();
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = read();
        Arrays.sort(arr);
        long sum = 3_000_000_000L;
        long[] result = new long[3];

        for(int startP = 0; startP < N - 2; startP++) {
            int midP = startP + 1;
            int endP = N - 1;

            while (midP < endP) {
                long sum1 = arr[startP] + arr[midP] + arr[endP];
                if(Math.abs(sum1) < Math.abs(sum)) {
                    sum = sum1;
                    result[0] = arr[startP];
                    result[1] = arr[midP];
                    result[2] = arr[endP];
                }
                if(sum1 > 0) endP--;
                else if(sum1 < 0) midP++;
                else break;
            }
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
        bufferedReader.close();
    }

    public static int read() throws Exception {
        int res = 0;
        int mode = 1;
        while (true) {
            int r = bufferedReader.read();
            if(r == 10 || r == 32) return res;
            if(r == 45) {
                mode = -1;
                continue;
            }
            res = 10 * res + mode * (r - 48);
        }
    }
}