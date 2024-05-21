import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int exp = 1;
        while (Math.pow(5, exp) <= N) ans += N / (int)Math.pow(5, exp++);
        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }
}