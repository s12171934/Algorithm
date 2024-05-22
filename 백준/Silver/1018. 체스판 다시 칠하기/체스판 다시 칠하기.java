import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        char[][] plate = new char[n][m];

        for (int i = 0; i < n; i++) {
            plate[i] = bufferedReader.readLine().toCharArray();
        }

        int result = 64;

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int count = 0;

                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if((k + l) % 2 == 0 && plate[k][l] == 'B'){
                            count++;
                        }
                        if((k + l) % 2 == 1 && plate[k][l] == 'W'){
                            count++;
                        }
                    }
                }

                count = Math.min(count, 64 - count);
                result = Math.min(result, count);
            }
        }

        System.out.println(result);
        bufferedReader.close();
    }
}