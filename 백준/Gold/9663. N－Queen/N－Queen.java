import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] arr;
    private static int res = 0;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        nQueen(0);
        System.out.println(res);
        br.close();
    }

    public static void nQueen(int n) {
        if (n == N) {
            res++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[n] = i;
            boolean check = true;
            for (int j = 0; j < n; j++){
                if(arr[j] == i
                || arr[j] + n - j == i
                || arr[j] - n + j == i) {
                    check = false;
                    break;
                }
            }
            if (check) {
                nQueen(n + 1);
            }
        }
    }
}