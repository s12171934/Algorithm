import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = bufferedReader.readLine();
            if(str == null || str.equals("0 0 0")) break;
            System.out.println(rightTriangle(str) ? "right" : "wrong");
        }

        bufferedReader.close();
    }

    static boolean rightTriangle(String str) {
        String[] nums = str.split(" ");
        double a = Math.pow(Integer.parseInt(nums[0]),2);
        double b = Math.pow(Integer.parseInt(nums[1]),2);
        double c = Math.pow(Integer.parseInt(nums[2]),2);

        return a + b == c || b + c == a || c + a == b;
    }
}