import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[N];
        int[][] dp = new int[N][2];
        for (int i = 0; i < N; i++) arr[i] = read();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
           if(list.isEmpty() || list.get(list.size()-1) < arr[i]) list.add(arr[i]);
           else {
               for (int j = 0; j < list.size(); j++) {
                   if(list.get(j) >= arr[i]) {
                       list.set(j, arr[i]);
                       break;
                   }
               }
           }
           dp[i][0] = list.size();
        }

        list = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            if(list.isEmpty() || list.get(list.size()-1) < arr[i]) list.add(arr[i]);
            else {
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j) >= arr[i]) {
                        list.set(j, arr[i]);
                        break;
                    }
                }
            }
            dp[i][1] = list.size();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i][0] + dp[i][1] - 1);
        }
        System.out.println(ans);
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
