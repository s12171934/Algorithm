import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int sum = 0;
        int max = 0;

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            sum += num;
            max = Math.max(max, num);
        }

        System.out.println(((double)sum / max * 100) / n );

        bufferedReader.close();
    }
}