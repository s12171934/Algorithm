import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] A = new int[N];
        for(int i = 0; i < N; i++) A[i] = read();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(A[0]);

        for(int i = 1; i < N; i++) {
            if(res.get(res.size() - 1) < A[i]) res.add(A[i]);
            else if(res.get(res.size() - 1) > A[i]) {
                int s = 0;
                int e = res.size() - 1;

                while (s < e) {
                    int m = (s + e) / 2;

                    if(res.get(m) < A[i]) s = m + 1;
                    else e = m;
                }
                res.set(e, A[i]);
            }
        }

        System.out.println(res.size());
        bufferedReader.close();
    }

    public static int read() throws Exception {
        int res = 0;
        int mode = 1;
        while (true) {
            int r = bufferedReader.read();
            if(r == 10 || r == 32) return res;
            if(r == 45) {
                mode = -1;
                continue;
            }
            res = 10 * res + mode * (r - 48);
        }
    }
}