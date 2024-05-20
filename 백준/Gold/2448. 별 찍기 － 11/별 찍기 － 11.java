import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] draw;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        draw = new boolean[N][N * 2 - 1];
        int times = (int)(Math.log(N / 3) / Math.log(2));
        fractal(0, 0, times);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N * 2 -1; j++) {
                sb.append(draw[i][j] ? "*" : " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void fractal(int y, int x, int times) {
        if(times == 0) {
            draw[y][x + 2] = true;
            for(int i : new int[]{1,3}) draw[y + 1][x + i] = true;
            for(int i = 0; i < 5; i++) draw[y + 2][x + i] = true;
            return;
        }

        fractal(y, x + 3 * (int)Math.pow(2, times - 1), times - 1);
        fractal(y + 3 * (int)Math.pow(2, times - 1), x, times - 1);
        fractal(y + 3 * (int)Math.pow(2, times - 1), x + 3 * (int)Math.pow(2, times), times - 1);
    }
}