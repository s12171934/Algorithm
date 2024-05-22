import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int [][] rgb = new int[3][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            rgb[0][i] = Math.min(rgb[1][i - 1], rgb[2][i - 1]) + Integer.parseInt(stringTokenizer.nextToken());
            rgb[1][i] = Math.min(rgb[0][i - 1], rgb[2][i - 1]) + Integer.parseInt(stringTokenizer.nextToken());
            rgb[2][i] = Math.min(rgb[1][i - 1], rgb[0][i - 1]) + Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(Math.min(Math.min(rgb[0][N], rgb[1][N]), rgb[2][N]));

        bufferedReader.close();
    }
}