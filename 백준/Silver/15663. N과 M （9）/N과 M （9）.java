import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);

        sequence("", M, new boolean[N]);
        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    static void sequence(String prev, int M, boolean[] check) {
        String temp;
        int k = 0;
        for (int i = 0; i < N; i++) {
            if(check[i]) continue;
            if(arr[i] == k) continue;
            temp = prev + arr[i] + " ";
            k = arr[i];
            if (M == 1) {
                stringBuilder.append(temp).append("\n");
            }
            else {
                boolean[] clone = check.clone();
                clone[i] = true;
                sequence(temp,M - 1, clone);
            }
        }
    }
}