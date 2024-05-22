import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int TC = read();
        for(int t = 0; t < TC; t++) {
            int n = read();
            int ans = 1;
            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < n; i++) {
                String type = br.readLine().split(" ")[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            for(String type: map.keySet()){
                ans *= map.get(type) + 1;
            }
            sb.append(ans - 1).append("\n");
        }
        System.out.println(sb);
        br.close();
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