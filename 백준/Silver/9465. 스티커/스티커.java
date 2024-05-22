import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        int T = read();
        for (int i = 0; i < T; i++) {
            stringBuilder.append(sticker()).append("\n");
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    static int read() throws Exception {
        int res = 0;
        while (true) {
            int pointer = bufferedReader.read();
            if (pointer == 32 || pointer == 10) {
                return res;
            }
            res = 10 * res + pointer - 48;
        }
    }

    static int sticker() throws Exception {
        int N = read();
        int[][] arr = new int[N + 1][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= N; j++) {
                arr[j][i] = read();
            }
        }

        for (int i = 1; i <= N; i++) {
            if (i == 1) continue;
            for (int j = 0; j < 2; j++) {
                arr[i][Math.abs(j - 1)] += Math.max(arr[i - 1][j], arr[i - 2][j]);
            }
        }

        return Math.max(arr[N][0], arr[N][1]);
    }
}