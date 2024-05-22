import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            int num = bufferedReader.read() - 48;
            result += num;
        }

        System.out.println(result);
        
        bufferedReader.close();
    }
}