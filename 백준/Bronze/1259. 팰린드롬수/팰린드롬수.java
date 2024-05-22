import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = bufferedReader.readLine();
            if(str.equals("0")) break;

            String result = "yes";

            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - i - 1)){
                    result = "no";
                    break;
                }
            }

            System.out.println(result);

        }

        bufferedReader.close();
    }
}