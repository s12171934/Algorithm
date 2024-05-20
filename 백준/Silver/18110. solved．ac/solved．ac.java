import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = read();
        int ans = 0;
        if(n > 0) ans = solveAC(n);
        System.out.println(ans);
        br.close();
    }

    public static int solveAC(int n) throws Exception{
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);
        int start = (int)Math.round(n * 0.15);
        int end = (n - 1) - start;
        int ans = IntStream.rangeClosed(start,end).map(i -> arr[i]).sum();
        return (int)Math.round((double)ans / (end - start + 1));

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