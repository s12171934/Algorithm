import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        String[] nums = bufferedReader.readLine().split(" ");

        for (String num : nums) {
            int n = Integer.parseInt(num);

            if (n == 1) {
                count--;
                continue;
            }

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0){
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
        bufferedReader.close();
    }
}