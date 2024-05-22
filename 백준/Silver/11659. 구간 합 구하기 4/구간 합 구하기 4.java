import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;
        String[] str = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (i != 0) {
                arr[i] += arr[i -1];
            }
        }


        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            int sum = arr[end - 1];

            if (start != 1) {
                sum -= arr[start - 2];
            }

            stringBuilder.append(sum).append("\n");
        }

        System.out.println(stringBuilder);

        bufferedReader.close();
    }
}