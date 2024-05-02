import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static Map<Long,Long> map = new HashMap<>();
    static long div = 1000000007;
    public static void main(String[] args) throws Exception {
        long n = read();
        map.put(0L, 0L);
        map.put(1L, 1L);
        System.out.println(fib(n));
        bufferedReader.close();
    }

    static long fib (long n) {
        if (map.containsKey(n)) return map.get(n);

        long result;
        if (n % 2 == 0) {
            result = (fib(n / 2) * (fib(n / 2) + 2 * fib(n / 2 - 1))) % div;
        }
        else {
            result = (fib(n / 2) * fib(n / 2) + fib(n / 2 + 1)* fib(n / 2 + 1)) % div;
        }
        map.put(n,result);
        return result;
    }

    static long read() throws Exception {
        long res = 0;
        while (true) {
            int pointer = bufferedReader.read();
            if (pointer == 32 || pointer == 10) {
                return res;
            }
            res = 10 * res + pointer - 48;
        }
    }
}