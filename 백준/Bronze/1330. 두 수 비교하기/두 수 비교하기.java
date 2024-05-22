import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        bufferedReader.close();

        int a = Integer.parseInt(str.split(" ")[0]);
        int b = Integer.parseInt(str.split(" ")[1]);
        
        String result = "==";
        
        if (a > b) {
            result = ">";
        }
        if (a < b) {
            result = "<";
        }

        System.out.println(result);
    }
}