import java.io.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        long[][] arr = new long[7][2];
        int res = 1;
        for (int i = 0; i < 2; i++) {
           for (int j = 0; j < 4; j++) {
               arr[j][i] = read();
           }
           arr[4][i] = arr[3][i] - arr[1][i];
           arr[5][i] = arr[2][i] - arr[0][i];
           arr[6][i] = arr[4][i] * arr[0][i] - arr[5][i] * arr[1][i];
        }

        for (int i = 0; i < 2; i++) {
            long x = arr[4][i];
            long y = arr[5][i];
            long c = arr[6][i];
            long a = x * arr[0][1 - i] - y * arr[1][1 - i] - c;
            long b = x * arr[2][1 - i] - y * arr[3][1 - i] - c;
            boolean isCross = a == 0 || b == 0 || (a > 0 && b < 0) || (a < 0 && b > 0);
            if (!isCross) {
                res = 0;
                break;
            }
        }

        boolean sameSlope = arr[5][0] == 0 && arr[5][1] == 0;
        if (arr[5][0] != 0 && arr[5][1] != 0 && arr[4][0] * arr[5][1] == arr[4][1] * arr[5][0]) sameSlope = true;
        if ((arr[5][0] == 0 && arr[5][1] == 0) || sameSlope && arr[6][0] / (double)arr[5][0] - arr[6][1] / (double)arr[5][1] < 1e-9) {
            if (Math.max(arr[0][0],arr[2][0]) < Math.min(arr[0][1],arr[2][1])) res = 0;
            if (Math.max(arr[0][1],arr[2][1]) < Math.min(arr[0][0],arr[2][0])) res = 0;
            if (Math.max(arr[1][0],arr[3][0]) < Math.min(arr[1][1],arr[3][1])) res = 0;
            if (Math.max(arr[1][1],arr[3][1]) < Math.min(arr[1][0],arr[3][0])) res = 0;
        }


        System.out.println(res);
        bufferedReader.close();
    }
    public static int read() throws Exception {
        int res = 0;
        int mode = 1;
        while (true) {
            int n = bufferedReader.read();
            if (n == 10 || n == 32) return res;
            if (n == 45) {
                mode = -1;
                continue;
            }
            res = res * 10 + mode * (n - 48);
        }
    }
}