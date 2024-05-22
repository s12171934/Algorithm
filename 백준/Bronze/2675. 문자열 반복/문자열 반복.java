import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        String[] str;

        for (int i = 0; i < t; i++) {
            str = bufferedReader.readLine().split(" ");
            int p = Integer.parseInt(str[0]);
            String s = str[1];

            String result = "";
            for (int j = 0; j < s.length(); j++) {
                result += String.valueOf(s.charAt(j)).repeat(p);
            }
            System.out.println(result);
        }
        
        bufferedReader.close();
    }
}