import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    public static void main(String[] args) throws Exception {
        int N = read();
        int S = read();
        arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = read();
        System.out.println(find(N,S));
        bufferedReader.close();
    }

    public static long find(int N, int S) {
        if(N == 1) return arr[0] == S ? 1 : 0;
        HashMap<Long, Long> map1 = new HashMap<>();
        makeList(0, 0, N / 2, map1);
        HashMap<Long, Long> map2 = new HashMap<>();
        makeList(0, N / 2, N, map2);
        long count = S == 0 ? -1 : 0;

       for (long sum1 : map1.keySet()) {
           if (map2.containsKey(S - sum1)) {
               count += map1.get(sum1) * map2.get(S - sum1);
           }
       }

        return count;
    }

    public static void makeList(long sum, int start, int end, HashMap<Long, Long> map) {
        if(start == end) {
            map.put(sum, map.getOrDefault(sum, 0L) + 1);
            return;
        }
        makeList(sum, start + 1, end, map);
        makeList(sum + arr[start], start + 1, end, map);
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