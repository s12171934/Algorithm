import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] list = new int[n][2];
        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            list[i] = new int[]{Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())};
        }

        Arrays.sort(list, (l1, l2) -> {
            if (l1[1] - l2[1] == 0) {
                return l1[0] - l2[0];
            }
            return l1[1] - l2[1];
        });

        int count = 0;
        int pointer = 0;

        while(pointer != n){
            int end = list[pointer][1];

            for (pointer = pointer + 1; pointer < n; pointer++) {
                if (list[pointer][0] >= end) {
                    break;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}