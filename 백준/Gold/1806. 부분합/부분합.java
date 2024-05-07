import java.io.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int S, N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        N = read();
        S = read();
        arr = new int[N];
        arr[0] = read();
        for (int i = 1; i < N; i++) {
            arr[i] = read() + arr[i -1];
        }

        if(arr[N - 1] < S) {
            System.out.println(0);
        }
        else {
            System.out.println(subtotalLength());
        }

        bufferedReader.close();
    }

    static int subtotalLength() {
        int min = 100000;
        int j;
        for (j = 0; j < N - 1; j++) {
            if (arr[N - 1] - arr[j] < S) break;
            if (arr[N - 1] - arr[j + 1] >= S) continue;
            min = Math.min(min, N - 1- j);
            break;
        }
        for (int i = N - 1; i >= 0 && arr[i] >= S; i--) {
            while (j >= 0 && arr[i] - arr[j] < S) {
                j--;
            }
            min = Math.min(min, i - j);
        }
        return min;
    }

    static int read() throws Exception {
        int res = 0;
        int sign = 1;
        while (true) {
            int pointer = bufferedReader.read();
            if (pointer == 32 || pointer == 10) {
                return res;
            }
            if (pointer == 45){
                sign = -1;
                continue;
            }
            res = 10 * res + sign * (pointer - 48);
        }
    }
}