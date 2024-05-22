import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        System.out.println(combination(n,k));

        bufferedReader.close();
    }

    static int combination(int n, int k) {
        double prod = 1;
        for (int i = 0; i < k; i++) {
            prod *= (double)(n - i) / (i + 1);
        }
        return (int)prod;
    }
}