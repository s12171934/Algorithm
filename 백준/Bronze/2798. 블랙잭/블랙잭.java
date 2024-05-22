import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int result = 0;

        String[] nums = bufferedReader.readLine().split(" ");

        for (int i = 0; i < n - 2; i++) {
            int numI = Integer.parseInt(nums[i]);
            for (int j = i + 1; j < n - 1; j++) {
                int numJ = Integer.parseInt(nums[j]);
                if (numI + numJ >= m) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    int numK = Integer.parseInt(nums[k]);
                    if (numI + numJ + numK <= m) {
                        result = Math.max(result, numI + numJ + numK);
                    }
                }
            }
        }

        System.out.println(result);

        bufferedReader.close();
    }
}