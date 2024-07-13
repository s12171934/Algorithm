import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int TC = read();

        for (int t = 0; t < TC; t++) {
            int n = read();
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int count = 0;

            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                if (s[0].equals("I")) {
                    map.put(Integer.parseInt(s[1]), map.getOrDefault(Integer.parseInt(s[1]), 0) + 1);
                    count++;
                }
                else {
                    if (map.isEmpty()) continue;

                    if (s[1].equals("1")) {
                        int after = map.put(map.lastKey(), map.get(map.lastKey()) - 1);
                        if (after == 1) {
                            map.remove(map.lastKey());
                        }
                    }
                    else {
                        int after = map.put(map.firstKey(), map.get(map.firstKey()) - 1);
                        if (after == 1) {
                            map.remove(map.firstKey());
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            }
            else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }

    public static int read() throws Exception {
        int res = 0;
        while (true) {
            int r = br.read();
            if(r == 10 || r == 32) return res;
            res = 10 * res + r - 48;
        }
    }
}