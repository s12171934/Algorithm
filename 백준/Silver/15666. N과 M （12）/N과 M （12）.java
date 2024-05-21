import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = read();
        arr = Arrays.stream(arr).distinct().sorted().toArray();
        makeNM(arr, 0, M, "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void makeNM(int[] arr, int startIdx, int count, String str) throws Exception {
        if(count == 0) {
            bw.write(str + "\n");
            return;
        }
        for(int i = startIdx; i < arr.length; i++) {
            String newStr = str + arr[i] + " ";
            makeNM(arr, i, count - 1, newStr);
        }
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