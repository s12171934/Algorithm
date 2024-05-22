import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int[] mem;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        mem = new int[11];
        mem[0] = 1;
        mem[1] = 1;
        mem[2] = 2;

        for (int i = 0; i < n; i++) {
            stringBuilder.append(oneTwoThree(Integer.parseInt(bufferedReader.readLine()))).append("\n");
        }

        bufferedReader.close();

        System.out.println(stringBuilder);
    }

    static int oneTwoThree(int n) {
        if (mem[n] == 0) {
            mem[n] = oneTwoThree(n - 1) + oneTwoThree(n -2) + oneTwoThree(n - 3);
        }

        return mem[n];
    }
}