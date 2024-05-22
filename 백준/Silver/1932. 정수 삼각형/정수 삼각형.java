import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int N = read();
        int max = 0;
        int[] triangle = new int[N + 1];
        int[] prev = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                triangle[j] = read() + Math.max(prev[j - 1], prev[j]);
            }
            prev = triangle.clone();
        }

        for (int t : triangle) {
            max = Math.max(max, t);
        }

        System.out.println(max);
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
}