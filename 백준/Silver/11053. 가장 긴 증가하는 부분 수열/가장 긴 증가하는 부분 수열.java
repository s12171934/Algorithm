import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[N];
        int[] dp = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = read();
        }

        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            int pointer = 0;
            while (true) {
                if(dp[pointer] == 0) {
                    dp[pointer] = arr[i];
                    result = pointer;
                    break;
                }
                if(dp[pointer] < arr[i]) {
                    pointer++;
                }
                else {
                    dp[pointer] = Math.min(dp[pointer], arr[i]);
                    break;
                }
            }
        }

        System.out.println(result + 1);
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