import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        while (true) {
            int n = br.read();
            if(n == 10) break;
            if(n < 97) n -= 65;
            else n -= 97;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int key = 0;
        int value = 0;
        for(int alphabet : map.keySet()) {
            if(map.get(alphabet) > value) {
                key = alphabet;
                value = map.get(alphabet);
            }
            else if(map.get(alphabet) == value) {
                key = '?' - 65;
            }
        }

        System.out.println((char)(key + 65));
        br.close();
    }

    static int read() throws IOException {
        int res = 0;
        while (true) {
            int n = br.read();
            if(n == 10 || n == 32) return res;
            res = 10 * res + n - 48;
        }
    }
}
