import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str;

        int max = 0;
        int idx = 0;
        int count = 0;

        while (true) {
            str = bufferedReader.readLine();

            if (str == null) {
                break;
            }

            int n = Integer.parseInt(str);
            count++;

            if (max < n) {
                max = n;
                idx = count;
            }
        }

        System.out.println(max);
        System.out.println(idx);

        bufferedReader.close();
    }
}