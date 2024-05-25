import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int TC = read();
        for(int t = 0; t < TC; t++) {
            char[] arr = br.readLine().toCharArray();
            int score = 1;
            int result = 0;
            for(char c: arr){
                if(c == 'O') {
                    result += score;
                    score++;
                }
                else {
                    score = 1;
                }
            }

            sb.append(result).append("\n");
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