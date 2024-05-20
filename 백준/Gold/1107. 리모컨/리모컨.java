import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        boolean[] arr = new boolean[10];
        for(int i = 0; i < M; i++) arr[read()] = true;
        int ans = Math.abs(N - 100);

        if(M != 10){
            for(int step : new int[]{-1, 1}) {
                int num = N;
                while (num >= 0 && num < 1000000) {
                    boolean check = true;
                    for (int c : String.valueOf(num).toCharArray()) {
                        if(arr[c - 48]) {
                            num += step;
                            check = false;
                            break;
                        }
                    }
                    if(check) break;
                }
                if(num == -1) num = 100;
                ans = Math.min(ans, Math.abs(N - num) + String.valueOf(num).length());
            }
        }

        System.out.println(ans);
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