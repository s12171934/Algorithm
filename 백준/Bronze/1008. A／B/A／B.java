import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        bufferedReader.close();

        String[] nums = str.split(" ");

        System.out.println(Double.parseDouble(nums[0]) / Integer.parseInt(nums[1]));
    }
}