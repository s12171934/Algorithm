import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        bufferedReader.close();

        int gcf = gcf(a,b);

        System.out.println(gcf + "\n" + a * b / gcf);
    }

    static int gcf(int a, int b) {
        while (true) {
            if (b > a) {
                int temp = a;
                a = b;
                b = temp;
            }

            if (a % b == 0) {
                return b;
            }
            else {
                a = a - b;
            }
        }
    }
}