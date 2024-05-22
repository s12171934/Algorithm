import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int blue = 0;
    static int white = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int n = Integer.parseInt(bufferedReader.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        cut(0, n - 1, 0, n - 1);


        System.out.println(white + "\n" + blue);

        bufferedReader.close();
    }

    static void cut(int x1, int x2, int y1, int y2) {
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                sum += paper[j][i];
            }
        }

        if (sum == 0) {
            white++;
        }
        else if (sum == (x2 - x1 + 1) * (y2 - y1 + 1)) {
            blue++;
        }
        else {
            cut(x1, (x1 + x2) / 2, y1, (y1 + y2) / 2);
            cut((x1 + x2) / 2 + 1, x2, y1, (y1 + y2) / 2);
            cut(x1, (x1 + x2) / 2, (y1 + y2) / 2 + 1, y2);
            cut((x1 + x2) / 2 + 1, x2, (y1 + y2) / 2 + 1, y2);
        }
    }
}