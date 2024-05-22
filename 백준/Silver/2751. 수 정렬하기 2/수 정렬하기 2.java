import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        
        int n = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(bufferedReader.readLine()));
        }
        Collections.sort(nums);

        bufferedReader.close();

        for(int value : nums) {
            stringBuilder.append(value).append('\n');
        }
        System.out.println(stringBuilder);
    }

}