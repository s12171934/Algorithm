import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            map.put(str[0], str[1]);
        }
        for(int i = 0; i < m; i++) {
            bw.write(map.get(br.readLine()) + "\n");
        }

        bw.flush();
        bw.close();
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