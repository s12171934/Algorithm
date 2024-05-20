import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] draw;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        draw = new char[N][N * 2 - 1];
        for(char[] s : draw) Arrays.fill(s, ' ');
        int times = (int)(Math.log(N / 3) / Math.log(2));
        fractal(0, 0, times);

        for(char[] s : draw) {
            bw.write(s);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void fractal(int y, int x, int times) {
        if(times == 0) {
            draw[y][x + 2] = '*';
            for(int i : new int[]{1,3}) draw[y + 1][x + i] = '*';
            for(int i = 0; i < 5; i++) draw[y + 2][x + i] = '*';
            return;
        }

        fractal(y, x + 3 * (int)Math.pow(2, times - 1), times - 1);
        fractal(y + 3 * (int)Math.pow(2, times - 1), x, times - 1);
        fractal(y + 3 * (int)Math.pow(2, times - 1), x + 3 * (int)Math.pow(2, times), times - 1);
    }
}