import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        sequence("", M, 1, N - M + 1);
        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    static void sequence(String prev, int M, int start, int end) {
        String temp;
        for (int i = start; i <= end; i++) {
            temp = prev + i + " ";
            if (M == 1) {
                stringBuilder.append(temp).append("\n");
            }
            else {
                sequence(temp,M - 1, i + 1, end + 1);
            }
        }
    }
}