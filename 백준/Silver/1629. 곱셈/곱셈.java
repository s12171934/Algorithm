import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int A = read();
        int B = read();
        int C = read();

        System.out.println(pow(A,B,C));
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

    static long pow (int A, int B, int C) {
        if (B == 0) return 1;
        long prev = pow(A,  B / 2, C);
        return ((prev * prev % C) * (B % 2 == 0 ? 1 : A)) % C;
    }
}