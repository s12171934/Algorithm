import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int N = read();
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            arr[i][0] = read();
            arr[i][1] = read();
            arr[i][2] = read();
        }

        int[] maxArr = arr[N - 1].clone();
        int[] minArr = arr[N - 1].clone();

        for (int i = N - 2; i >= 0; i--) {
            int maxL = Math.max(maxArr[0], maxArr[1]);
            int maxR = Math.max(maxArr[1], maxArr[2]);
            maxArr[0] = arr[i][0] + maxL;
            maxArr[1] = arr[i][1] + Math.max(maxL, maxR);
            maxArr[2] = arr[i][2] + maxR;

            int minL = Math.min(minArr[0], minArr[1]);
            int minR = Math.min(minArr[1], minArr[2]);
            minArr[0] = arr[i][0] + minL;
            minArr[1] = arr[i][1] + Math.min(minL, minR);
            minArr[2] = arr[i][2] + minR;
        }

        int resMax = Math.max(Math.max(maxArr[0], maxArr[1]), maxArr[2]);
        int resMin = Math.min(Math.min(minArr[0], minArr[1]), minArr[2]);

        System.out.println(resMax + " " + resMin);

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