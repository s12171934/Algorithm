import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] mem = new int[100];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        mem[1] = 1;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(num == 0 ? 1 : fibonacci(num - 1)).append(" ").append(fibonacci(num)).append("\n");
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    static int fibonacci(int n) {
        if (n < 2 || mem[n] != 0) {
            return mem[n];
        }
        mem[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return mem[n];
    }
}