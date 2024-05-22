import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int r = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        System.out.println(findZ(n, r, c, 0));
    }

    static int findZ (int n, int r, int c, int count) {
        if (n == 1) {
            return count + 2 * r + c;
        }

        int t = 0;

        if (r / (int)Math.pow(2,n - 1) == 1) {
            t += 2;
            r %= (int)Math.pow(2,n - 1);
        }

        if (c / (int)Math.pow(2,n - 1) == 1) {
            t += 1;
            c %= (int)Math.pow(2,n - 1);
        }

        count += t * (int)Math.pow(4, n - 1);

        return findZ(n - 1, r, c, count);
    }

}