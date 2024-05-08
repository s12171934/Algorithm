import java.io.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static int[] arr;
    public static void main(String[] args) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        int N = read();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = read();
        int M = read();
        for (int i = 0; i < M; i++) {
            int S = read();
            int E = read();
            stringBuilder.append(palindrome(S, E)).append("\n");
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    public static int read() throws Exception {
        int res = 0;
        while (true) {
            int n = bufferedReader.read();
            if (n == 10 || n == 32) return res;
            res = res * 10 + n - 48;
        }
    }

    public static int palindrome (int S, int E) {
        while (S <= E) {
            if (arr[S] != arr[E]) {
                return 0;
            }
            S++;
            E--;
        }
        return 1;
    }
}