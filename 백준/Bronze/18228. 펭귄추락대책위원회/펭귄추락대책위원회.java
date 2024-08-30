import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int read() throws Exception {
        if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
    
    public static void main(String[] args) throws Exception {
        int N = read();
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < N; i++) {
            int cur = read();
            if (cur == -1) {
                res += min;
                min = Integer.MAX_VALUE;
                continue;
            }
            min = Math.min(min, cur);
        }
        System.out.print(res + min);
    }
}
