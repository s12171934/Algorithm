import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = read();
        boolean[] list = new boolean[N + 1];
        list[0] = true;
        list[1] = true;

        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(0);
        for (int i = 2; i <= N; i++) {
            if (list[i]) continue;
            primes.add(i);
            int count = 2;
            while (i * count <= N) {
                list[i * count++] = true;
            }
        }

        long[] primeSum = new long[primes.size()];
        primeSum[0] = primes.get(0);
        for (int i = 1; i < primes.size(); i++) {
            primeSum[i] = primeSum[i - 1] + (long)primes.get(i);
        }

        int count = 0;
        int pointer = 0;
        for (int i = 1; i < primeSum.length; i++) {
            if (primeSum[i] < N) continue;
            while (true) {
                if (primeSum[i] - primeSum[pointer] == N) {
                    count++;
                    break;
                }
                else if (primeSum[i] - primeSum[pointer] < N) {
                    break;
                }
                pointer++;
            }
        }

        System.out.println(count);
    }

    public static int read() throws IOException {
        int res = 0;
        while (true) {
            int r = br.read();
            if (r == 10 || r == 32) return res;
            if (r == 13) continue;
            res = 10 * res + (r - 48);
        }
    }
}