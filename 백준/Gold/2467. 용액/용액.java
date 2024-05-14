import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = read();
        int startP = 0;
        int endP = N - 1;
        int sum = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (startP < endP) {
            int sum1 = arr[startP] + arr[endP];
            if(Math.abs(sum1) < Math.abs(sum)) {
                sum = sum1;
                result[0] = arr[startP];
                result[1] = arr[endP];
            }
            if(sum1 > 0) endP--;
            else if(sum1 < 0) startP++;
            else break;
        }

        System.out.println(result[0] + " " + result[1]);
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