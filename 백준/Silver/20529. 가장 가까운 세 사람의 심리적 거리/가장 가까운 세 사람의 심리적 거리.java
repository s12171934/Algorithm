import javax.print.DocFlavor;
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int TC = read();
        for(int t = 0; t < TC; t++) {
            int N = read();
            if(N > 32) {
                bw.write(0 + "\n");
                continue;
            }
            String[] arr = br.readLine().split(" ");
            int min = 8;
            for(int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    for(int k = j + 1; k < N; k++){
                        int len = 0;
                        for(int c = 0; c < 4; c++){
                            if(arr[i].charAt(c) == arr[j].charAt(c) && arr[j].charAt(c) == arr[k].charAt(c)) continue;
                            len += 2;
                        }
                        min = Math.min(min, len);
                    }
                }
            }
            bw.write(min + "\n");
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